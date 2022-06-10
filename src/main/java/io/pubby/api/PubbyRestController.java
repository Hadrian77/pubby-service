package io.pubby.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pubby.data.DataService;
import io.pubby.models.AnswerRecord;
import io.pubby.models.Player;
import io.pubby.models.PlayerResponse;
import io.pubby.models.Question;
import io.pubby.models.Session;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;


@RestController
@RequestMapping("api")
public class PubbyRestController {

	@Autowired
	DataService dataService;

	@GetMapping("/questions")
	public Flux<Question> getQuestions() {


		return dataService.getQuestions();

	}

	@PostMapping("/questions")
	public Flux<Question> createQuestions(@RequestBody List<Question> questions) {

		return dataService.saveQuestions(questions);

	}

	@GetMapping("/players")
	public Flux<Player> getAllPlayersInSession(@RequestHeader("X-Session") String sessionId) {

		return dataService.getPlayersBySessionId(sessionId);

	}

	@GetMapping("/players/{playerId}")
	public Mono<Player> getPlayerById(@PathVariable String playerId) {

		return dataService.getPlayerById(playerId);

	}

	@PostMapping("/players")
	public Mono<Player> createPlayer(@RequestBody Player player, @RequestHeader("X-Session") String sessionId) {

		Mono<Tuple2<Player, Session>> playerAndSession = Mono.zip(dataService.savePlayer(player),
				dataService.getSession(sessionId));

		return playerAndSession.map(result -> {

			result.getT1().setSession(result.getT2());
			return result.getT1();
		});

	}

	@GetMapping("/questions/{questionId}/answers")
	public Mono<AnswerRecord> getAnswer(@PathVariable String questionId, @RequestHeader("X-Session") String sessionId) {

		return dataService.getAnswerRecordByQuestionId(questionId, sessionId);

	}

	@PostMapping("/questions/{questionId}/answers")
	public Mono<Object> createAnswerRecord(@RequestBody AnswerRecord answerRecord, @PathVariable String questionId,
			@RequestHeader("X-Session") String sessionId) {

		Mono<Tuple2<Question, Session>> questionAndSession = Mono
				.zip(dataService.getQuestion(questionId), dataService.getSession(sessionId));

		return questionAndSession.map(result -> {

			answerRecord.setQuestion(result.getT1());
			answerRecord.setSession(result.getT2());
			answerRecord.setPlayerResponses(new ArrayList<PlayerResponse>());
			
			
			return dataService.saveAnswerRecord(answerRecord);
		});

	}

	@PostMapping("questions/{questionId}/answers/responses")
	public Mono<Object> createResponse(@RequestBody PlayerResponse playerResponse,
			@PathVariable String questionId, @RequestHeader("X-Session") String sessionId, @RequestHeader("X-Player") String playerId) {

		Mono<Tuple2<AnswerRecord,Player>> answerRecordAndPlayer = Mono.zip(dataService.getAnswerRecordByQuestionId(questionId, sessionId),dataService.getPlayerById(playerId));

		
		return answerRecordAndPlayer.map(result -> {

			

			
			if(result.getT1()== null) {
			
			}
			
			playerResponse.setPlayer(result.getT2());
			result.getT1().getPlayerResponses().add(playerResponse);
			result.getT1().setIsChildQuestion(false);

			
			return dataService.saveAnswerRecord(result.getT1());
		});

	}

	@GetMapping("/sessions/{sessionId}")
	public Mono<Session> getSession(@PathVariable String sessionId) {

		return dataService.getSession(sessionId);
	}

	@PostMapping("/sessions")
	public Mono<Session> createSession() {

		Session session = new Session();
		session.setTimeStamp(new Timestamp(System.currentTimeMillis()));

		return dataService.saveSession(session);
	}

}

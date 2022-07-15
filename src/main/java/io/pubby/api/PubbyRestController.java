package io.pubby.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pubby.data.DataService;
import io.pubby.models.AnswerRecord;
import io.pubby.models.ChildQuestion;
import io.pubby.models.Player;
import io.pubby.models.PlayerResponse;
import io.pubby.models.Question;
import io.pubby.models.Session;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@CrossOrigin(origins = "https://adrianharris.tech")	
@RequestMapping("api")
public class PubbyRestController {

	@Autowired
	DataService dataService;

	@GetMapping("/questions/{questionId}")
	public Mono<Question> getQuestion(@PathVariable String questionId) {

		return dataService.getQuestion(questionId);

	}

	@GetMapping("/questions")
	public Flux<Question> getQuestionsByMetaData(
			@RequestParam(required = false, defaultValue = "") List<String> keywords,
			@RequestParam(required = false, defaultValue = "") List<String> excludedKeywords,
			@RequestParam(required = false, defaultValue = "") List<String> tags,
			@RequestParam(required = false, defaultValue = "") List<String> excludedTags) {

		return dataService.getQuestionsByMetaData(keywords, excludedKeywords, tags, excludedTags);

	}

	@PostMapping("/questions")
	public Flux<Question> createQuestions(@RequestBody List<Question> questions) {

		return dataService.saveQuestions(questions);

	}
	
	@GetMapping("/questions/{questionId}/child-questions")
	public Flux<ChildQuestion> getChildQuestions(@PathVariable String questionId) {

		return dataService.getChildQuestions(questionId);

	}
	
	@PostMapping("/questions/{questionId}/child-questions")
	public Flux<ChildQuestion> createChildQuestions(@RequestBody List<ChildQuestion> childQuestions, @PathVariable String questionId) {
		
		for(ChildQuestion childQuestion : childQuestions) {
		  
			childQuestion.setParentQuestionId(questionId);	
			
			}

		return dataService.saveChildQuestions(childQuestions);

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
	public Mono<Object> createPlayer(@RequestBody Player player, @RequestHeader("X-Session") String sessionId) {

		Mono<Session> session = 
				dataService.getSession(sessionId);

		return session.map(result -> {

			player.setSessionId(result.getId());
			return dataService.savePlayer(player);
		});

	}

	@GetMapping("/answers/{questionId}")
	public Mono<AnswerRecord> getAnswer(@PathVariable String questionId, @RequestHeader("X-Session") String sessionId) {

		return dataService.getAnswerRecordByQuestionId(questionId, sessionId);

	}

	@PostMapping("/answers/{questionId}")
	public Mono<Object> createAnswerRecord(@RequestBody AnswerRecord answerRecord, @PathVariable String questionId,
			@RequestHeader("X-Session") String sessionId) {

		Mono<Tuple2<Question, Session>> questionAndSession = Mono.zip(dataService.getQuestion(questionId),
				dataService.getSession(sessionId));

		return questionAndSession.map(result -> {

			answerRecord.setQuestionId(result.getT1().getId());
			answerRecord.setSessionId(result.getT2().getId());
			answerRecord.setPlayerResponses(new ArrayList<PlayerResponse>());

			return dataService.saveAnswerRecord(answerRecord);
		});

	}

	@PostMapping("answers/{questionId}/responses")
	public Mono<Object> createResponse(@RequestBody PlayerResponse playerResponse, @PathVariable String questionId,
			@RequestHeader("X-Session") String sessionId, @RequestHeader("X-Player") String playerId) {

		
		System.out.println("In method");
		Mono<Tuple2<AnswerRecord, Player>> answerRecordAndPlayer = Mono.zip(
				dataService.getAnswerRecordByQuestionId(questionId, sessionId), dataService.getPlayerById(playerId));

		return answerRecordAndPlayer.map(result -> {

			System.out.println("In mapping");
			if (result.getT1() == null) {
				System.out.println("Result is null");
			}

			playerResponse.setPlayer(result.getT2());
			result.getT1().getPlayerResponses().add(playerResponse);
			result.getT1().setIsChildQuestion(false);
			
			System.out.println(result.getT1() + "" + result.getT2());
			return dataService.saveAnswerRecord(result.getT1());
		});

	}

	@GetMapping("/sessions/{sessionId}")
	public Mono<Session> getSession(@PathVariable String sessionId) {

		return dataService.getSession(sessionId);
	}

	@PostMapping("/sessions")
	public Mono<Session> createSession(
			@RequestParam(required = false, defaultValue = "") List<String> keywords,
			@RequestParam(required = false, defaultValue = "") List<String> excludedKeywords,
			@RequestParam(required = false, defaultValue = "") List<String> tags,
			@RequestParam(required = false, defaultValue = "") List<String> excludedTags,
			@RequestParam(required = false, defaultValue = "300") String questionAmount) {

		Session session = new Session();
		List<Question> questions = dataService.getQuestionsByMetaData(keywords, excludedKeywords, tags, excludedTags).collectList().block();

		session.setQuestionDeck(randomizeQuestions(questions, Integer.parseInt(questionAmount)));

		return dataService.saveSession(session);
	}
	
	

	public List<Question> randomizeQuestions(List<Question> questions, int questionAmount) {

		if (questions.size() <= questionAmount) {
			return questions;
		}

		else {

			List<Question> newQuestionList = new ArrayList<Question>();
			Random rand = new Random();
			int randNum;

			for (int i = 0; i < questionAmount; i++) {

				randNum = rand.nextInt(questions.size());
				newQuestionList.add(questions.get(randNum));
				questions.remove(randNum);

			}

			return newQuestionList;

		}

	}

}

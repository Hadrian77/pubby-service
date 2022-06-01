package io.pubby.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.pubby.data.DataService;
import io.pubby.models.Player;
import io.pubby.models.Question;
import io.pubby.models.Session;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PubbyController {

	@Autowired
	DataService dataService;

	@GetMapping("/questions")
	public Flux<Question> getQuestions() {

		System.out.println("Working");

		return dataService.getQuestions();

	}

	@PostMapping("/questions")
	public Flux<Question> createQuestions(@RequestBody List<Question> questions) {


		return dataService.saveQuestions(questions);

	}
	/*
	@GetMapping("/players")
	public Flux<Player> getAllPlayersInSession(@RequestHeader("X-Session")String sessionId) {
		
		
		return dataService.getPlayersBySessionId(sessionId) ;
		
		
	}

	@GetMapping("/players/{id}")
	public Mono<Player> getPlayerById(@PathVariable String playerId) {

		return dataService.getPlayerById(playerId);

	}

	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player,@RequestHeader("X-Session")String sessionId ) {

		//Session session = dataService.getSession(sessionId);
		
		//player.setSession(session);
		dataService.savePlayer(player);

		return player;

	}
	
	@GetMapping()
	
	@PostMapping("/sessions")
	public Session createSession(){
		
		
		Session session = new Session();
		session.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		dataService.saveSession(session);
		
		return session;
		}
*/
}

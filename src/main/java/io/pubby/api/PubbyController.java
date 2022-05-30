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

@RestController
public class PubbyController {

	@Autowired
	DataService dataService;

	@GetMapping("/questions")
	public List<Question> getQuestions() {

		System.out.println("Working");

		return dataService.getQuestions();

	}

	@PostMapping("/questions")
	public void createQuestions(@RequestBody List<Question> questions) {

		dataService.saveQuestions(questions);

	}
	
	@GetMapping("/players")
	public List<Player> getAllPlayersInSession(@RequestHeader("X-Session")int sessionId) {
		
		
		return dataService.getPlayersBySessionId(sessionId) ;
		
		
	}

	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable int playerId) {

		return dataService.getPlayerById(playerId);

	}

	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player,@RequestHeader("X-Session")int sessionId ) {

		Session session = dataService.getSession(sessionId);
		
		player.setSession(session);
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

}

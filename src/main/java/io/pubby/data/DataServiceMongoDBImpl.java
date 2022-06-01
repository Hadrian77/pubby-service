package io.pubby.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import io.pubby.models.AnswerRecord;
import io.pubby.models.Player;
import io.pubby.models.Question;
import io.pubby.models.Session;
import io.pubby.repositories.AnswerRecordRepository;
import io.pubby.repositories.PlayerRepository;
import io.pubby.repositories.QuestionRepository;
import io.pubby.repositories.SessionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataServiceMongoDBImpl implements DataService {

	@Autowired
	QuestionRepository questionRepo;

	@Autowired
	AnswerRecordRepository answerRepo;

	@Autowired
	SessionRepository sessionRepo;

	@Autowired
	PlayerRepository playerRepo;

	@Override
	public Flux<Question> getQuestions() {
		// TODO Auto-generated method stub
		return questionRepo.findAll();
	}

	@Override
	public Flux<Question> saveQuestions(List<Question> questions) {
		// TODO Auto-generated method stub
		return questionRepo.saveAll(questions);
		
	}

	@Override
	public Mono<Session> saveSession(Session session) {
		
		return sessionRepo.save(session);
	}

	@Override
	public Mono<Session> getSession(String sessionId) {
		// TODO Auto-generated method stub
		return sessionRepo.findById(sessionId);
	}

	@Override
	public Mono<Player> getPlayerById(String playerId) {
		// TODO Auto-generated method stub
		return playerRepo.findById(playerId);
	}

	@Override
	public Flux<Player> getPlayersBySessionId(String sessionId) {

		Player examplePlayer = new Player();
		Session sessionExample = new Session();
		sessionExample.setId(sessionId);
		examplePlayer.setSession(sessionExample);

		Example<Player> playerExample = Example.of(examplePlayer, ExampleMatcher.matchingAny());

		return playerRepo.findAll(playerExample);

	}

	@Override
	public Mono<Player> savePlayer(Player player) {
		// TODO Auto-generated method stub
		return playerRepo.save(player);
	}

	@Override
	public Flux<AnswerRecord> getAnswerRecordsByQuestionId(String questionId, String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAnswerRecords(List<AnswerRecord> answerRecords) {
		// TODO Auto-generated method stub
		answerRepo.saveAll(answerRecords);
	}

}

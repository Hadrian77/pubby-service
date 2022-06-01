package io.pubby.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void saveSession(Session session) {
		// TODO Auto-generated method stub
		sessionRepo.save(session);
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

	/*
	@Override
	public Flux<Player> getPlayersBySessionId(String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<AnswerRecord> getAnswerRecordsByQuestionId(String questionId, String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAnswerRecords(List<AnswerRecord> answerRecords) {
		// TODO Auto-generated method stub
		
	}
	*/

	
	
	


}

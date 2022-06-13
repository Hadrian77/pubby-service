package io.pubby.data;

import java.util.ArrayList;
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

	public Flux<Question> getQuestionsByMetaData(List<String> keywords, List<String> tags) {

		return questionRepo.findAll().filter(result -> {

			if (result.getTags() != null && result.getKeywords() != null) {
				List<String> copiedTags = new ArrayList<String>(tags);
				List<String> copiedKeywords = new ArrayList<String>(keywords);

				copiedTags.retainAll(result.getTags());
				copiedKeywords.retainAll(result.getKeywords());

				if (copiedTags.equals(tags) && copiedKeywords.equals(keywords)) {

					return true;

				}

				else {

					return false;
				}

			}
			//Returns false if keywords or tags are null
			else {

				return false;

			}

		});
	}

	public Mono<Question> getQuestion(String questionId) {
		// TODO Auto-generated method stub
		return questionRepo.findById(questionId);
	}

	@Override
	public Flux<Question> saveQuestions(List<Question> questions) {
		// TODO Auto-generated method stub
		return questionRepo.saveAll(questions);

	}

	public Mono<Question> saveQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRepo.save(question);

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
	public Mono<AnswerRecord> getAnswerRecordByQuestionId(String questionId, String sessionId) {

		Question exampleQuestion = new Question();
		exampleQuestion.setId(questionId);

		Session exampleSession = new Session();
		exampleSession.setId(sessionId);

		AnswerRecord exampleAnswer = new AnswerRecord();
		exampleAnswer.setQuestion(exampleQuestion);
		exampleAnswer.setSession(exampleSession);

		Example<AnswerRecord> answerExample = Example.of(exampleAnswer, ExampleMatcher.matchingAny());

		return answerRepo.findOne(answerExample);
	}

	@Override
	public Mono<AnswerRecord> saveAnswerRecord(AnswerRecord answerRecord) {
		// TODO Auto-generated method stub
		return answerRepo.save(answerRecord);
	}

}

package io.pubby.data;

import java.util.List;

import io.pubby.models.AnswerRecord;
import io.pubby.models.Player;
import io.pubby.models.Question;
import io.pubby.models.Session;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DataService {
	
	
	public Flux<Question> getQuestions();
	
	public Flux<Question> saveQuestions(List<Question> questions);

	
	public void saveSession(Session session);
	public Mono<Session> getSession(String sessionId);
	
	
	public Mono<Player> getPlayerById(String playerId);
	
	//public Flux<Player> getPlayersBySessionId(String sessionId);
	
	//void savePlayer(Player player);
	
	
	
	//Only a List of AnswerRecords is useful
	//public Flux<AnswerRecord> getAnswerRecordsByQuestionId(String questionId,String sessionId);
	
	//public void saveAnswerRecords(List<AnswerRecord> answerRecords);

	

}

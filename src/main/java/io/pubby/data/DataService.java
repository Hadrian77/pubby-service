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
	public Flux<Question> getQuestionsByMetaData(List<String> keywords,List<String> excludedKeywords, List<String> tags,List<String> excludedTags);
	public Mono<Question> getQuestion(String questionId);
	
	public Flux<Question> saveQuestions(List<Question> questions);
	public Mono<Question> saveQuestion(Question question);

	
	public Mono<Session> saveSession(Session session);
	public Mono<Session> getSession(String sessionId);
	
	
	public Mono<Player> getPlayerById(String playerId);
	
	public Flux<Player> getPlayersBySessionId(String sessionId);
	
	public Mono<Player> savePlayer(Player player);
	
	
	
	//Only a List of AnswerRecords is useful
	public Mono<AnswerRecord> getAnswerRecordByQuestionId(String questionId,String sessionId);
	
	public Mono<AnswerRecord> saveAnswerRecord(AnswerRecord answerRecords);

	

}

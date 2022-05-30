package io.pubby.data;

import java.util.List;

import io.pubby.models.AnswerRecord;
import io.pubby.models.Player;
import io.pubby.models.Question;
import io.pubby.models.Session;

public interface DataService {
	
	
	public List<Question> getQuestions();
	
	public void saveQuestions(List<Question> questions);

	
	public void saveSession(Session session);
	public Session getSession(int sessionId);
	
	
	public Player getPlayerById(int playerId);
	
	public List<Player> getPlayersBySessionId(int sessionId);
	
	void savePlayer(Player player);
	
	
	
	//Only a List of AnswerRecords is useful
	public List<AnswerRecord> getAnswerRecordsByQuestionId(int questionId,int sessionId);
	
	public void saveAnswerRecords(List<AnswerRecord> answerRecords);

	

}

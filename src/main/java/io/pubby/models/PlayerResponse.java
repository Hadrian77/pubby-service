package io.pubby.models;


public class PlayerResponse {
	
	Player player;
	String answer;
	
	
	
	public PlayerResponse(Player player, String answer) {
		super();
		this.player = player;
		this.answer = answer;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "PlayerAnswer [player=" + player + ", answer=" + answer + "]";
	}
	
	

}

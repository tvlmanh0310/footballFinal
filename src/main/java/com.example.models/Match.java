package com.example.models;

public class Match {
	private int id;
    private int homeTeamId;
    private int awayTeamId;
    private int homeTeamScore;
    private int awayTeamScore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHomeTeamId() {
		return homeTeamId;
	}
	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}
	public int getAwayTeamId() {
		return awayTeamId;
	}
	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", homeTeamId=" + homeTeamId + ", awayTeamId=" + awayTeamId + ", homeTeamScore="
				+ homeTeamScore + ", awayTeamScore=" + awayTeamScore + "]";
	}

}

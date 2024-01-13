package com.example.models;

public class Team {
	String TeamID;
    String TeamName;
    String TeamCity;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String teamID, String teamName, String teamCity) {
		super();
		TeamID = teamID;
		TeamName = teamName;
		TeamCity = teamCity;
	}
	public String getTeamID() {
		return TeamID;
	}
	public void setTeamID(String teamID) {
		TeamID = teamID;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getTeamCity() {
		return TeamCity;
	}
	public void setTeamCity(String teamCity) {
		TeamCity = teamCity;
	}
	@Override
	public String toString() {
		return "Team [TeamID=" + TeamID + ", TeamName=" + TeamName + ", TeamCity=" + TeamCity + "]";
	}

}

package DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Team;
import com.example.util.ConnectSQL;

public class TeamDBContext {
	
	Connection connection;

	// Test connection
	public TeamDBContext() {
		connection = ConnectSQL.getConnection();
	}
//	public static void main(String[] args) {
//		TeamDBContext teamDBContext = new TeamDBContext();
//		try {
//			List<Team> list = teamDBContext.getAllTeams();
//			System.out.println(list);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// Take all Teams
	public List<Team> getAllTeams() throws ClassNotFoundException {
		List<Team> teams = new ArrayList<>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM team");

			while (rs.next()) {
				String TeamID = rs.getString("TeamID");
				String TeamName = rs.getString("TeamName");
				String TeamCity = rs.getString("TeamCity");

				Team team = new Team(TeamID, TeamName, TeamCity);

				teams.add(team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teams;
	}
	
	public Team getTeambyID(String id) throws ClassNotFoundException {
		try {
			connection = ConnectSQL.getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM team WHERE TeamID = '" + id + "'");

			while (rs.next()) {
				String TeamID = rs.getString("TeamID");
				String TeamName = rs.getString("TeamName");
				String TeamCity = rs.getString("TeamCity");

				return new Team(TeamID, TeamName, TeamCity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	// Add Team
	public void addTeam(String TeamID, String TeamName, String TeamCity) throws ClassNotFoundException {
		try {
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO team (TeamID, TeamName, TeamCity) values (?, ?, ?)");
			pstm.setString(1, TeamID);
			pstm.setString(2, TeamName);
			pstm.setString(3, TeamCity);

			pstm.executeUpdate();
			System.out.println("add success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Update Team
	public void updateTeam(Team team) {
		try {
			PreparedStatement pstm = connection
					.prepareStatement("UPDATE team SET TeamName = ?, TeamCity = ? WHERE TeamID = ?");
			pstm.setString(1, team.getTeamID());
			pstm.setString(2, team.getTeamName());
			pstm.setString(3, team.getTeamCity());
			
			pstm.executeUpdate();
			System.out.println(team.toString());
			System.out.println("update success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Delete Team
	public void deleteTeam(String TeamID) {
		try {
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM `football_season_management`.`team WHERE TeamID = ?");
			pstm.setString(1, TeamID);
			
			pstm.executeUpdate();
			System.out.println("delete success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

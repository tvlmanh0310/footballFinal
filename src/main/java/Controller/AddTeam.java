package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.Team;
import com.example.util.ConnectSQL;

import DBContext.TeamDBContext;

/**
 * Servlet implementation class AddTeam
 */
@WebServlet("/AddTeam")
public class AddTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    Connection connection;
    public AddTeam() {
        super();
		connection = ConnectSQL.getConnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String TeamID = request.getParameter("TeamID");
		String TeamName = request.getParameter("TeamName");
		String TeamCity = request.getParameter("TeamCity");
		TeamDBContext teamDBContext = new TeamDBContext();
		try {
			teamDBContext.addTeam(TeamID, TeamName, TeamCity);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TeamServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

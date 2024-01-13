package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DBContext.TeamDBContext;
import com.example.models.Team;

/**
 * Servlet implementation class EditSubject
 */
public class EditTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			TeamDBContext teamDBContext = new TeamDBContext();
			if (request.getParameter("TeamID") != null && !request.getParameter("TeamID").isEmpty()) {
				try {
					Team team = teamDBContext.getTeambyID(request.getParameter("TeamID"));
					request.setAttribute("Team", team);
					request.getRequestDispatcher("TeamEdit.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			String TeamID = request.getParameter("TeamID");
			String TeamName = request.getParameter("TeamName");
			String TeamCity = request.getParameter("TeamCity");

			TeamDBContext teamDBContext = new TeamDBContext();
			Team team = new Team(TeamID, TeamName, TeamCity);
			teamDBContext.updateTeam(team);
			out.print(team.toString());
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		response.sendRedirect("TeamServlet");
	}

}

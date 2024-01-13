package com.example.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.Team;

@WebServlet("/AddTeamServlet")
public class AddTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	 
	public AddTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ request
        String TeamName = request.getParameter("TeamName");
        String TeamCity = request.getParameter("TeamCity");

        // Kiểm tra xem thông tin có null hay không
        if (TeamName == null || TeamCity == null || TeamName.isEmpty() || TeamCity.isEmpty()) {
            // Xử lý lỗi nếu thông tin không hợp lệ
            response.sendRedirect("errorPage.jsp");
            return;
        }

        // Tạo đội bóng từ thông tin
        Team newTeam = new Team();
        newTeam.setTeamName(TeamName);
        newTeam.setTeamCity(TeamCity);

        // Thêm đội bóng vào danh sách hoặc cơ sở dữ liệu (tùy thuộc vào logic của bạn)
        addTeamToDatabase(newTeam);

        // Chuyển hướng hoặc hiển thị trang thành công
        response.sendRedirect("TeamServlet");
    }

    private void addTeamToDatabase(Team team) {
        // Ở đây, bạn có thể thêm đội bóng vào danh sách hoặc cơ sở dữ liệu
        // Đây chỉ là một ví dụ đơn giản, bạn cần cập nhật phương thức này theo cấu trúc dữ liệu và logic của bạn
        List<Team> teamList = getTeamListFromDatabase(); // Giả sử bạn đã có một danh sách đội bóng
        teamList.add(team);
        // Cập nhật lại danh sách đội bóng trong cơ sở dữ liệu (nếu cần)
    }

    private List<Team> getTeamListFromDatabase() {
        // Ở đây, bạn có thể lấy danh sách đội bóng từ cơ sở dữ liệu
        // Đây chỉ là một ví dụ đơn giản, bạn cần cập nhật phương thức này theo cấu trúc dữ liệu và logic của bạn
        return new ArrayList<>();
    }
}

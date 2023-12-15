package BlackPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServ
 */
public class UserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String UEmail = request.getParameter("UEmail");
		String UPassword = request.getParameter("UPassword");
		
		Connection con = BlackCon.connect();

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from user where UEmail=? and UPassword=?");
			
			pstmt.setString(1, UEmail);
			pstmt.setString(2, UPassword);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("SuccessUser.html");
			}
			else
			{
				response.sendRedirect("FailU.html");
			}
			
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
		
		
		
	}

}

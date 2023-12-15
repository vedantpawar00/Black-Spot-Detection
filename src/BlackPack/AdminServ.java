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

import BlackPack.BlackCon;

/**
 * Servlet implementation class AdminServ
 */
public class AdminServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServ() {
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
		
		

		String AEmail = request.getParameter("AEmail");
		String APassword = request.getParameter("APassword");
		
		Connection con = BlackCon.connect();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from admin where AEmail=? and APassword=?");
			pstmt.setString(1, AEmail);
			pstmt.setString(2, APassword);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("SuccessAdminL.html");
			}
			else
			{
				response.sendRedirect("Fail.html");
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}

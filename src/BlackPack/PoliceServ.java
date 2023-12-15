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
 * Servlet implementation class PoliceServ
 */
public class PoliceServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoliceServ() {
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
		
		
		
		String PEmail = request.getParameter("PEmail");
		String PPassword = request.getParameter("PPassword");
		
		Connection con = BlackCon.connect();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from policestation where PEmail=? and PPassword=?");
			pstmt.setString(1, PEmail);
			pstmt.setString(2, PPassword);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("SuccessPolice.html");
			}
			else
			{
				response.sendRedirect("FailP.html");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}

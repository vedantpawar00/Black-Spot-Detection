package BlackPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegis
 */
public class UserRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegis() {
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
		
		
		String UName = request.getParameter("UName");
		String UEmail = request.getParameter("UEmail");
		String UMobile = request.getParameter("UMobile");
		String UPassword = request.getParameter("UPassword");
		String UCity = request.getParameter("UCity");
		
		Connection con = BlackCon.connect();

		try {
			PreparedStatement pstmt = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, UName);
			pstmt.setString(3, UEmail);
			pstmt.setString(4, UMobile);
			pstmt.setString(5, UPassword);
			pstmt.setString(6, UCity);
			
			int i = pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("UserLogin.html");
			}
			else
			{
				response.sendRedirect("Fai.html");
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
	}

}

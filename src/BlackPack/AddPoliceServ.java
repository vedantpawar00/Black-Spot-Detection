package BlackPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BlackPack.BlackCon;

/**
 * Servlet implementation class AddPoliceServ
 */
public class AddPoliceServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPoliceServ() {
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
		
		

		String pname = request.getParameter("pname");
		String paddress = request.getParameter("paddress");
		String pmob = request.getParameter("pmob");
		String pemail = request.getParameter("pemail");
		String ppass = request.getParameter("ppass");
		
		Connection con = BlackCon.connect();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into policestation values(?,?,?,?,?,?)");
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, pname);
			pstmt.setString(3, paddress);
			pstmt.setString(4, pmob);
			pstmt.setString(5, pemail);
			pstmt.setString(6, ppass);
			
			int i = pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("sucAPOL.html");
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

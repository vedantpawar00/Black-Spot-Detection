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
 * Servlet implementation class AddBlackServ
 */
public class AddBlackServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlackServ() {
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
		
		
		String blname = request.getParameter("blname");
		String baddress = request.getParameter("baddress");
		String breason = request.getParameter("breason");
		String blatitude = request.getParameter("blatitude");
		String blongitude = request.getParameter("blongitude");
		String blevel = request.getParameter("blevel");
		String bcity = request.getParameter("bcity");
		
		Connection con = BlackCon.connect();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into blackspot values(?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, blname);
			pstmt.setString(3, baddress);
			pstmt.setString(4, breason);
			pstmt.setString(5, blatitude);
			pstmt.setString(6, blongitude);
			pstmt.setString(7, blevel);
			pstmt.setString(8, bcity);
			
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				
				response.sendRedirect("sucPBlac.html");
				//get.setCity(City);
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

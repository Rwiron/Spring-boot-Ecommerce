package cn.wiron.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wiron.connection.DbCon;

/**
 * Servlet implementation class contact
 */
@WebServlet("/contact")
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("name");
		String umail = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		try {
			Connection con = DbCon.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, umail);
			ps.setString(3, phone);
			ps.setString(3, message);
			ps.executeUpdate();
			response.sendRedirect("registration.jsp?msg=valid");

		} catch (Exception e)

		{
			response.sendRedirect("registration.jsp?msg=invalid");
			System.out.println(e);

		}
	}

}

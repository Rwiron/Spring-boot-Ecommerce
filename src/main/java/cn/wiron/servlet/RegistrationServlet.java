package cn.wiron.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import cn.wiron.connection.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("name");
		String umail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		try {
			Connection con = DbCon.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, umail);
			ps.setString(3, upwd);
			ps.executeUpdate();
			response.sendRedirect("registration.jsp?msg=valid");

		} catch (Exception e)

		{
			response.sendRedirect("registration.jsp?msg=invalid");
			System.out.println(e);

		}
	}
}

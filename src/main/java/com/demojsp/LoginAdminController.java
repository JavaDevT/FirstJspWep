package com.demojsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demojsp.dbhelper.DBHelper;

public class LoginAdminController extends HttpServlet {

	private DBHelper dbHelper = new DBHelper();

	/**
	 *sxxsxs
	 */
	/**
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.trim().equalsIgnoreCase("")) {
			showError(req, resp, "Please enter username");
			return;
		}
		if (password.trim().equalsIgnoreCase("")) {
			showError(req, resp, "Please enter password");
			return;
		}

		String userData = dbHelper.checkUser(username, password);
		if (userData.equals("")) {
			showError(req, resp, "No user found");
		} else {
			resp.sendRedirect("showadmin.jsp");
		}
	}

	private void showError(HttpServletRequest req, HttpServletResponse resp, String msg)
			throws ServletException, IOException {
		req.setAttribute("error", msg);
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}

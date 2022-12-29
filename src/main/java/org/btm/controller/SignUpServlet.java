package org.btm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btm.dao.UserDao;
import org.btm.dto.User;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		long phone = Long.parseLong(req.getParameter("ph"));
		String email = req.getParameter("em");
		String password = req.getParameter("ps");
		User user = new User();
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setName(name);
		UserDao dao = new UserDao();
		user = dao.saveUser(user);
		System.out.println("user saved with ID:" + user.getId());
	}
}

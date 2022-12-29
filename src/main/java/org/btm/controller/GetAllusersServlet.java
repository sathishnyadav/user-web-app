package org.btm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btm.dao.UserDao;
import org.btm.dto.User;

@WebServlet("/getall")
public class GetAllusersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDao();
		List<User> users = dao.getAllUsers();
		PrintWriter writer = resp.getWriter();
		for (User user : users) {
			writer.write("<html><body><h1>Name:" + user.getName() + "</h1>");
			writer.write("<h1>Phone:" + user.getPhone() + "</h1>");
			writer.write("<h1>Email:" + user.getEmail() + "</h1>");
			writer.write("<h1>ID:" + user.getId() + "</h1></body></html>");
		}
	}
}

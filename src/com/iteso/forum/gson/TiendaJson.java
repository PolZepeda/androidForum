package com.iteso.forum.gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iteso.forum.dao.TiendaDAO;
import com.iteso.forum.mysql.DatabaseConnection;

/**
 * Servlet implementation class TiendaJson
 */
@WebServlet("/TiendaJson")
public class TiendaJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			DatabaseConnection database = new DatabaseConnection();
			TiendaDAO tienda = new TiendaDAO();
			ArrayList tiendasObjects = null;
			Connection connection = database.getConnection();
			tiendasObjects = tienda.GetMessages(connection, request, response);
			Gson gson = new Gson();
			String tiendas = gson.toJson(tiendasObjects);
			out.println("{\"Tiendas\":"+tiendas+"}");

		}catch(Exception ex)
		{
			out.println("Error: " + ex.getMessage());
		}
		finally
		{
			out.close();
		}
	}

}

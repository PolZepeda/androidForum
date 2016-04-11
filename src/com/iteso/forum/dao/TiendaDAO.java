package com.iteso.forum.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteso.forum.tienda.TiendaObject;

public class TiendaDAO {
	/*public String InsertTienda(Connection connection, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = null;
		try {
			message = request.getParameter("message");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO messages(message) VALUES(?)");
			ps.setString(1, message);
			int rs = ps.executeUpdate();
			if (rs>0) {
				return message;
			} else {
				return null;
			}

		} catch (Exception e) {
			throw e;
		}
	}*/

	public ArrayList<TiendaObject> GetMessages(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ArrayList <TiendaObject> tiendaData = new ArrayList <TiendaObject> ();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM tienda ORDER BY tienda_id DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				TiendaObject tiendaObjct = new TiendaObject();
				tiendaObjct.setId(rs.getInt("tienda_id"));
				tiendaObjct.setNombre(rs.getString("tienda_nombre"));
				tiendaObjct.setCategoria(rs.getString("tienda_categoria"));
				tiendaObjct.setUrl_image(rs.getString("tienda_url_image"));
				tiendaObjct.setTelefono(rs.getString("tienda_telefono"));
				tiendaObjct.setPiso(rs.getInt("tienda_piso"));
				tiendaObjct.setLocal(rs.getString("tienda_local"));
				tiendaObjct.setHorario(rs.getString("tienda_horario"));
				tiendaObjct.setCorreo(rs.getString("tienda_correo"));
				tiendaObjct.setDescripcion(rs.getString("tienda_descripcion"));
				tiendaObjct.setCoordenadas(rs.getString("tienda_coordenadas"));
				tiendaData.add(tiendaObjct);
			}
			return tiendaData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}

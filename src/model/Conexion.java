/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author <jCarlos:Mendoza/>
 *
 * Proyecto: app_crud_mysql
 * Código para: Conexion.java
 * Fecha: 10/04/2017
 */
public class Conexion {
	
	private String driver = "org.gjt.mm.mysql.Driver";
	private String dbname = "db_app_crud_mysql";
	private String host	  = "jdbc:mysql://localhost/"+dbname;
	private String user   = "root";
	private String pw 	  = "";
	
	private Connection link;
	
	public Connection Conectar()
	{
		try 
		{
			Class.forName(this.driver);
			link = DriverManager.getConnection(this.host, this.user, this.pw);
		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
			link = null;
		}
		
		return link;
	}

}

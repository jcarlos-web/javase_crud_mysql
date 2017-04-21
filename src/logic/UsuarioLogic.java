/**
 * 
 */
package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.table.DefaultTableModel;

import model.Conexion;
import model.Usuario;
/**
 * @author <jCarlos:Mendoza/>
 *
 * Proyecto: app_crud_mysql
 * Código para: UsuarioLogic.java
 * Fecha: 10/04/2017
 */
public class UsuarioLogic {
	
	private Conexion mysql = new Conexion();
	private Connection conexion = mysql.Conectar();
	
	private String sql;
	private int result;
	public int count = 0;
	
	// Method Read
	public DefaultTableModel readUsuario(String query)
	{
		sql = "SELECT * FROM usuario WHERE nombre LIKE '%"+query+"%' ORDER BY id_usuario DESC ";
		
		String[] thead = {"Id", "Nombre", "Apellido paterno", "Apellido materno", "Email", "Teléfono", "Fecha registro"};
		Object[] row = new Object[7];
		DefaultTableModel table = new DefaultTableModel(null,thead);
		
		try 
		{
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				row[0] = rs.getObject("id_usuario");
				row[1] = rs.getObject("nombre");
				row[2] = rs.getObject("ap_pat");
				row[3] = rs.getObject("ap_mat");
				row[4] = rs.getObject("mail");
				row[5] = rs.getObject("telefono");
				row[6] = rs.getObject("fecha");
				
				
				table.addRow(row);
				count = count+1;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString());
			return null;
		}
		
		return table;

	}
	
	// Method create
	public boolean createUsuario(Usuario model)
	{
		sql = "INSERT INTO usuario VALUES(null, ?,?,?,?,?,?)";
		
		try 
		{
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, model.getNombre());
			pst.setString(2, model.getAp_pat());
			pst.setString(3, model.getAp_mat());
			pst.setString(4, model.getEmail());
			pst.setString(5, model.getTelefono());
			pst.setString(6, model.getFecha());
			
			result = pst.executeUpdate();
			
			if(result != 0)
				return true;
			else
				return false;
		} 
		catch (Exception e) 
		{
			System.out.println("create: "+e.toString());
			return false;
		}
		
	}
	
	// Method update
		public boolean updateUsuario(Usuario model)
		{
			sql = "UPDATE usuario SET nombre=?, ap_pat=?, ap_mat=?, mail=?, telefono=? WHERE id_usuario=?";
			
			try 
			{
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, model.getNombre());
				pst.setString(2, model.getAp_pat());
				pst.setString(3, model.getAp_mat());
				pst.setString(4, model.getEmail());
				pst.setString(5, model.getTelefono());
				pst.setInt(6, model.getId());
				
				//System.out.println(pst.toString());
				result = pst.executeUpdate();
				
				if(result != 0)
					return true;
				else
					return false;
			} 
			catch (Exception e) 
			{
				System.out.println("Update: "+e.toString());
				return false;
			}
			
		}
	
	// Method delete
		public boolean deleteUsuario(Usuario model)
		{
			sql = "DELETE FROM usuario WHERE id_usuario=?";
			
			try 
			{
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, model.getId());
				
				result = pst.executeUpdate();
				
				if(result != 0)
					return true;
				else
					return false;
			} 
			catch (Exception e) 
			{
				System.out.println("delete "+e.toString());
				return false;
			}
			
		}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

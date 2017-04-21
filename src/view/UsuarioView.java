/**
 * 
 */
package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.Usuario;
import logic.UsuarioLogic;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

/**
 * @author <jCarlos:Mendoza/>
 *
 * Proyecto: app_crud_mysql
 * Código para: UsuarioView.java
 * Fecha: 10/04/2017
 */


public class UsuarioView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId_usuario;
	private JTextField txtNombre;
	private JTextField txtAp_pat;
	private JTextField txtAp_mat;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JButton btnPush;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JTextField txtFecha;
	private JButton btnEliminar;
	private JTextField txtBuscar;
	
	
	private String gate = "";
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private Usuario 		model = new Usuario();
	private UsuarioLogic 	logic = new UsuarioLogic();
	private JLabel lblContador;
	private JTable jtable;
	private JLabel lblTitle;
	

	
	// Constructor de la clase
	public UsuarioView() 
	{
		setBackground(Color.WHITE);
		setTitle("App CRUD MySQL");
		Construct();
		dateNow();
		readDB("");
		inhabilitar();
		
	}
	
	public void dateNow()
	{
		java.text.DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		txtFecha.setText(fecha.format(new java.util.Date()));
	}
	
	public void readDB(String query)
	{
		
		try 
		{
			modelo = logic.readUsuario(query);
			jtable.setModel(modelo);
			
			lblContador.setText("Total de registros: "+logic.count);
			
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Ha surgido un error en la lectura. Detalles: "+e.toString(), "Aplicación CRUD", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void createUpdate()
	{
		model.setNombre(txtNombre.getText());
		model.setAp_pat(txtAp_pat.getText());
		model.setAp_mat(txtAp_mat.getText());
		model.setEmail(txtEmail.getText());
		model.setTelefono(txtTelefono.getText());
		model.setFecha(txtFecha.getText());
		
		if(gate.equals("SAVE"))
		{
			if(logic.createUsuario(model))
				JOptionPane.showMessageDialog(null, "Usuario creado correctamente.", "Aplicación CRUD", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "El Usuario no fue creado .", "Aplicación CRUD", JOptionPane.ERROR_MESSAGE);
			
		}
		
		if(gate.equals("UPDATE"))
		{
			model.setId(Integer.parseInt(txtId_usuario.getText()));
			
			if(logic.updateUsuario(model))
				JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.", "Aplicación CRUD", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "El Usuario no fue actualizado .", "Aplicación CRUD", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		// Refresca la tabla
		inhabilitar();
		
	}
	
	public void delete()
	{
		model.setId(Integer.parseInt(txtId_usuario.getText()));
		
		if(logic.deleteUsuario(model))
			JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.", "Aplicación CRUD", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "El Usuario no fue eliminado .", "Aplicación CRUD", JOptionPane.ERROR_MESSAGE);
		
		// Refresca la tabla
		inhabilitar();
		
	}
	
	public void habilitar()
	{
		// Limipiar campos
		txtId_usuario.setText("");
		txtNombre.setText("");
		txtAp_pat.setText("");
		txtAp_mat.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		txtFecha.setText("");
		txtBuscar.setText("");
		
		// Habilitar controles
		txtId_usuario.setVisible(false);
		txtNombre.setEnabled(true);
		txtAp_pat.setEnabled(true);
		txtAp_mat.setEnabled(true);
		txtEmail.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtFecha.setVisible(false);	
		
		
		btnPush.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(false);
		
		// Refresca la tabla
		readDB("");
		
	}
	
	
	public void inhabilitar()
	{
		// Limipiar campos
		txtId_usuario.setText("");
		txtNombre.setText("");
		txtAp_pat.setText("");
		txtAp_mat.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		txtFecha.setText("");
		txtBuscar.setText("");
		
		// Habilitar controles
		txtId_usuario.setVisible(false);
		txtNombre.setEnabled(false);
		txtAp_pat.setEnabled(false);
		txtAp_mat.setEnabled(false);
		txtEmail.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtFecha.setVisible(false);	
		
		
		btnPush.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEliminar.setEnabled(false);
		
		// Refresca la tabla
		readDB("");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	// Método contenedor de objetos
		public void Construct()
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 864, 544);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			
			JPanel panel_1 = new JPanel();
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(29)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
			);
			
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					// Eliminar
					delete();
					
				}
			});
			
			JLabel lblBuscar = new JLabel("Buscar:");
			
			txtBuscar = new JTextField();
			txtBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					
					// Buscar
					readDB(txtBuscar.getText());
				}
			});
			txtBuscar.setColumns(10);
			
			lblContador = new JLabel("Contador");
			
			JScrollPane scroll = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(scroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addComponent(lblBuscar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnEliminar))
							.addComponent(lblContador, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEliminar)
							.addComponent(lblBuscar)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblContador)
						.addContainerGap())
			);
			
			jtable = new JTable();
			jtable.setFillsViewportHeight(true);
			jtable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			jtable.setShowVerticalLines(false);
			jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jtable.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					// Habilitamos btn
					btnEliminar.setEnabled(true);
					
					// Idicamos GATE= UPDATE
					gate = "UPDATE";
					
					// Título de formulario
					lblTitle.setText("Editar");
					
					btnPush.setText("Actualizar");
					
					// Habilitar controles
					habilitar();

					// Obtenemos número de fila
					int row = jtable.rowAtPoint(arg0.getPoint());
					
					// recuperamos los datos de la fila
					txtId_usuario.setText(jtable.getValueAt(row, 0).toString());
					txtNombre.setText(jtable.getValueAt(row, 1).toString());
					txtAp_pat.setText(jtable.getValueAt(row, 2).toString());
					txtAp_mat.setText(jtable.getValueAt(row, 3).toString());
					txtEmail.setText(jtable.getValueAt(row, 4).toString());
					txtTelefono.setText(jtable.getValueAt(row, 5).toString());
					txtFecha.setText(jtable.getValueAt(row, 6).toString());

				}
			});
			scroll.setViewportView(jtable);
			panel_1.setLayout(gl_panel_1);
			
			lblTitle = new JLabel("Nuevo");
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			txtId_usuario = new JTextField();
			txtId_usuario.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			
			txtAp_pat = new JTextField();
			txtAp_pat.setColumns(10);
			
			JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
			
			txtAp_mat = new JTextField();
			txtAp_mat.setColumns(10);
			
			JLabel lblApellidoMaterno = new JLabel("Apellido materno:");
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			
			JLabel lblEmail = new JLabel("Email:");
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			
			btnPush = new JButton("Crear");
			btnPush.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					// Método createUpdate
					createUpdate();
				}
			});
			
			btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					// Gate
					gate = "SAVE";
					// Título de formulario
					lblTitle.setText("Nuevo");
					// título de botón
					btnPush.setText("Crear");
					// Habilitar controles
					habilitar();
				}
			});
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					// Inhabilitar controles
					inhabilitar();
				}
			});
			
			txtFecha = new JTextField();
			txtFecha.setColumns(10);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
										.addComponent(txtId_usuario, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtAp_pat, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addComponent(txtAp_mat, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnNuevo)
										.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
										.addComponent(btnCancelar)))
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnPush, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addGap(11))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNombre)
								.addContainerGap(160, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(121, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblTelfono, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(114, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(128, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblApellidoPaterno, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblApellidoMaterno, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtId_usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTitle))
						.addGap(18)
						.addComponent(lblNombre)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblApellidoPaterno)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtAp_pat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblApellidoMaterno)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtAp_mat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEmail)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblTelfono)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addComponent(btnPush)
						.addGap(18)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNuevo)
							.addComponent(btnCancelar))
						.addContainerGap())
			);
			panel.setLayout(gl_panel);
			contentPane.setLayout(gl_contentPane);
		}
}

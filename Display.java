import java.awt.BorderLayout;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Display extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("Display Data");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","123456");
					Statement st=con.createStatement();
					String query="Select * From employee";
				    ResultSet rs =st.executeQuery(query);
				    ResultSetMetaData rsmd=rs.getMetaData();
				    DefaultTableModel model=(DefaultTableModel) table.getModel();
				    
				    int cols=rsmd.getColumnCount();
				    String [] colname=new String[cols];
				    for(int i=0;i<cols;i++)
				    	colname[i]=rsmd.getColumnName(i+1);
				    model.setColumnIdentifiers(colname);
				    String no,name,marks;
				    while(rs.next())
				    {
				     no=rs.getString(1);
				     name=rs.getString(2);
				     marks=rs.getString(2);
				     String[] row= {no,name,marks};
				     model.addRow(row);
				     
				    }
				    st.close();
				    con.close();
				    			
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBounds(73, 157, 150, 48);
		contentPane.add(btnShow);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 115, 433, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}

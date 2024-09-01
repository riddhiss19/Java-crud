
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Insert extends JFrame implements ActionListener
{
	JLabel l6,l7,l8,l9;
    JTextField t1,t2,t3,t4;
	JButton b1,b2;
	JPanel p1,p2,p3,p4,p5;
	
 	Insert()
	{	
    	JFrame f1=new JFrame();
		f1.setLayout(new GridLayout(6,2));
		f1.setSize(1200,700);
		f1.setVisible(true);
		f1.getContentPane().setBackground(Color.decode("#c3f7e2"));
		
		l6=new JLabel("Employee Id   : ");
		l7=new JLabel("Employee Name : ");
		l8=new JLabel("Employee Post : ");
		l9=new JLabel("Salary        : ");
		
		t1=new JTextField(10);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(10);
		
		b1=new JButton("RESET");
		b2=new JButton("SAVE");
				
		l6.setFont(new Font("",Font.BOLD,20));
		l7.setFont(new Font("",Font.BOLD,20));
		l8.setFont(new Font("",Font.BOLD,20));
		l9.setFont(new Font("",Font.BOLD,20));
		
		t1.setFont(new Font("",Font.BOLD,20));
		t2.setFont(new Font("",Font.BOLD,20));
		t3.setFont(new Font("",Font.BOLD,20));
		t4.setFont(new Font("",Font.BOLD,20));
		
		b1.setPreferredSize(new Dimension(100, 50)); //set button's size,1st para is width nd 2nd is height
		b2.setPreferredSize(new Dimension(100, 50));
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
        p5=new JPanel();

        p1.setBackground(Color.decode("#c3f7e2"));	
        p2.setBackground(Color.decode("#c3f7e2"));	
        p3.setBackground(Color.decode("#c3f7e2"));	
        p4.setBackground(Color.decode("#c3f7e2"));	
        p5.setBackground(Color.decode("#c3f7e2"));	 
					
		p1.add(l6);
		p1.add(t1);
		f1.add(p1);
		
		p2.add(l7);
		p2.add(t2);
		f1.add(p2);
		
		p3.add(l8);
		p3.add(t3);
		f1.add(p3);
		
		p4.add(l9);
		p4.add(t4);
		f1.add(p4);
		
		p5.add(b1);
		p5.add(b2);
		f1.add(p5);
	     
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			t4.setText(null);
		}
		else
		{
			try 
			{        
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","123456"); 
                PreparedStatement statement = con.prepareStatement("INSERT INTO employee values(?,?,?,?)");  
                statement.setInt(1,Integer.parseInt(t1.getText()));
				statement.setString(2,t2.getText());
				statement.setString(3,t3.getText());
		        statement.setInt(4,Integer.parseInt(t4.getText()));
		        statement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Record Inserted Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
                statement.close();  
                con.close();  
            } 
			catch (Exception ee) 
			{ 
	            System.out.println(e);
            }
        }	    
    }
}
//show message when mouse moved on button;
//if duplicate roll no has been enetered again it will show an error message;
//import Pro.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MiniPro extends MouseAdapter implements ActionListener
{

    JButton b;
	JFrame f;
	JLabel l1,l2,l3,l4,l5;  //for home page
	JLabel home,nn,n1,n2,n3,n4,n5,gd; //for home page
	
	JMenuBar mb;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2,mi3,mi4;
	
	MiniPro()
	{
			
	f=new JFrame();
	f.getContentPane().setBackground(Color.decode("#c3f7e2"));
	f.setLayout(new GridLayout(8,0));
	f.setSize(1200,700);
	f.setVisible(true);
	
	home=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
	home.setFont(new Font("",Font.BOLD,40));
	
	nn=new JLabel("Project is created by: ");
	n1=new JLabel("1. Kartiki Khare");
	n2=new JLabel("2. Mayuri Kolhe");
	n3=new JLabel("3. Vidya Tarle");
	n4=new JLabel("4. Riddhi Sonawane");
	n5=new JLabel("5. Hitesh Thakare");
	
	nn.setFont(new Font("",Font.BOLD,30));
	n1.setFont(new Font("",Font.PLAIN,25));
	n2.setFont(new Font("",Font.PLAIN,25));
	n3.setFont(new Font("",Font.PLAIN,25));
	n4.setFont(new Font("",Font.PLAIN,25));
	n5.setFont(new Font("",Font.PLAIN,25));
	
	gd=new JLabel("Under the Guidance of: ");
	gd.setFont(new Font("",Font.BOLD,30));
	
	l1=new JLabel("Fill the Employee's Information");
	l2=new JLabel("Full Name: ");
	l3=new JLabel("Date of Birth: ");
	l4=new JLabel("Contact: ");
	
	home.add(Box.createRigidArea(new Dimension(40,25)));
	f.add(home);
	
	f.add(nn);
	f.add(n1);
	f.add(n2);
	f.add(n3);
	f.add(n4);
	f.add(n5);
	
	f.add(gd);
	
	mb=new JMenuBar();
		
    m1=new JMenu("Manage Employee Data  |");
	m2=new JMenu("Display Records   |");
	m3=new JMenu("About System");
	
	mi1=new JMenuItem("Insert Record");
    mi2=new JMenuItem("Delete Record");	
	mi3=new JMenuItem("Update Record");
	mi4=new JMenuItem("Display All Record");
	
	m1.add(mi1);
	m1.add(mi2);
	m1.add(mi3);
	mb.add(m1);
	
	m2.add(mi4);
	mb.add(m2);
	
		
	mi1.addActionListener(this);
	mi2.addActionListener(this);
	mi3.addActionListener(this);
	mi4.addActionListener(this);
	
		
	f.setJMenuBar(mb);
	
   	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mi1){
		Insert i1=new Insert();
		//i1.setSize(500,600);
		i1.show();
		}
		else if(ae.getSource()==mi2)
		{
			Delete u=new Delete();
			u.show();
		}
		else if(ae.getSource()==mi3)
		{
			Update d=new Update();
			d.show();
		}
		else
		{
			
			Display dd=new Display();
			dd.show();
		}
	}
	
	public static void main(String[]ar)
	{
		MiniPro m=new MiniPro();		
	}
}

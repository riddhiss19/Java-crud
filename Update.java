import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Update extends JFrame implements ActionListener{
    JLabel id,name,post,salary;
    JTextField i,n,p,s;
    JButton btn_search,b1;

      public Update(){
          super("Search");
          
		  id = new JLabel("Enter ID:");
          id.setBounds(280, 80, 700, 40);
          id.setFont(new Font("",Font.BOLD,30));
		  
   		  i = new JTextField(20);
          i.setBounds(560, 80, 300, 40);
		  i.setFont(new Font("",Font.BOLD,30));
          
		  btn_search = new JButton("Search");
          btn_search.setBounds(880, 80, 80, 40);
		  id.setFont(new Font("",Font.BOLD,25));
          btn_search.addActionListener(this);
          
		  setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
		  getContentPane().setBackground(Color.decode("#c3f7e2"));
          setSize(1200,700);
          
          name = new JLabel("Employee Name: ");
          name.setBounds(280, 150, 700, 40);
		  name.setFont(new Font("",Font.BOLD,30));
          
		  n = new JTextField(20);
          n.setBounds(560, 150, 300, 40);
		  n.setFont(new Font("",Font.BOLD,30));
          
		  post = new JLabel("Employee Post: ");
          post.setBounds(280, 220, 700, 40);
		  post.setFont(new Font("",Font.BOLD,30));
          
		  p = new JTextField(20);
          p.setBounds(560, 220, 300, 40);
		  p.setFont(new Font("",Font.BOLD,30));
          
		  salary = new JLabel("Employee Salary: ");
          salary.setBounds(280, 290, 300, 40);
		  salary.setFont(new Font("",Font.BOLD,30));
          
		  s = new JTextField(20);
          s.setBounds(560, 290, 300, 40);
		  s.setFont(new Font("",Font.BOLD,30));
          
		  b1=new JButton("UPDATE");
		  b1.setBounds(560,400,200,40);
		  b1.setFont(new Font("",Font.BOLD,25));
		  b1.addActionListener(this);
		  
		  setLayout(null);
          add(btn_search);
          add(name);
          add(n);
          add(post);
          add(p);
          add(salary);
          add(s);
          add(id);
          add(i);
		  add(b1);
    }

      public void actionPerformed(ActionEvent ae) 
  { 
	     if(ae.getSource()==btn_search){
    Function f = new Function();
    ResultSet rs = null;
    String fn = "name";
    String po = "post";
    String sa = "salary";
    
    rs = f.find(i.getText());
    try{
        if(rs.next()){
            n.setText(rs.getString("name"));
            p.setText(rs.getString("post"));
            s.setText(rs.getString("salary"));
        } 
    	else{
          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
             }
        }
	    catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
	   }
	   
	   else if(ae.getSource()==b1)
	   {
		    try {  
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","123456");  
        PreparedStatement statement = con.prepareStatement("update employee set name=?,post=?,salary=? where id=?");  
        statement.setInt(1,Integer.parseInt(i.getText()));
		statement.setString(2,n.getText());
		statement.setString(3,p.getText());
		statement.setString(4,s.getText());
		statement.executeUpdate();
 
         JOptionPane.showMessageDialog(this,"Record Updated Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
        statement.close();  
        con.close();  
      
        } catch (Exception e) { 
	                      System.out.println(e);
          
                              } 
	    }
		else
		{
			
		}
    }
   public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String ss){
           try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","123456");
           ps = con.prepareStatement("select * from employee where id = ?");
           ps.setString(1,ss);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
   }
   
}

package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,password;
    JTextField tfusername,tfpassword;
    
    Login(){
        setSize(900,450);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 410 , 410);
       
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/log.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,380, Image.SCALE_DEFAULT);
        ImageIcon i3   = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 40 ,450,300);
        add(p2);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,50,200,25);
        lblusername.setFont(new Font("ALGERIA",Font.PLAIN,18));
        p2.add(lblusername);
        
        
        tfusername = new JTextField();
        tfusername.setBounds(60,80,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,120,200,25);
        lblpassword.setFont(new Font("ALGERIA",Font.PLAIN,18));
        p2.add(lblpassword);
        setVisible(true);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,100,30);
        login.setBackground(new Color(4, 170, 109));
        
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
       
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(260,200,100,30);
        signup.setBackground(new Color(4, 170, 109));
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
       
        p2.add(signup);
        
        
        password = new JButton("Forget Password");
        password.setBounds(150,260,130,30);
        password.setBackground(new Color(4, 170, 109));
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
       
        p2.add(password);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                    
                }else{
                    JOptionPane.showMessageDialog(null, " Incorrect Username or Password");
                }
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
            
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String args[]){
      Login l = new Login();
      
    }
    
}

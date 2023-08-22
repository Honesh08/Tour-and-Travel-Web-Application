
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfname, tfusername, tfpass, tfanswer;
    Choice security;
    Signup(){
        setBounds(350,200,900,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(217,238,225));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
       
        add(p1);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        tfpass = new JTextField();
        tfpass.setBounds(190,100,180,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,16));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        

        
        security = new Choice();
        security.add("Your Nickname");
        security.add("Your DOG Name");
        security.add("Your School Name");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblanswer= new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,16));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("Create");
        create.setBackground(new Color(4, 170,110));
        create.setForeground(Color.black);
        create.setFont(new Font("Tahoma",Font.BOLD,16));
        create.setBounds(60,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(new Color(4, 170,110));
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setBounds(200,250,100,30);
        create.addActionListener(this);
        p1.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mobile.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600,50,250,250);
        add(image);
        
  
        setVisible(true);
  
    }
    
  

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpass.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            
            
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    
        
        
    }
    public static void main(String args[]){
        
        new Signup();
        
    }
    
    
    
}

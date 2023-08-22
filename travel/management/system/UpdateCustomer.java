
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername , labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfusername,tfname,tfid,tfgender;
    JRadioButton rmale,rfemale;
    JButton add,back;
    UpdateCustomer(String username){
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Rockwell",Font.BOLD,18));
        add(text);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        /*labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);*/
        
        tfusername = new JTextField();
        tfusername.setBounds(220,50,150,25);
        add(tfusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);

        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
       /* labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);*/
       
        tfname = new JTextField();
        tfname.setBounds(220,170,150,25);
        add(tfname);
        
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
      /*  rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);*/
      
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        
      
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);
        
        add = new JButton("Update");
        add.setBackground(new Color(4,170,109));
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(new Color(4,170,109));
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);
        
        setVisible(true);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfname.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                

            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
            
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = tfusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
           
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
             try{
                Conn c = new Conn();
                String query = "update into customer set username = '"+username+"',id = '"+id+"',number = '"+number+"',name= '"+name+"',email ='"+email+"',phone = '"+phone+"',country = '"+country+"',address = '"+address+"',gender = '"+gender+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
 
 

    public static void main(String args[]){
        new UpdateCustomer("");
        
        
    }
    
    
}

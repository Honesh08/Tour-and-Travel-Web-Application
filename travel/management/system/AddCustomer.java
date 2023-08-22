
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername , labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfusername,tfname;
    JRadioButton rmale,rfemale;
    JButton add,back;
    String username;
    AddCustomer(String username){
        this.username = username;
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
       /* tfusername = new JTextField();
        tfusername.setBounds(220,50,150,25);
        add(tfusername);*/
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        comboid = new JComboBox(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(new Color(189,173,205));
        add(comboid);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add");
        add.setBackground(new Color(4,170,109));
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(new Color(4,170,109));
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/24.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,400);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username =  '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
       
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
                
            }else{
                gender = "Female";
                
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+email+"','"+phone+"','"+country+"','"+address+"','"+gender+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new AddCustomer("");
        
        
    }
    
    
}
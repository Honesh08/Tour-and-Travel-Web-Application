
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage,gpackage;
    JTextField tfperson;
    String username;
    JLabel labelusername,labelid,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    BookPackage(String username){
        this.username = username;
        setBounds(350,200,1100,700);
        setLayout(null);
        getContentPane().setBackground(new Color(10,120,150));
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Rockwell",Font.BOLD,22));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250,70,100,25);
      //labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Platinum package");
        cpackage.add("Diamond package");
        cpackage.setBounds(250,110,180,20);
       
        add(cpackage);
        
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(40,150,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        tfperson = new JTextField();
        tfperson.setBounds(250,150,180,20);
        tfperson.setBorder(BorderFactory.createEmptyBorder());
        add(tfperson);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,190,180,25);
      //labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(40,230,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        gpackage = new Choice();
        gpackage.add("Male");
        gpackage.add("Female");
        gpackage.setBounds(250,230,180,20);
        add(gpackage);
        
        
        
        
      /*  JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);*/
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(690,110,150,25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
         try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
               // labelid.setText(rs.getString("id"));
               // labelnumber.setText(rs.getString("number"));
                labelid.setText(rs.getString("id"));
               // labelgender.setText(rs.getString("gender"));
               // labelcountry.setText(rs.getString("country"));
               // labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
               // labelprice.setText(rs.getString("price"));
                
            }
             
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
         
        checkprice = new JButton("Check Price");
        checkprice.setBackground(new Color(4, 170,110));
        checkprice.setForeground(Color.black);
        checkprice.setFont(new Font("Tahoma",Font.BOLD,16));
        checkprice.setBounds(50,380,150,30);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(new Color(4, 170,110));
        bookpackage.setForeground(Color.black);
        bookpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        bookpackage.setBounds(220,380,150,30);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(new Color(4, 170,110));
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setBounds(380,380,150,30);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
        
   
        
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold package")){
                cost+=15000;
            
            }else if (pack.equals("Platinum package")){
                cost+=25000;
                
            }else{
                cost+=32000;
                
            }
            int persons = Integer.parseInt(tfperson.getText());
            cost *= persons;
            labelprice.setText("Rs " + cost);
            
        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"'");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
        
        
        }else{
            setVisible(false);
        }
    }
        
        
        
    
    public static void main(String args[]){
        new BookPackage("");
        
    }
    
}

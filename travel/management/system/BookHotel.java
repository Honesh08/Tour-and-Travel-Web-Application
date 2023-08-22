
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,gpackage,cac,gfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername,labelid,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username = username;
        setBounds(350,200,1100,700);
        setLayout(null);
        getContentPane().setBackground(new Color(10,120,150));
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,110,180,20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
             
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(40,150,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        tfperson = new JTextField();
        tfperson.setBounds(250,150,180,20);
        tfperson.setBorder(BorderFactory.createEmptyBorder());
        add(tfperson);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        
        tfdays = new JTextField();
        tfdays.setBounds(250,190,180,20);
        tfdays.setBorder(BorderFactory.createEmptyBorder());
        add(tfdays);
        
         JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,310,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,180,20);
        add(cac);
        
        
        
      /*labelid = new JLabel();
        labelid.setBounds(250,190,180,25);
      //labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);*/
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        gfood = new Choice();
        gfood.add("Yes");
        gfood.add("No");
        gfood.setBounds(250,270,180,20);
        add(gfood);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,350,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,350,150,25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,390,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,390,150,25);
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
        checkprice.setBounds(50,430,150,30);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(new Color(4, 170,110));
        bookpackage.setForeground(Color.black);
        bookpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        bookpackage.setBounds(220,430,150,30);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(new Color(4, 170,110));
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setBounds(380,430,150,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i28 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i29 = i28.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(i29);
        JLabel l11 = new JLabel(i30);
        l11.setBounds(500, 50, 600, 300);
        add(l11);
        
        
        setVisible(true);
        
   
        
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = gfood.getSelectedItem();
                    
                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac:0;
                        total += foodselected.equals("Yes") ? food:0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs" +total);
                        
                    }else{
                        JOptionPane.showMessageDialog(null," Please enter a valid number");
                    }
                }
            
            
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+gfood.getSelectedItem()+"',"+labelid.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"'");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
        
        
        }else{
            setVisible(false);
        }
    }
        
        
        
    
    public static void main(String args[]){
        new BookHotel("");
        
    }
    
}


package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkpackages,bookpackage,viewhotels;
    JButton bookhotels,notepad,about;
    JButton destination;
    String username;
    Dashboard(String username){
        this.username = username;
        setBounds(0,0,1600,1000);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(189,173,205));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
      //  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dasboard1.jpeg"));
      //  Image i2 = i1.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH);
        
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(10,15,300,30);
        heading.setFont(new Font("Rockwell",Font.BOLD,20));
        p1.add(heading);
        
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(189,173,205));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(190,120,127));
        addPersonalDetails.setFont(new Font("Rockwell",Font.ITALIC,18));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(190,120,120));
        updatePersonalDetails.setFont(new Font("Rockwell",Font.ITALIC,18));
        p2.add(updatePersonalDetails);
        
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(190,120,127));
        viewPersonalDetails.setFont(new Font("Rockwell",Font.ITALIC,18));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(190,120,127));
        deletePersonalDetails.setFont(new Font("Rockwell",Font.ITALIC,18));
        
        p2.add(deletePersonalDetails);
        
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(190,120,127));
        checkpackages.setFont(new Font("Rockwell",Font.ITALIC,18));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(190,120,127));
        bookpackage.setFont(new Font("Rockwell",Font.ITALIC,18));
        p2.add(bookpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,300,300,50);
        viewhotels.setBackground(new Color(190,120,127));
        viewhotels.setFont(new Font("Rockwell",Font.ITALIC,18));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotels = new JButton("Book Hotel");
        bookhotels.setBounds(0,350,300,50);
        bookhotels.setBackground(new Color(190,120,127));
        bookhotels.setFont(new Font("Rockwell",Font.ITALIC,18));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);
        
        
        destination = new JButton("Destination");
        destination.setBounds(0,400,300,50);
        destination.setBackground(new Color(190,120,127));
        destination.setFont(new Font("Rockwell",Font.ITALIC,18));
        destination.addActionListener(this);
        p2.add(destination);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0,450,300,50);
        notepad.setBackground(new Color(190,120,127));
        notepad.setFont(new Font("Rockwell",Font.ITALIC,18));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0,500,300,50);
        about.setBackground(new Color(190,120,127));
        about.setFont(new Font("Rockwell",Font.ITALIC,18));
        about.addActionListener(this);
        p2.add(about);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dasboard1.jpg"));
        Image i5 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1600,900);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism By - Honesh Yadav");
        text.setBounds(410,90,1000,60);
        text.setFont(new Font("Bauhaus 93",Font.PLAIN,60));
        image.add(text);
        

        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            setVisible(false);
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
            
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackages){
            new CheckPackage();
        }else if(ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }else if(ae.getSource() == destination){
            new Destination();
        }else if(ae.getSource() == bookhotels){
            new BookHotel(username);
        }else if(ae.getSource() == notepad){
            try{
                // method to add desktop application on another desktop application
                Runtime.getRuntime().exec("notepad.exe");
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== about){
            new About();
        }
    }
    public static void main(String[] args){
        new Dashboard("");
        
    }
    
}

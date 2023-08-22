package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(450, 170, 900, 600);
        
        String[] package1 = {"GOLD PACKAGE","5 days and 6 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Rs 15000/-","pack1.jpg"};
        String[] package2  = {"PLATINUM PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW","Rs 25000/-","pack2.jpg"};
        String[] package3 = {"DIAMOND PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing", "Horse Riding & other Games", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW","Rs 32000/-","pack3.jpg"};

        

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null,p2);
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null,p3);
                
        
        
        
        add(tab);

        setVisible(true);

    }
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
       
        p1.setBackground(Color.white);
        
        // we not hardcode this use pack[] method for all the packages
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(70, 10, 300, 30);
      //  l1.setForeground(new Color(204, 186, 208));
        l1.setFont(new Font("Rockwell", Font.ITALIC, 26));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(40, 65, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l2.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(40, 115, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l3.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(40, 165, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l4.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l4);

        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(40, 215, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l5.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l5);
        
        JLabel l6= new JLabel(pack[5]);
        l6.setBounds(40, 265, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l6.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(40, 315, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l7.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(40, 365, 300, 30);
        //l1.setForeground(new Color(204, 186, 208));
        l8.setFont(new Font("Rockwell", Font.ITALIC, 20));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(80, 430, 300, 30);
        l9.setForeground(new Color(204, 186, 178));
        l9.setFont(new Font("Rockwell", Font.ITALIC, 25));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(270, 430, 300, 30);
        l10.setForeground(new Color(204, 186, 208));
        l10.setFont(new Font("Rockwell", Font.ITALIC, 25));
        p1.add(l10);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,550,350);
        p1.add(image);
        
        return p1;
      
    }

    public static void main(String args[]) {
        new CheckPackage();
    }

}

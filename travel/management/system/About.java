
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class About extends JFrame implements ActionListener{
    
    About(){
        setBounds(350,100,700,450);
        setLayout(null);
      //  setBackground(new Color(214,233,198));
        getContentPane().setBackground(new Color(255,205,210));
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(250,20,100,30);
        l1.setForeground(new Color(56,142,60));
        l1.setFont(new Font("Rockwell",Font.ITALIC,22));
        add(l1);
        
         String s = "About Project          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
               
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                + "\n   Developed By - Honesh Yadav "
                
                ;

        
        TextArea area = new TextArea(s,10,40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(50,100,500,270);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBackground(new Color(4, 170,110));
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setBounds(300,420,150,30);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String args[]){
        new About();
    }
    
}


package travel.management.system;
import javax.swing.*;
import java.awt.*;



public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue()+ 1);
                }else{
                    setVisible(false);
                    //new clas object
                    new Dashboard(username);
                    
                }
                Thread.sleep(40);
                
             
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        setBounds(400,100,800,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel text = new JLabel("Travel and Tourism Application - By Honesh");
        text.setBounds(50,30,900,40);
        text.setForeground(new Color(173,107,202));
        text.setFont(new Font("Rockwell",Font.BOLD,30));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(300,100,200,35);
        bar.setStringPainted(true);
        bar.setForeground(new Color(173,107,202));
        add(bar);
        
        JLabel loading = new JLabel("Loading please wait....");
        loading.setBounds(300,140,300,30);
        loading.setForeground(new Color(173,107,202));
        loading.setFont(new Font("Rockwell",Font.BOLD,20));
        add(loading);
        
        JLabel lblusername  = new JLabel("Welcome "+username);
        lblusername.setBounds(20,500,300,40);
        lblusername.setForeground(new Color(173,107,202));
        lblusername.setFont(new Font("Rockwell",Font.BOLD,20));
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    public static void main(String args[]){
        new Loading("");
        
    }
    
}

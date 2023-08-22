
package travel.management.system;
import javax.swing.*;
import java.awt.*;



public abstract class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash(){
     //   setSize(1000, 600);
     //  setLocation(270,100); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/s1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 550, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);   
        thread  = new Thread(this);
        thread.start();
        
    }
    
    public void run(){
        try{
            Thread.sleep(3000);
       //     new Login();
            setVisible(false);
       
            
        }catch (Exception e){
            
        }
    
    }
    public static void main(String args[]){
        Splash frame = new Splash() {};
        
        int x = 1;
        for(int i =1;i<=500; x+=7, i+=6){
            frame.setLocation(250, 200);
            frame.setSize(x+i,i);
            
            try {
                Thread.sleep(5);
                
            }catch  (Exception e){}
            
            
        }
       
        
    }
    
}

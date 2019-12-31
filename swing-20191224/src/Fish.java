import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Fish extends JLabel implements Runnable {
        private ImageIcon icon[] = new ImageIcon[3];
        private Timer t1 ;
        private int x ,y, z;
        private Boolean flag =false;
        public Fish(){
            Random rand = new Random();
            rand.setSeed(System.currentTimeMillis());
            icon[0]=new ImageIcon("fish1.png");
            icon[1]=new ImageIcon("fish2.png");
            icon[2]=new ImageIcon("fish3.jpg");

            x=rand.nextInt(720)+50;
            y=rand.nextInt(400)+50;
            z=rand.nextInt(3);
            System.out.println("z = "+z);

            this.setBounds(x,y,300,400);

            Image img1 = icon[0].getImage();
            Image img2 = img1.getScaledInstance(120,60,Image.SCALE_SMOOTH);
            icon[0].setImage(img2);

            img1 = icon[1].getImage();
            img2 = img1.getScaledInstance(120,60,Image.SCALE_SMOOTH);
            icon[1].setImage(img2);

            img1 = icon[2].getImage();
            img2 = img1.getScaledInstance(120,60,Image.SCALE_SMOOTH);
            icon[2].setImage(img2);

            this.setIcon(icon[z]);

            t1 = new Timer((rand.nextInt(5) + 1) * 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag){
                        if (x+5 >= 820){
                            flag =false;
                        }else {
                            x += 5;
                        }
                    }else {
                        if (x-5 <0){
                            flag =true;
                        }else {
                            x -= 5;
                        }
                    }
                    Fish.this.setLocation(x,y);
                }
            });
        }
        public void run(){
            t1.start();
        }
}

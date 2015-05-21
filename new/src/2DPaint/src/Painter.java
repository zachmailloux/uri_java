import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
public class Painter extends JFrame implements ActionListener{
 
    private JMenu menu;
    private JMenuItem exit;
    private JMenuItem colorMenu;
     
    Painter() {
         
        super ("Painter");
         
        init();
        this.setSize(500, 600);
        this.setVisible(true);
         
    }//end painter
     
private void init(){
         
        JMenuBar bar = new JMenuBar();
         
        menu = new JMenu("Menu");
         
        colorMenu = new JMenuItem("Pick Color");
        exit = new JMenuItem("Exit");
         
        colorMenu.addActionListener(this);
        exit.addActionListener(this);
         
        menu.add(colorMenu);
        menu.add(exit);
         
        bar.add(menu);
        this.setJMenuBar(bar);
    }//end init
 
public void paint(Graphics g){  
     
    super.paint(g);
    
    g.fillRoundRect(10, 10, 200, 200, 10, 10);
    g.drawLine(10, 50, 200, 200);
    g.setColor(Color.RED);
     
    g.setColor(Color.BLUE);
    g.drawRect(30, 60, 90, 120);
    g.setColor(Color.ORANGE);
    g.fillRect(35, 65, 25, 25);
    
     
    g.setColor(Color.GREEN);
    g.drawOval(200,  200,  50,  50);
    g.setColor(Color.YELLOW);
    g.fillOval(75,  75,  45, 45);
}//end paint
     
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if (e.getSource() == colorMenu){
            Color color = Color.LIGHT_GRAY;
             
            color = JColorChooser.showDialog(this,  "Choose a color for background",  color);
             
            if (color == null)
                color = Color.LIGHT_GRAY;
            this.setBackground(color);
        }//end if
        else {
            this.dispose();
        }//end else
         
    }//end actionPerformed
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        Painter canvas = new Painter();
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}//end class
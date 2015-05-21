import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class PanelRun extends JFrame implements ActionListener{
     
    private JPanel panelControl;
    private JButton remove, removeAll, removeAll2;
     
    PanelRun(){
         
        super("JPanel");
         
        init();
        this.setSize(300, 300);
        this.setVisible(true);
    }//end SimpleGui
     
    public void init(){
         
        JPanel panel = new JPanel();
        panel.add(new JLabel("Name"));
        panel.add(new JTextField(20));
         
        panel.setBackground(Color.YELLOW);
        panel.setBorder(BorderFactory.createTitledBorder("Info"));
         
        remove = new JButton("Remove");
        removeAll2 = new JButton("Remove All 2"); 
        removeAll = new JButton("Remove All");

       
        remove.addActionListener(this);
        removeAll2.addActionListener(this);
        removeAll.addActionListener(this);

         
        panelControl = new JPanel();
        panelControl.add(remove);
        panelControl.add(removeAll2);
        panelControl.add(removeAll);

         
        panelControl.setBorder(BorderFactory.createLineBorder(Color.GREEN));
         
        this.add(panel);
        this.add(panel, BorderLayout.CENTER);
        this.add(panelControl, BorderLayout.SOUTH); 
    }//end void

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
         
        if (e.getSource() == remove){
             
            panelControl.remove(0);
            panelControl.repaint();
        }else{
             
            panelControl.removeAll();
            panelControl.repaint();
        }
    }

     
 
}//end class
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Painter extends JFrame implements ActionListener{
	
	private JFrame;
	
	
	Painter(){
		super ("Painter");
		
		init();
		this.setSize(500, 600);
		this.setVisible(true);
	}

	private void init(){
	JMenuBar bar = new JMenuBar();
	
	menu = new JMenu("Menu");
	exit = new JMenuItem("Exit");
	colorMenu = new JMenuItem("Pick Color");
	
	colorMenu.addActionListener(this);
	exit.addActionListener(this);
	
	menu.add(colorMenu);
	menu.add(exit);
	
	bar.add(menu);
	this.setJMenuBar(bar);
}	Color color2;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == colorMenu){
			Color color;
			
			
			color = JColorChooser.showDialog(this, "Choose a color for background.",  Color.LIGHT_GRAY);
			
			if(color == null){
				color = Color.LIGHT_GRAY;
			}
			System.out.println(color.toString());
			this.setBackground(color);
			
		}
		else{
			this.dispose();
			
		}
		
		
	}
	public static void main(String[] args){
		Painter canvas = new Painter();
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	
}

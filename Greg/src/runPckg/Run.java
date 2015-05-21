package runPckg;

import java.awt.image.BufferStrategy;

import javax.swing.SwingWorker;

import classPckg.GUIDisplay;
public class Run {

	static GUIDisplay disp;
	static BufferStrategy strategy;
	public void startAnimation() {
        SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                while (true) {
                	//Update every few frames or so
                	disp.update();
                    Thread.sleep(60);
                }
            }
        };

        sw.execute();
    }
	
	public static void main(String[] args) {
		//Initialize all classes
		disp = new GUIDisplay();
		//Start the animation
		Run run = new Run();
		
		run.startAnimation();
	}

}

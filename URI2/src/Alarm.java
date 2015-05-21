/**
	@author Gaston

	Alarm.java
									A l a r m
									=========

	This class defines an alarm, which "beeps" after a delay.
	On each "beep," the alarm will notify the object registered when the timer
		is instantiated..
 */
public class Alarm extends Thread
{
	/**
	 * The object to notify
	 */
	private AlarmListener whoWantsToKnow;	
	
	/**
	 * The first beep will occur without any delay
	 */
	private int delay = 0;					

	/**
	 * With the default constructor, nobody will be notified
	 */
	public Alarm()
	{
		super("Alarm");						
		whoWantsToKnow = null;					
	}

	/**
	 * This alarm only notifies one object
	 * @param someBody the object to notify
	 */
	public Alarm(AlarmListener someBody)
	{
		super("Alarm");						
		whoWantsToKnow = someBody;			
	}

	/**
	 * The alarm only notifies one object
	 * @param name the name of the alarm
	 * @param someBody the object to notify
	 */
	public Alarm(String name, AlarmListener someBody)
	{
		super(name);						
		whoWantsToKnow = someBody;
	}

	/**
	 * Sets how often the alarm will go off
	 * @param someDelay in milliseconds
	 */
	public void setPeriod(int someDelay)
	{										
		delay = someDelay;					
	}
	
	/**
	 * Notifies the object at set time intervals (that can be changed at any
	 * time through setPeriod()).
	 * @param someDelay the initial period for the alarm
	 */
	private void setPeriodicBeep(int someDelay)
	{
		delay = someDelay;


		while (true){//	For as long as we have energy,
			try{
				Thread.sleep(delay);			//		first we wait
				if (whoWantsToKnow != null)		//		then we notify the
					whoWantsToKnow.takeNotice();//		responsible party
			}									//		(if anybody wants to hear)

			catch(InterruptedException e) {
				System.err.println("Oh, oh ... " + e.getMessage());
			}
		}
	}

	/**
	* The alarm is a Thread, and the run method gets the thread started, 
	* and running. (Note that you don't invoke run() directly, but instead
	* invoke start(), which in turn invokes run().)
	*/
	public void run()
	{
		System.out.println("The alarm is now running.");
		setPeriodicBeep(delay);
	}

}	//	end of class Alarm

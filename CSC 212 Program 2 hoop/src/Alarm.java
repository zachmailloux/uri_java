/*
	Author:	Gaston

	Alarm.java
									A l a r m
									=========
	
	This class defines an alarm, which "beeps" after a resetable delay.
	On each "beep," the alarm will notify the object registered when the timer
		is instantiated..
*/


public class Alarm
				extends Thread
{
	public volatile boolean running; //for signaling the end
	
	private AlarmListener bleepbleep;	//	The object to notify
											//		in case of emergency

	private int delay = 0;					//	The first beep will occur
											//		without any delay

//
//	C o n s t r u c t o r s
//
	public Alarm()
	{
		super("Alarm");						//	With the default constructor,
		bleepbleep = null;				//		nobody will be notified
	}

	public Alarm(AlarmListener someBody)
	{
		super("Alarm");						//	In general,  we expect to know who
		bleepbleep = someBody;			//		(i.e., which object) to notify
	}

	public Alarm(String name, AlarmListener someBody)
	{
		super(name);						//	We can also give a name to the alarm
		bleepbleep = someBody;
	}

//
//	The setPeriod method will set or reset the period by which beeps will occur.
//	Note that the new period will be used after reception of the following beep.
//
	public void setPeriod(int someDelay)
	{										//	Note:  The period should be expressed
		delay = someDelay;					//				in milliseconds
	}

//
//	The setPeriodicBeep method will keep on notifying the "object in charge"
//		at set time intervals.
//	Note that the time interval can be changed at any time through setPeriod.
//
	private void setPeriodicBeep(int someDelay)
	{
		delay = someDelay;
		try {
			while (running){					//	Until signaled to stop,
				Thread.sleep(delay);	//		first we wait
				if (bleepbleep != null)		//		then we notify the
					bleepbleep.takeNotice();//		the guy party
			}									
		}
		catch(InterruptedException e) {
			System.err.println("Great... " + e.getMessage());
		}
		System.out.println("This alarm is now finished and done. He doens't want to see you anymore.");
	}

/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	//
//	The alarm is a Thread, and the run method gets the thread started, and running.
//
	public void run()
	{
		running = true;//added to allow stopping
		System.out.println("The alarm is now running.");
		setPeriodicBeep(delay);
	}
	

}	//	end of class Alarm

import java.util.Date;
import java.util.ArrayList;

import javax.mail.Message;


public class MyMessage {
	Message message;
	String sentFrom;
	String replyTo;
	String subject;
	String text;
	Date date;
	ArrayList<String> tags = new ArrayList<String>();	
	
	public MyMessage(Message message, String sentFrom, String replyTo, String subject, String text, Date date){
		this.sentFrom = sentFrom;
		this.replyTo = replyTo;
		this.subject = subject;
		this.text = text;	
		this.date = date;
	}

}

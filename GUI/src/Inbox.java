import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.ReadOnlyFolderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Inbox {
	ArrayList<MyMessage> messageList;
	ArrayList<MyMessage> outgoingList;
	HashMap<String, ArrayList<Integer>> tagMap= new HashMap<String, ArrayList<Integer>>();
	HashMap<String, ArrayList<MyMessage>> tagMessageMap= new HashMap<String, ArrayList<MyMessage>>();
	//add outgoing messages
	Folder folder = null;
	static String username;
	static String password;

	// Constructor Call
	public Inbox() {
		//in keeping with objective design, init instance vars in the constructor, assuming this creates no problems -Eddie
		messageList  = new ArrayList<MyMessage>();
		outgoingList = new ArrayList<MyMessage>();
	}
	
	public void login(String u, String p){
		username = u;
		password = p;
		processMail();
	}
	
	
	/**
	 * Logs into the given email account(presently fixed) via smtp, accesses its inbox, downloads it, and adds its contents to
	 * the messageList.
	 */
	public void processMail() {
		messageList.clear();
		Session session = null;
		Store store = null;
		Message message = null;
		Message[] messages = null;
		Object messagecontentObject = null;
		String sender = null;
		String replyTo = null;
		String subject = null;
		Multipart multipart = null;
		Part part = null;
		String contentType = null;
		Properties properties = System.getProperties();
		session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			store = session.getStore("imaps");
			
			store.connect("imap.gmail.com", username,
					password);
			System.out.println("Login Successful");

			// Get a handle on the default folder
			folder = store.getDefaultFolder();

			//printData("Getting the Inbox folder.");

			// Retrieve the "Inbox"
			folder = folder.getFolder("inbox");

			// Reading the Email Index in Read / Write Mode
			folder.open(Folder.READ_WRITE);

			// Retrieve the messages
			messages = folder.getMessages();

			// Loop over all of the messages
			for (int messageNumber = 0; messageNumber < messages.length; messageNumber++) {
				// Retrieve the next message to be read
				message = messages[messageNumber];

				// Retrieve the message content
				messagecontentObject = message.getContent();
				Date messageDate = message.getReceivedDate();

				// Determine email type
				if (messagecontentObject instanceof Multipart) {
					//printData("Found Email with Attachment");
					sender = ((InternetAddress) message.getFrom()[0])
							.getPersonal();
					replyTo = ((InternetAddress)message.getReplyTo()[0]).getAddress();

					// If the "personal" information has no entry, check the
					// address for the sender information
					//printData("If the personal information has no entry, check the address for the sender information.");

					if (sender == null) {
						sender = ((InternetAddress) message.getFrom()[0])
								.getAddress();
						replyTo = ((InternetAddress)message.getReplyTo()[0]).getAddress();
						//printData("sender in NULL. Printing Address:" + sender);
					}
					//printData("Sender:" + sender);

					// Get the subject information
					subject = message.getSubject();

					//printData("Subject:" + subject);

					// Retrieve the Multipart object from the message
					multipart = (Multipart) message.getContent();

					// printData("Retrieve the Multipart object from the message");
					String text = "";
					// Loop over the parts of the email
					for (int i = 0; i < multipart.getCount(); i++) {
						// Retrieve the next part
						part = multipart.getBodyPart(i);

						// Get the content type
						contentType = part.getContentType();

						// Display the content type
						// printData("Content: " + contentType);

						if (contentType.startsWith("TEXT/PLAIN")) {
							text = part.getContent().toString();
							// printData("---------reading content type text/plain  mail -------------");
							System.out.println(text);
						} else {
							// Retrieve the file name
							String fileName = part.getFileName();
							// printData("retrive the fileName="+ fileName);
						}
					}
					messageList.add(new MyMessage(message, sender, replyTo, subject, text, messageDate));
				} else {
					//printData("Found Mail Without Attachment");
					sender = ((InternetAddress) message.getFrom()[0])
							.getPersonal();
					replyTo = ((InternetAddress)message.getReplyTo()[0]).getAddress();

					// If the "personal" information has no entry, check the
					// address for the sender information
					//printData("If the personal information has no entry, check the address for the sender information.");

					if (sender == null) {
						sender = ((InternetAddress) message.getFrom()[0])
								.getAddress();
						replyTo = ((InternetAddress)message.getReplyTo()[0]).getAddress();
						//printData("sender in NULL. Printing Address:" + sender);
					}

					// Get the subject information
					subject = message.getSubject();
					//printData("subject=" + subject);
				}
			}
			
			// Close the folder
			folder.close(true);

			// Close the message store
			store.close();
		} catch (AuthenticationFailedException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (FolderClosedException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (FolderNotFoundException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (ReadOnlyFolderException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (StoreClosedException e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Not able to process the mail reading.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a message via smtp to the given address.
	 * @param to
	 * @param subject
	 * @param text
	 * @param inbox
	 */

	public static void sendMessage(String to, String subject, String text, Inbox inbox) {
		Session session;
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.auth", "true");
		//properties.setProperty("mail.smtp.port", "" + 587);
		properties.setProperty("mail.smtp.starttls.enable", "true");
		session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			MimeMessage myMessage = new MimeMessage(session);
			myMessage.setFrom(new InternetAddress(username));
			myMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			myMessage.setSubject(subject);
			myMessage.setText(text);
			Transport.send(myMessage);
			inbox.addOutgoing(to, subject, text, myMessage);
		} catch (Exception e){
			System.out.println("ERROR: COULD NOT SEND MAIL");
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the inbox message with the given index i.
	 * 
	 * !!WARNING!! This method needs to be rewritten to account for deleting outbox messages.  Do not use the outbox delete function!
	 * 
	 * @param i
	 * 			the index of the message to be deleted.
	 */
	public void deleteMessage(int i) {
		Session session;
		Properties properties = System.getProperties();
		session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(username, password);
			}
		});
		try {
			MyMessage toBeDeleted = messageList.get(i);
			Store store = session.getStore("imaps");	
			store.connect("imap.gmail.com", username,
					password);
			folder = store.getDefaultFolder();
			folder = folder.getFolder("inbox");
			folder.open(Folder.READ_WRITE);
			Message[] messages = folder.getMessages();
			//SHOULD MAKE SURE WE HAVE THE RIGHT ONE
			messages[i].setFlag(Flags.Flag.DELETED, true);
			folder.close(true);
			
		} catch (Exception e){
			System.out.println("ERROR: COULD NOT SEND MAIL");
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a message to the outbox when it is sent.
	 * 
	 * @param to
	 * 			the destination for the message being added
	 * @param subject
	 * 			the subject line
	 * @param text
	 * 			the body
	 * @param m
	 * 			The message object created when the message is sent
	 */
	private void addOutgoing(String to, String subject, String text, Message m){
		MyMessage mess = new MyMessage(m, "Eddian", to, subject, text,
										Calendar.getInstance().getTime());
		outgoingList.add(mess);
	}

}
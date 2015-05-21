import javax.mail.AuthenticationFailedException;
import javax.mail.Flags;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class GUI extends JFrame {
	final int PANELWIDTH = 900;
	final int PANELHEIGHT = 400;
	final int MESSAGELINEHEIGHT = 40;
	final int TEXTINPUTWIDTH = 200;
	final int BUTTONHEIGHT = 30;
	final int TEXTINPUTHEIGHT = 30;
	String user, pwd, hist;
	Inbox myBox;
	ArrayList<JPanel> messageLines= new ArrayList<JPanel>();
	ArrayList<JPanel> outboxMLines= new ArrayList<JPanel>();
	ArrayList<JButton> viewButtons = new ArrayList<JButton>();
	ArrayList<JButton> outboxVButtons = new ArrayList<JButton>();
	LinkedList<JCheckBox> CBlist = new LinkedList<JCheckBox>();
	LinkedList<JCheckBox> outboxCBList = new LinkedList<JCheckBox>();
	boolean boxesSelected[];
	JPanel loginView, inboxView, outboxView, messageView, composeView, settingsView, threadView, threadMessageView;
	JPanel messageLine, taskBar, composeTaskBar, viewTaskBar, outboxTaskBar, settingsTaskBar, threadTaskBar, mThreadBar;
	JTextField username, password, toField, subjectField, searchBar;
	JTextField rSelectedVal, gSelectedVal, bSelectedVal, rTaggedVal, gTaggedVal, bTaggedVal;
	JTextArea textArea;
	JButton delete, outboxDelete, compose, reply, forward, outboxForward, sendButton, returnButton, backButton,
	searchButton, outboxButton, settingsButton, colorSelectedButton, colorTaggedButton;
	JTextField labelField;
	JButton reply2, forward2, labelButton;
	//HashMap<String, ArrayList<Integer>> tagMap= new HashMap<String, ArrayList<Integer>>();
	//HashMap<String, ArrayList<MyMessage>> tagMessageMap= new HashMap<String, ArrayList<MyMessage>>();
	HashMap<String, ArrayList<MyMessage>> authorMap = new HashMap<String, ArrayList<MyMessage>>();
	Color selected, tagged;
	int view; /*-1 = loginView, 0 = inboxView, 1 = composeView, 2 = messageView, 3 = outboxView
	           4 = settingsView, 5 = threadView,  6 = threadMessageView*/
	private JButton thread;

	public GUI(Inbox myBox){
		selected = new Color(28, 134, 238);
		tagged = new Color(219, 112, 147);
		this.myBox = myBox;
		view = -1;
		GUI.this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		forceLogin();
	}
	
	public GUI(Inbox myBox, int a){
		selected = new Color(28, 134, 238);
		tagged = new Color(219, 112, 147);
		this.myBox = myBox;
		view = -1;
		GUI.this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createAndShowGUI(0);
		pack();
		setVisible(true);
	}
	
	private void forceLogin() {
		this.setPreferredSize(new Dimension(PANELWIDTH, PANELHEIGHT));
		this.setResizable(false);
		loginView = new JPanel();
		loginView.setLayout(new BoxLayout(loginView, BoxLayout.Y_AXIS));
		JPanel usernameLine = new JPanel();
		usernameLine.setLayout(new BoxLayout(usernameLine, BoxLayout.X_AXIS));
		JPanel passwordLine = new JPanel();
		passwordLine.setLayout(new BoxLayout(passwordLine, BoxLayout.X_AXIS));
		
		usernameLine.setPreferredSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		usernameLine.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		passwordLine.setPreferredSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		passwordLine.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		
		
		JLabel titleTag = new JLabel("Welcome!");
		
		username = new JTextField();
		username.setMinimumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		username.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		username.setPreferredSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		JLabel userTag = new JLabel("Username: ");
		password = new JPasswordField();
		password.setMinimumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		password.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		password.setPreferredSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
		JLabel pwordTag = new JLabel("Password: ");
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				myBox.login(username.getText(), password.getText());
				createAndShowGUI(1);
			}
		});
		JRootPane rootPane = GUI.this.getRootPane();
	    rootPane.setDefaultButton(login);
		
		usernameLine.add(userTag);
		usernameLine.add(username);
		passwordLine.add(pwordTag);
		passwordLine.add(password);
		
		loginView.add(usernameLine);
		loginView.add(passwordLine);
		loginView.add(login);
		this.add(loginView);
		this.pack();
		this.setVisible(true);
	}
	
	public void createAndShowGUI(int a){
		if (a == 1){
			this.remove(loginView);
		}
		inboxView = new JPanel();
		this.setTitle("Welcome");
		this.setPreferredSize(new Dimension(PANELWIDTH, PANELHEIGHT));

		/*ADD A BUTTON FOR MESSAGE DELETION*/
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int numDel = 0;
					for(int i = 0; i < boxesSelected.length; i++){
						if(boxesSelected[i] == true){
							myBox.deleteMessage(i-numDel);
							myBox.messageList.remove(i-numDel);
							messageLines.remove(i-numDel);	
							numDel++;
						}
					}
					messageLines.clear();
					CBlist.clear();
					viewButtons.clear();
					formInbox(0, new ArrayList<Integer>());
				}
			});
		/*CREATE UNIVERSAL RETURN BUTTON*/
		returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//GUI.this.removeAll();
				//createAndShowGUI();
				if (view == 1)
					GUI.this.remove(composeView);
				else if (view == 2){
					GUI.this.remove(messageView);
					messageView = null;
					viewTaskBar = null;
				}
				else if (view == 3)
					GUI.this.remove(outboxView);
				else if (view == 4)
					GUI.this.remove(settingsView);
				else if (view == 5)
					GUI.this.remove(threadView);
				else if (view == 6)
					GUI.this.remove(threadMessageView);
				
				
				new GUI(myBox, 1);
				GUI.this.dispose();
				
				CBlist = new LinkedList<JCheckBox>();
				for(int i = 0; i < boxesSelected.length; i++){
					boxesSelected[i] = false;
					CBlist.add(new JCheckBox());
				}
				formInbox(0, new ArrayList<Integer>());
				
				GUI.this.add(inboxView);
				view = 0;
				
				GUI.this.pack();
				GUI.this.repaint();
			}
		});
		
		/*CREATE THE BUTTON TO CREATE A NEW OUTGOING MESSAGE*/
		compose = new JButton("Compose");
		compose.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					createButton(1);
				}
			});
		
		reply = new JButton("Reply");
		reply.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						createButton(2);
				}
		});
		
		forward = new JButton("Forward");
		forward.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					createButton(3);		
				}
		});
		
		thread = new JButton("Conversations");
		thread.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				threadView = new JPanel();
				threadView.setLayout(new BoxLayout(threadView, BoxLayout.Y_AXIS));
				view = 5;
				GUI.this.remove(inboxView);
				/*WOULD BE GOOD TO ADD OUTBOX MESSSAGES*/
				authorMap.clear();
				for(int i = 0; i < myBox.messageList.size(); i++){
					if (authorMap.containsKey(myBox.messageList.get(i).sentFrom)) {
						authorMap.get(myBox.messageList.get(i).sentFrom).add(myBox.messageList.get(i));
					} else {
						ArrayList<MyMessage> temp = new ArrayList<MyMessage>();
						temp.add(myBox.messageList.get(i));
						authorMap.put(myBox.messageList.get(i).sentFrom, temp);
					}
				}
				HashMap<String, ArrayList<MyMessage>> sentMap = new HashMap<String, ArrayList<MyMessage>>();
				for(int i = 0; i < myBox.outgoingList.size(); i++){
					if (sentMap.containsKey(myBox.outgoingList.get(i).sentFrom)) {
						sentMap.get(myBox.outgoingList.get(i).replyTo).add(myBox.outgoingList.get(i));
					} else {
						ArrayList<MyMessage> temp = new ArrayList<MyMessage>();
						temp.add(myBox.outgoingList.get(i));
						sentMap.put(myBox.outgoingList.get(i).replyTo, temp);
					}
				}
				Set<String> authors = authorMap.keySet();
				ArrayList<JPanel> threadLines = new ArrayList<JPanel>();
				Iterator<String> iter = authors.iterator();
				int i = 0;
				while (iter.hasNext()) {
				  String author = iter.next();
				  ArrayList<MyMessage> messages = authorMap.get(author);
				  ArrayList<MyMessage> sentMess = sentMap.get(messages.get(0).replyTo);
				  JPanel threadLine = new JPanel();
				  JLabel sender = new JLabel(author);
				  threadLine.add(sender);
				  threadLine.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
				  threadLine.setMinimumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
				  if(i%2 == 0){
						threadLine.setBackground(new Color(255,255,255));
					} else { 
						threadLine.setBackground(new Color(200, 200, 200));
					}
				  threadLine.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
				  threadLines.add(threadLine);
				  JButton threadViewButton = new JButton("View Conversation");
				  
				  final ArrayList<MyMessage> tempMessages = messages; 
				  
				  final ArrayList<MyMessage> tempSent;
				  if (sentMess != null){
					  tempSent = sentMess;
				  } else
					  tempSent = new ArrayList<MyMessage>();
					  
				  
				  threadViewButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						GUI.this.remove(threadView);
						view = 6;
						
						threadMessageView = new JPanel();
						threadMessageView.setLayout(new BoxLayout(threadMessageView, BoxLayout.Y_AXIS));
						
						mThreadBar = new JPanel();
						
						
						mThreadBar.add(returnButton);
						
						
						mThreadBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
						mThreadBar.setBackground(new Color(150, 150, 150));
						mThreadBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
						mThreadBar.setMinimumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
						
						threadMessageView.add(mThreadBar);
						ArrayList<MyMessage> messageOrder = tempMessages;
						ArrayList<Integer> convoOrder = new ArrayList<Integer>();
						for(int k = 0; k < messageOrder.size(); k++){
							convoOrder.add(0);
						}
						for (int k = 0; k < tempSent.size(); k++){
							MyMessage curr = tempSent.get(k);
							boolean flag = false;
							for(int j = 0; j < messageOrder.size(); j++){
								if (messageOrder.get(j).date.compareTo(curr.date) > 0 && !flag){
									flag = true;
									messageOrder.add(j, curr);
									convoOrder.add(j, 1);
								}
							}
							if (!flag){
								messageOrder.add(curr);
								convoOrder.add(1);
							}
						}
						ArrayList<JTextArea> messageHolders = new ArrayList<JTextArea>();
						/*need to figure out how to get the spacing to work right for this.*/
						
						for(int j = 0; j < messageOrder.size(); j++){
							JTextArea messageHolder = new JTextArea(messageOrder.get(j).text);
							messageHolder.setBorder(new EtchedBorder(new Color(255, 255, 255), new Color(255, 255, 255)));
							messageHolders.add(messageHolder);
						}
						JPanel tmvMessages = new JPanel();
						tmvMessages.setLayout(new BoxLayout(tmvMessages, BoxLayout.Y_AXIS));
						tmvMessages.setMaximumSize(new Dimension(PANELWIDTH, 400));
						tmvMessages.setMinimumSize(new Dimension(PANELWIDTH, 400));
						for(int j = 0; j < messageHolders.size(); j++){
							JLabel info = new JLabel("From: " + messageOrder.get(j).sentFrom + 
									       "; Subject: " + messageOrder.get(j).subject + 
									       "; Date: " + messageOrder.get(j).date);
							tmvMessages.add(info);
							/*ABOVE DOES SUBJECT*/
							if(convoOrder.get(j) == 1){
								messageHolders.get(j).setBackground(new Color(255, 0, 0));
							} else {
								messageHolders.get(j).setBackground(new Color(0, 255, 0));
							}
							tmvMessages.add(messageHolders.get(j));
						}
						JScrollPane scroll = new JScrollPane(tmvMessages);
						
						
						/*IN PROGRESS*/
						final ArrayList<MyMessage> temp = messageOrder;
						JPanel newMessageLine = new JPanel();
						newMessageLine.setBackground(new Color(150,150,150));
						newMessageLine.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
						newMessageLine.setMinimumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
						newMessageLine.setLayout(new BoxLayout(newMessageLine, BoxLayout.X_AXIS));
						final JTextField replyArea = new JTextField(30);
						JButton sendReplyButton = new JButton("Send!");
						sendReplyButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0) {
								Inbox.sendMessage(temp.get(0).replyTo, "", replyArea.getText(), myBox);
								replyArea.setText("");
							}
						});
													
						
						newMessageLine.add(replyArea);
						newMessageLine.add(sendReplyButton);
						
						
						threadMessageView.add(scroll);
						threadMessageView.add(newMessageLine);
						GUI.this.add(threadMessageView);
						GUI.this.pack();
					}
				  });
				  threadLine.add(threadViewButton);
				  i++;
				}
					
				threadTaskBar = new JPanel();
				threadTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
				threadTaskBar.setBackground(new Color(150, 150, 150));
				threadTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
				threadTaskBar.add(returnButton);

				threadView.add(threadTaskBar);
				for(i = 0; i < threadLines.size(); i++){
					threadView.add(threadLines.get(i));
				}

				GUI.this.add(threadView);
				GUI.this.pack();
			}
		});
		
		
		searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(100, TEXTINPUTHEIGHT));
		searchBar.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
			    if(searchBar.getText().length() == 0){
			    	formInbox(0, new ArrayList<Integer>());
			    	JRootPane rootPane = GUI.this.getRootPane();
				    rootPane.setDefaultButton(searchButton);
			    	searchBar.setBackground(new Color(255,255,255));
			    } else if(searchBar.getText().charAt(0) == '#'){
					searchBar.setBackground(tagged);
				}
			}
			public void keyTyped(KeyEvent e) {
			}
			
		});
		
		searchButton = new JButton("Search!");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String searchTerm = searchBar.getText();

					messageLines.clear();
					CBlist.clear();
					viewButtons.clear();
					if(searchTerm.isEmpty()){
						formInbox(0, new ArrayList<Integer>());
					}
					else if(searchTerm.startsWith("#")){
						searchTerm = searchTerm.substring(1, searchTerm.length());
						if(myBox.tagMap.containsKey(searchTerm)){
							formInbox(0, myBox.tagMap.get(searchTerm));
						}
						else{
							JOptionPane.showMessageDialog(null, "Tag not used.");
						}
					} else {
						ArrayList<Integer> toBeColored = new ArrayList<Integer>();
						for(int i = 0; i < myBox.messageList.size(); i++){
							if(myBox.messageList.get(i).subject.toLowerCase().contains(searchTerm.toLowerCase()) | 
							   myBox.messageList.get(i).text.toLowerCase().contains(searchTerm.toLowerCase()) | 
							   myBox.messageList.get(i).sentFrom.toLowerCase().contains((searchTerm.toLowerCase()))){
								toBeColored.add(i);
							}
						}
						formInbox(0, toBeColored);
					}
					JRootPane rootPane = GUI.this.getRootPane();
				    rootPane.setDefaultButton(searchButton);
				}
				//do search	
		});
		
		JRootPane rootPane = GUI.this.getRootPane();
	    rootPane.setDefaultButton(searchButton);
		
		outboxButton = new JButton("Sent");
		outboxButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getOutbox();
			}
		});
		/*ADD STUFF HERE*/
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				myBox.processMail();
				GUI.this.pack();
				GUI.this.repaint();
			}	
		});
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				view = 4;
				GUI.this.remove(inboxView);
				settingsView = new JPanel();
				settingsView.setLayout(new BoxLayout(settingsView, BoxLayout.Y_AXIS));
				settingsTaskBar = new JPanel();
				settingsTaskBar.add(returnButton);
				settingsView.add(settingsTaskBar);
				JPanel selectedColorLine = new JPanel();
				selectedColorLine.setLayout(new BoxLayout(selectedColorLine, BoxLayout.X_AXIS));
				rSelectedVal = new JTextField();
				rSelectedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				gSelectedVal = new JTextField();
				gSelectedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				bSelectedVal = new JTextField();
				bSelectedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				colorSelectedButton = new JButton("Color!");
				colorSelectedButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						int red = Integer.parseInt(rSelectedVal.getText());
						int green = Integer.parseInt(gSelectedVal.getText());
						int blue = Integer.parseInt(bSelectedVal.getText());
						selected = new Color(red, green, blue);
					}
				});
				selectedColorLine.add(rSelectedVal);
				selectedColorLine.add(gSelectedVal);
				selectedColorLine.add(bSelectedVal);
				selectedColorLine.add(colorSelectedButton);
				JPanel taggedColorLine = new JPanel();
				taggedColorLine.setLayout(new BoxLayout(taggedColorLine, BoxLayout.X_AXIS));
				rTaggedVal = new JTextField();
				rTaggedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				gTaggedVal = new JTextField();
				gTaggedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				bTaggedVal = new JTextField();
				bTaggedVal.setMaximumSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
				colorTaggedButton = new JButton("Color!");
				colorTaggedButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						int red = Integer.parseInt(rTaggedVal.getText());
						int green = Integer.parseInt(gTaggedVal.getText());
						int blue = Integer.parseInt(bTaggedVal.getText());
						tagged = new Color(red, green, blue);
					}
				});
				taggedColorLine.add(rTaggedVal);
				taggedColorLine.add(gTaggedVal);
				taggedColorLine.add(bTaggedVal);
				taggedColorLine.add(colorTaggedButton);
				settingsView.add(selectedColorLine);
				settingsView.add(taggedColorLine);
				
				GUI.this.add(settingsView);
				GUI.this.repaint();
				GUI.this.pack();
			}	
		});
		
		taskBar = new JPanel();
		taskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
		taskBar.setBackground(new Color(150, 150, 150));
		taskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
		taskBar.add(outboxButton);
		taskBar.add(refreshButton);
		taskBar.add(thread);
		taskBar.add(compose);
		taskBar.add(reply);
		taskBar.add(forward);
		taskBar.add(delete);
		taskBar.add(searchBar);
		taskBar.add(searchButton);
		taskBar.add(settingsButton);
		taskBar.repaint();
		
		formInbox(0, new ArrayList<Integer>());
	}

	protected void createButton(int mode) {
		int exactlyOneBox;
		if (mode > 1){
			exactlyOneBox = 0;
			for(int i = 0; i < boxesSelected.length; i++){
				if (boxesSelected[i]){
					if (exactlyOneBox == 0)
						exactlyOneBox = 1;
					else if (exactlyOneBox == 1)
						exactlyOneBox = 2;
				}	
			}
		} else { 
			exactlyOneBox = 1;
		} 
		if (exactlyOneBox == 1){
			composeView = new JPanel();
			composeView.setLayout(new BoxLayout(composeView, BoxLayout.Y_AXIS));
			
			composeTaskBar= new JPanel();
			composeTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
			composeTaskBar.setBackground(new Color(150, 150, 150));
			composeTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
			
			/*CREATE THE BUTTON TO SEND A MESSAGE*/
			sendButton = new JButton("Send");
			sendButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String[] addressArray = GUI.this.toField.getText().split("; ");
					for(int i = 0; i < addressArray.length; i++){
						System.out.println(addressArray[i]);
						Inbox.sendMessage(addressArray[i], GUI.this.subjectField.getText(), GUI.this.textArea.getText(),myBox);
					}
					GUI.this.remove(composeView);
					GUI.this.add(inboxView);
					GUI.this.repaint();
					}
			});
			composeTaskBar.add(sendButton);
			composeTaskBar.add(returnButton);
			
		
		
			/*TO LINE*/
			toField = new JTextField(50);
			JLabel toLabel = new JLabel("To: ");
			JPanel toLine = new JPanel();
			toLine.setLayout(new FlowLayout(FlowLayout.LEFT));
			toLine.add(toLabel);
			toLine.add(toField);
			/*SUBJECT  LINE*/
			subjectField = new JTextField(50);
			JLabel subjectLabel = new JLabel("Subject: ");
			JPanel subjectLine = new JPanel();
			subjectLine.setLayout(new FlowLayout(FlowLayout.LEFT));
			subjectLine.add(subjectLabel);
			subjectLine.add(subjectField);
			/*TEXT BOX*/
			textArea = new JTextArea();
			textArea.setBorder(new EtchedBorder(new Color(0, 0, 0), new Color(150, 150, 150)));
			
			/*DO DIFFERENT THINGS FOR DIFFERENT MODES*/
			if (mode == 2){
				for(int i = 0; i < boxesSelected.length; i++){
					if (boxesSelected[i] == true){
						toField.setText(myBox.messageList.get(i).replyTo);
					}
				}
			} else if (mode == 3){
				for(int i = 0; i < boxesSelected.length; i++){
					if (boxesSelected[i] == true){
						subjectField.setText(myBox.messageList.get(i).subject);
						textArea.setText(myBox.messageList.get(i).text);
					}
				}
			}
			
		
			/*ADD TO PANEL*/
		
			composeTaskBar.add(sendButton);
			composeTaskBar.add(returnButton);
			composeView.add(composeTaskBar);
			composeView.add(toLine);
			composeView.add(subjectLine);
		
			
			composeView.add(textArea);
		
			GUI.this.remove(inboxView);
			view = 1;
			GUI.this.add(composeView);
			GUI.this.pack();
		} else if (exactlyOneBox == 0){
			JOptionPane.showMessageDialog(null, "No messages selected.");
		} else {
			if (mode == 2){
				JOptionPane.showMessageDialog(null, "Cannot reply to multiple messages.");
			} else {
				JOptionPane.showMessageDialog(null, "Cannot forward multiple messages.");
			}
		}
	}
	
	
	

	/**
	 * Generates a set of messages lines and adds them to a display with a set of buttons to manipulate them.
	 * if mode is 0, generates the inbox.  Otherwise it generates the outbox.
	 * @param mode
	 * 
	 * @param toColor
	 * 		List of messages to be colored red.
	 */
	private void formInbox(int mode, final ArrayList<Integer> toColor) {//may need to make changes here to accomodate generation of outbox
		JPanel viewPanel, vTaskBar;
		final ArrayList<JPanel> mLines;
		ArrayList<MyMessage> messList;
		ArrayList<JButton> vButtons;
		LinkedList<JCheckBox> viewCBList;
		final int returnMode = mode;
		

		if(mode == 0){
			messList = myBox.messageList;
			viewPanel = inboxView;
			vTaskBar = taskBar;
			vButtons = viewButtons;
			mLines = messageLines;
			viewCBList = CBlist;
		}else{
			messList = myBox.outgoingList;
			viewPanel = outboxView;
			vTaskBar = outboxTaskBar;
			vButtons = outboxVButtons;
			mLines = outboxMLines;
			viewCBList = outboxCBList;
		}
		boxesSelected = new boolean[messList.size()]; 
		for(int i = 0; i < boxesSelected.length; i++){
			boxesSelected[i] = false;
		}
		if(view != -1){
			remove(viewPanel);
		}
		viewPanel = new JPanel();
		viewPanel.setMaximumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
		viewPanel.setMinimumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
		viewPanel.add(vTaskBar);
		
		JPanel messageArea = new JPanel();
		messageArea.setLayout(new BoxLayout(messageArea, BoxLayout.Y_AXIS));
		
		mLines.clear();
		for(int i = 0; i < messList.size(); i++){
			JLabel sender = new JLabel(messList.get(i).sentFrom);
			JLabel subject = new JLabel(messList.get(i).subject);
			JLabel text = new JLabel(messList.get(i).text);
			JLabel date = new JLabel(messList.get(i).date.toString());
			sender.setPreferredSize(new Dimension(100, 25));
			subject.setPreferredSize(new Dimension(100, 25));
			date.setPreferredSize(new Dimension(200, 25));
			text.setPreferredSize(new Dimension(200, 25));
			
			vButtons.add(new JButton("View"));
			vButtons.get(i).setPreferredSize(new Dimension(75, BUTTONHEIGHT));
			final int buttonNo = i;
			vButtons.get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					getViewButton(buttonNo, returnMode);
				}
			});
			
			messageLine = new JPanel();
			viewCBList.add(new JCheckBox());
			viewCBList.get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (boxesSelected[buttonNo] == false){
						boxesSelected[buttonNo] = true;
						mLines.get(buttonNo).setBackground(selected);
					}
					else{
						boxesSelected[buttonNo] = false;
						if(toColor.contains(buttonNo)){
							mLines.get(buttonNo).setBackground(tagged);
						} else {
							if(buttonNo%2 == 0){
								mLines.get(buttonNo).setBackground(new Color(255,255,255));
							} else { 
								mLines.get(buttonNo).setBackground(new Color(200, 200, 200));
							}
						}
					}
				}					
			});
			messageLine.add(viewCBList.get(i));
			messageLine.add(sender);
			messageLine.add(subject);
			messageLine.add(date);
			//messageLine.add(text);
			messageLine.add(vButtons.get(i));
			messageLine.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
			if(toColor.contains(i)){
				messageLine.setBackground(tagged);
			} else {
				if(i%2 == 0){
					messageLine.setBackground(new Color(255,255,255));
				} else { 
					messageLine.setBackground(new Color(230, 230, 230));
				}
			}
			messageLine.setBorder(new EtchedBorder(new Color(0,0,0), new Color(150, 150, 150)));
			mLines.add(messageLine);
		}
		for(int i = mLines.size() - 1; i >= 0; i--){
			messageArea.add(mLines.get(i));
		}
		
		JScrollPane scroll = new JScrollPane(messageArea);
		viewPanel.add(scroll);
		
		if(mode == 0){
			view = 0;
			System.out.println("Inbox view");
		}else{
			view = 3;
			System.out.println("Outbox view");
			System.out.println(mLines.size());
			System.out.println(messList.size());
			System.out.println(myBox.outgoingList.size());
		}
		
		if(mode == 0){
			inboxView = viewPanel;
			add(inboxView);
			this.pack();
			this.repaint();
		}else{
			outboxView = viewPanel;
			add(outboxView);
			this.pack();
		}
	}

	/**
	 * returns the behavior of a view button
	 * @param buttonNo
	 * 					The number of the button in its given button list
	 * @param mode
	 * 				Determines whether the button is being created for the inbox or outbox
	 */
	protected void getViewButton(final int buttonNo, int mode) {
		GUI.this.remove(inboxView);
		inboxView = new JPanel();
		for(JButton b: viewButtons){
			b = new JButton();
		}
		final JPanel viewPanel;
		final ArrayList<MyMessage> messList;
		if(mode == 0){
			messList = myBox.messageList;
			viewPanel = inboxView;
		}else{
			messList = myBox.outgoingList;
			viewPanel = outboxView;
		}
			messageView = new JPanel();
			messageView.setLayout(new BoxLayout(messageView, BoxLayout.Y_AXIS));
			messageView.setMaximumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
			messageView.setMinimumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
			
			viewTaskBar= new JPanel();
			viewTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
			viewTaskBar.setBackground(new Color(150, 150, 150));	
			viewTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
			viewTaskBar.setMinimumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
			
			
			String tagDisplay = "Tags: ";
			for(String tag: myBox.tagMap.keySet()){
				if(myBox.tagMap.get(tag).contains(buttonNo)){
					tagDisplay += tag+", ";
				}
			}
			final JLabel tagLabel = new JLabel(tagDisplay);
			
			/*
			 * Here I basically just copied and pasted your code for generating compose view, except with a couple tweaks
			 * to remove accounting for nodes and adding destination and content
			 * --Eddie
			 */
			
			reply2 = new JButton("Reply");
			reply2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				composeView = new JPanel();
				composeView.setLayout(new BoxLayout(composeView, BoxLayout.Y_AXIS));
				
				composeTaskBar= new JPanel();
				composeTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
				composeTaskBar.setBackground(new Color(150, 150, 150));
				composeTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
				
				/*CREATE THE BUTTON TO SEND A MESSAGE*/
				sendButton = new JButton("Send");
				sendButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String[] addressArray = GUI.this.toField.getText().split("; ");
						for(int i = 0; i < addressArray.length; i++){
							System.out.println(addressArray[i]);
							Inbox.sendMessage(addressArray[i], GUI.this.subjectField.getText(), GUI.this.textArea.getText(),myBox);
						}
						GUI.this.remove(composeView);
						GUI.this.add(viewPanel);
						GUI.this.repaint();
						}
				});
				composeTaskBar.add(sendButton);
				composeTaskBar.add(returnButton);
				
			
			
				/*TO LINE*/
				toField = new JTextField(50);
				toField.setText(messList.get(buttonNo).replyTo);
				JLabel toLabel = new JLabel("To: ");
				JPanel toLine = new JPanel();
				toLine.setLayout(new FlowLayout(FlowLayout.LEFT));
				toLine.add(toLabel);
				toLine.add(toField);
				/*SUBJECT  LINE*/
				subjectField = new JTextField(50);
				subjectField.setText("re: " + messList.get(buttonNo).subject);
				JLabel subjectLabel = new JLabel("Subject: ");
				JPanel subjectLine = new JPanel();
				subjectLine.setLayout(new FlowLayout(FlowLayout.LEFT));
				subjectLine.add(subjectLabel);
				subjectLine.add(subjectField);
				/*TEXT BOX*/
				textArea = new JTextArea("\n\n--Original Message--\n" + messList.get(buttonNo).text);
				textArea.setBorder(new EtchedBorder(new Color(0, 0, 0), new Color(150, 150, 150)));
				
			
				/*ADD TO PANEL*/
			
				composeTaskBar.add(sendButton);
				composeTaskBar.add(returnButton);
				composeView.add(composeTaskBar);
				composeView.add(toLine);
				composeView.add(subjectLine);
			
				
				composeView.add(textArea);
			
				GUI.this.remove(messageView);
				view = 1;
				GUI.this.add(composeView);
				GUI.this.pack();
				}
			});
			
			/*
			 * Another copy and paste, might just end up writing a helper to combine these two
			 * -Eddie
			 */
			forward2 = new JButton("Forward");
			forward2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					composeView = new JPanel();
					composeView.setLayout(new BoxLayout(composeView, BoxLayout.Y_AXIS));
					
					composeTaskBar= new JPanel();
					composeTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
					composeTaskBar.setBackground(new Color(150, 150, 150));
					composeTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
					
					/*CREATE THE BUTTON TO SEND A MESSAGE*/
					sendButton = new JButton("Send");
					sendButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							String[] addressArray = GUI.this.toField.getText().split("; ");
							for(int i = 0; i < addressArray.length; i++){
								System.out.println(addressArray[i]);
								//Inbox.sendMessage(addressArray[i], GUI.this.subjectField.getText(), GUI.this.textArea.getText(),myBox);
							}
							GUI.this.remove(composeView);
							GUI.this.add(viewPanel);
							GUI.this.repaint();
							}
					});
					composeTaskBar.add(sendButton);
					composeTaskBar.add(returnButton);
					
				
				
					/*TO LINE*/
					toField = new JTextField(50);
					JLabel toLabel = new JLabel("To: ");
					JPanel toLine = new JPanel();
					toLine.setLayout(new FlowLayout(FlowLayout.LEFT));
					toLine.add(toLabel);
					toLine.add(toField);
					/*SUBJECT  LINE*/
					subjectField = new JTextField(50);
					subjectField.setText("fwd: " + messList.get(buttonNo).subject);
					JLabel subjectLabel = new JLabel("Subject: ");
					JPanel subjectLine = new JPanel();
					subjectLine.setLayout(new FlowLayout(FlowLayout.LEFT));
					subjectLine.add(subjectLabel);
					subjectLine.add(subjectField);
					/*TEXT BOX*/
					textArea = new JTextArea(messList.get(buttonNo).text);
					textArea.setBorder(new EtchedBorder(new Color(0, 0, 0), new Color(150, 150, 150)));
					
				
					/*ADD TO PANEL*/
				
					composeTaskBar.add(sendButton);
					composeTaskBar.add(returnButton);
					composeView.add(composeTaskBar);
					composeView.add(toLine);
					composeView.add(subjectLine);
				
					
					composeView.add(textArea);
				
					GUI.this.remove(messageView);
					view = 1;
					GUI.this.add(composeView);
					GUI.this.pack();
				}
			});
			
			
			labelField = new JTextField();
			labelField.setText("Add a tag with #!");
			labelField.setPreferredSize(new Dimension(TEXTINPUTWIDTH, TEXTINPUTHEIGHT));
			labelField.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent arg0) {
					labelField.setText("#");
				}
				public void focusLost(FocusEvent arg0) {
					hist = labelField.getText();
					labelField.setText("Add a tag with #!");
				}			
			});
			
			labelButton = new JButton("Add Tag");
			labelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					String labelText = hist;
					String[] labelArray = labelText.split(", ");
					for(int j = 0; j < labelArray.length; j++){
						if(labelArray[j].startsWith("#")){
							labelArray[j] = labelArray[j].substring(1, labelArray[j].length());
							messList.get(buttonNo).tags.add(labelArray[j]);
							if(myBox.tagMap.containsKey(labelArray[j])){
								myBox.tagMap.get(labelArray[j]).add(buttonNo);
							} else {
								myBox.tagMap.put(labelArray[j], new ArrayList<Integer>());
								myBox.tagMap.get(labelArray[j]).add(buttonNo);
							}
							String tagD = "Tags; ";
							for(String tag: myBox.tagMap.keySet()){
								if(myBox.tagMap.get(tag).contains(buttonNo)){
									tagD += tag+", ";
								}
							}
							tagLabel.setText(tagD);
							System.out.println(labelArray[j]);
						} else {
							JOptionPane.showMessageDialog(null, "Not a valid tag. Tags begin with \"#\"\n#example");
						}
					}
					labelField.setText("Add a tag with #!");
					hist = null;
					//This takes what's in labelField, puts it in labelarray for message, and clears labelField
				}
			});
			
			viewTaskBar.add(returnButton);
			viewTaskBar.add(reply2);//put in a NEW REPLY AND FORWARD BUTTON HERE
			viewTaskBar.add(forward2);
			viewTaskBar.add(labelField);
			viewTaskBar.add(labelButton);
			
			messageView.add(viewTaskBar);
			JLabel sender = new JLabel("From: " + messList.get(buttonNo).sentFrom);
			JPanel senderP = new JPanel();
			senderP.setLayout(new FlowLayout(FlowLayout.LEFT));
			senderP.add(sender);
			senderP.setMaximumSize(new Dimension(PANELWIDTH, 20));
			JLabel subject = new JLabel("Subject: "  + messList.get(buttonNo).subject);
			JPanel subjectP = new JPanel();
			subjectP.setLayout(new FlowLayout(FlowLayout.LEFT));
			subjectP.add(subject);
			subjectP.setMaximumSize(new Dimension(PANELWIDTH, 20));
			JLabel date = new JLabel("Date: " + messList.get(buttonNo).date);
			JPanel dateP = new JPanel();
			dateP.setLayout(new FlowLayout(FlowLayout.LEFT));	
			dateP.add(date);
			dateP.setMaximumSize(new Dimension(PANELWIDTH, 20));
			
			JPanel infoPanel = new JPanel();
			JPanel tagPanel = new JPanel();
			JPanel senderPanel = new JPanel();
			infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			senderPanel.setLayout(new BoxLayout(senderPanel, BoxLayout.Y_AXIS));
			tagPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			tagPanel.add(tagLabel);
			senderPanel.add(senderP);
			senderPanel.add(subjectP);
			senderPanel.add(dateP);
			infoPanel.add(senderPanel);
			infoPanel.add(tagPanel);
			
			
			JTextArea text = new JTextArea(messList.get(buttonNo).text);
			
			
			//messageView.add(subjectP);
			//messageView.add(senderP);
			//messageView.add(dateP);
			messageView.add(infoPanel);
			messageView.add(text);
			
			
			GUI.this.remove(viewPanel);
			view = 2;
			GUI.this.add(messageView);
			GUI.this.pack();
	}
	
	/**
	 * Builds and displays the outbox.
	 */
	private void getOutbox(){
		outboxView = new JPanel();
		
		/*ADD A BUTTON FOR MESSAGE DELETION*/
		outboxDelete = new JButton("Delete");
		outboxDelete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int numDel = 0;
					for(int i = 0; i < boxesSelected.length; i++){
						if(boxesSelected[i] == true){
							//myBox.deleteMessage(i-numDel);
							myBox.outgoingList.remove(i-numDel);
							outboxMLines.remove(i-numDel);	
							numDel++;
						}
					}
					outboxMLines.clear();
					outboxCBList.clear();
					outboxVButtons.clear();
					formInbox(1, new ArrayList<Integer>());
				}
			});
		
		outboxForward = new JButton("Forward");
		outboxForward.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int exactlyOneBox = 0;
				for(int i = 0; i < boxesSelected.length; i++){
					if (boxesSelected[i]){
						if (exactlyOneBox == 0)
							exactlyOneBox = 1;
						else if (exactlyOneBox == 1)
							exactlyOneBox = 2;
					}	
				}
				if (exactlyOneBox == 1){
					composeView = new JPanel();
					composeView.setLayout(new BoxLayout(composeView, BoxLayout.Y_AXIS));
					
					composeTaskBar= new JPanel();
					composeTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
					composeTaskBar.setBackground(new Color(150, 150, 150));
					composeTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
					
					/*CREATE THE BUTTON TO SEND A MESSAGE*/
					sendButton = new JButton("Send");
					sendButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							String[] addressArray = GUI.this.toField.getText().split("; ");
							for(int i = 0; i < addressArray.length; i++){
								System.out.println(addressArray[i]);
								//Inbox.sendMessage(addressArray[i], GUI.this.subjectField.getText(), GUI.this.textArea.getText(),myBox);
							}
							GUI.this.remove(composeView);
							GUI.this.add(outboxView);
							GUI.this.repaint();
							}
					});
					composeTaskBar.add(sendButton);
					composeTaskBar.add(returnButton);
					
				
				
					/*TO LINE*/
					toField = new JTextField(50);
					JLabel toLabel = new JLabel("To: ");
					JPanel toLine = new JPanel();
					toLine.setLayout(new FlowLayout(FlowLayout.LEFT));
					toLine.add(toLabel);
					toLine.add(toField);
					/*SUBJECT  LINE*/
					subjectField = new JTextField(50);
					JLabel subjectLabel = new JLabel("Subject: ");
					JPanel subjectLine = new JPanel();
					subjectLine.setLayout(new FlowLayout(FlowLayout.LEFT));
					subjectLine.add(subjectLabel);
					subjectLine.add(subjectField);
					/*TEXT BOX*/
					textArea = new JTextArea();
					textArea.setBorder(new EtchedBorder(new Color(0, 0, 0), new Color(150, 150, 150)));
					
					/*FORWARD*/
					for(int i = 0; i < boxesSelected.length; i++){
						if (boxesSelected[i] == true){
							subjectField.setText(myBox.messageList.get(i).subject);
							textArea.setText(myBox.messageList.get(i).text);
						}
					}
					
				
					/*ADD TO PANEL*/
				
					composeTaskBar.add(sendButton);
					composeTaskBar.add(returnButton);
					composeView.add(composeTaskBar);
					composeView.add(toLine);
					composeView.add(subjectLine);
				
					
					composeView.add(textArea);
				
					GUI.this.remove(outboxView);
					view = 1;
					GUI.this.add(composeView);
					GUI.this.pack();
				} else if (exactlyOneBox == 0){
					JOptionPane.showMessageDialog(null, "No messages selected.");
				} else {
					JOptionPane.showMessageDialog(null, "Cannot forward multiple messages.");
				}
			}
		});
		
		
		outboxTaskBar = new JPanel();
		outboxTaskBar.setBorder(new EtchedBorder(new Color(150, 150, 150), new Color (0, 0, 0)));
		outboxTaskBar.setBackground(new Color(150, 150, 150));
		outboxTaskBar.setMaximumSize(new Dimension(PANELWIDTH, MESSAGELINEHEIGHT));
		outboxTaskBar.add(returnButton);
		outboxTaskBar.add(outboxForward);
		outboxTaskBar.add(outboxDelete);
		outboxTaskBar.repaint();
		
		GUI.this.remove(inboxView);
		formInbox(1, new ArrayList<Integer>());
	}
}




/*END OF PROGRAM*/







/*STORAGE FOR METHODS WE MAY NEED LATER*/

/**
 * Updates the inboxView to display messages containing a given tag.
 * 
 * @param messagesWithTag
 */
/*

protected void refreshInbox(ArrayList<Integer> messagesWithTag) {
	remove(inboxView);
	boxesSelected = new boolean[messagesWithTag.size()]; 
	for(int i = 0; i < boxesSelected.length; i++){
		boxesSelected[i] = false;
	}
	inboxView = new JPanel();
	inboxView.setMaximumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
	inboxView.setMinimumSize(new Dimension(PANELWIDTH, PANELHEIGHT));
	inboxView.setLayout(new BoxLayout(inboxView, BoxLayout.Y_AXIS));
	inboxView.add(taskBar);
	for(int i = 0; i < messagesWithTag.size(); i++){
		JLabel sender = new JLabel(myBox.messageList.get(messagesWithTag.get(i)).sentFrom);
		JLabel subject = new JLabel(myBox.messageList.get(messagesWithTag.get(i)).subject);
		JLabel text = new JLabel(myBox.messageList.get(messagesWithTag.get(i)).text);
		JLabel date = new JLabel(myBox.messageList.get(messagesWithTag.get(i)).date);
		sender.setPreferredSize(new Dimension(100, 30));
		subject.setPreferredSize(new Dimension(100, 30));
		date.setPreferredSize(new Dimension(200, 30));
		text.setPreferredSize(new Dimension(200, 30));
		
		viewButtons.add(new JButton("View"));
		viewButtons.get(i).setPreferredSize(new Dimension(75, 30));
		final int buttonNo = messagesWithTag.get(i);
		viewButtons.get(i).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getViewButton(buttonNo, 0);
			}
		});
		
		messageLine = new JPanel();
		CBlist.add(new JCheckBox());
		CBlist.get(i).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (boxesSelected[buttonNo] == false){
					boxesSelected[buttonNo] = true;
					messageLines.get(buttonNo).setBackground(new Color(28, 134, 238));
				}
				else{
					boxesSelected[buttonNo] = false;
					if(buttonNo%2 == 0){
						messageLines.get(buttonNo).setBackground(new Color(255,255,255));
					} else { 
						messageLines.get(buttonNo).setBackground(new Color(200, 200, 200));
					}
				}
			}					
		});
		messageLine.add(CBlist.get(i));
		messageLine.add(sender);
		messageLine.add(subject);
		messageLine.add(date);
		//messageLine.add(text);
		messageLine.add(viewButtons.get(i));
		messageLine.setSize(PANELWIDTH, 30);
		messageLine.setMaximumSize(new Dimension(PANELWIDTH,30));
		messageLine.setMinimumSize(new Dimension(PANELWIDTH,30));
		//messageLine.setPreferredSize(new Dimension(PANELWIDTH,30));
		if(i%2 == 0){
			messageLine.setBackground(new Color(255,255,255));
		} else { 
			messageLine.setBackground(new Color(230, 230, 230));
		}
		messageLine.setBorder(new EtchedBorder(new Color(0,0,0), new Color(150, 150, 150)));
		messageLines.add(messageLine);
	}
	for(int i = 0; i < messageLines.size(); i++){
		inboxView.add(messageLines.get(i));
	}	
	view = 0;
	System.out.println("Add view");
	add(inboxView);
	this.pack();
	this.repaint();
}

*/

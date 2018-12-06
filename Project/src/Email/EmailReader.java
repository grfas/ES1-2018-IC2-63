package Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import GUI.Gui;
import twitter4j.Status;

/**
 * Class reads emails
 *
 * @author outlook
 *
 */

public class EmailReader {
	public List<MessagePrint> MensagemDoIscte = new ArrayList<MessagePrint>();
	private String filtroEmail="";

	public String getFiltroEmail() {
		return filtroEmail;
	}

	public void setFiltroEmail(String filtroEmail) {
		this.filtroEmail = filtroEmail;
	}

	public List<MessagePrint> getMensagemDoIscte() {
		return MensagemDoIscte;
	}
	
	public void clearMessages() {
		MensagemDoIscte.clear();
	
	}

//	public Gui gui;
//	public EmailReader(Gui gui) {
//		this.gui=gui;
//	}
	public String user;
	public String pass;

	public EmailReader(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	/**
	 * Method reads emails from the IMAP or POP3 server.
	 * 
	 * @param isImap - if true then we are reading messages from the IMAP server, if
	 *               no then read from the POP3 server.
	 */
	public void readEmails(boolean isImap) {
		
		MensagemDoIscte.clear();
		// Create all the needed properties - empty!
		Properties connectionProperties = new Properties();
		// Create the session
		Session session = Session.getDefaultInstance(connectionProperties, null);

		try {
			System.out.print("Connecting to the IMAP server...");
			// Connecting to the server
			// Set the store depending on the parameter flag value
			String storeName = isImap ? "imaps" : "pop3";
			Store store = session.getStore(storeName);

			// Set the server depending on the parameter flag value
			String server = isImap ? "imap.outlook.com" : "pop3.outlook.com";
			store.connect(server, user, pass);

			System.out.println("done!");

			// Get the Inbox folder
			Folder inbox = store.getFolder("Inbox");

			// Set the mode to the read-only mode
			inbox.open(Folder.READ_ONLY);

			// Get messages
			Message messages[] = inbox.getMessages();

			System.out.println("Reading messages...");

			// Display the messages
			int i = 0;
			for (Message message : messages) {
				for (Address a : message.getFrom()) {
					String b = a.toString();
					if (i < 25) {
						i++;
						String result = b.split(" ")[0];
//						if (result.equals(filtroEmail) || filtroEmail.equals(null)) {
						if (result.equals(filtroEmail) ) {
							System.out.println("result"+result);
							System.out.println("From:" + a);
							System.out.println("Title: " + message.getSubject());

							System.out.println();
							System.out.println(message.getContent());
							Object content = message.getContent();
							if (content instanceof MimeMultipart) {
								MimeMultipart multipart = (MimeMultipart) content;
								if (multipart.getCount() > 0) {
									BodyPart part = multipart.getBodyPart(0);
									content = part.getContent();
								}
							}
							if (content != null) {
//                 System.out.println(content.toString());
								MessagePrint mp = new MessagePrint(a, message.getSubject(), content.toString());
								MensagemDoIscte.add(mp);
								System.out.println("lista emailReader" + getMensagemDoIscte());

							}
							System.out.println("---");
						}else if(filtroEmail.equals("")) {
							System.out.println("result"+result);
							System.out.println("From:" + a);
							System.out.println("Title: " + message.getSubject());

							System.out.println();
							System.out.println(message.getContent());
							Object content = message.getContent();
							if (content instanceof MimeMultipart) {
								MimeMultipart multipart = (MimeMultipart) content;
								if (multipart.getCount() > 0) {
									BodyPart part = multipart.getBodyPart(0);
									content = part.getContent();
								}
							}
							if (content != null) {
//                 System.out.println(content.toString());
								MessagePrint mp = new MessagePrint(a, message.getSubject(), content.toString());
								MensagemDoIscte.add(mp);
								System.out.println("lista emailReader" + getMensagemDoIscte());

							}
							System.out.println("---");
						}
					} else {
						System.out.println("Não existem mais mensagens recentes");
						return;
					}
					}
//				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

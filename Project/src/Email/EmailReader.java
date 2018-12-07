package Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import GUI.Gui;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * @author Gonçalo Ferreira
 * Classe que lê os e-mails
 */

public class EmailReader {
	public List<MessagePrint> MensagemDoIscte = new ArrayList<MessagePrint>();
	private String filtroEmail="";
	public String user;
	public String pass;

	public EmailReader(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	/**
	 * getFiltroEmail,
	 * Getter que devolve o filtroEmail(filter).
	 * @return filtroEmail
	 */
	public String getFiltroEmail() {
		return filtroEmail;
	}

	/**
	 * setFiltroEmail,
	 * Setter para o filtroEmail
	 * @param filtroEmail, é filtro que vamos aplicar aquando da exibição dos e-mails.
	 */
	public void setFiltroEmail(String filtroEmail) {
		this.filtroEmail = filtroEmail;
	}

	/**
	 * getMensagemDoIscte,
	 * Getter que devolve uma Lista de MessagePrint provenientes de remetentes com o domínio do ISCTE.
	 * @return MensagemDoIscte 
	 */
	public List<MessagePrint> getMensagemDoIscte() {
		return MensagemDoIscte;
	}
	
	/**
	 * clearMessages,
	 * permite limpar as mensagens da lista MensagemDoIscte. 
	 */
	public void clearMessages() {
		MensagemDoIscte.clear();

	}

	


	/**
	 * readEmails,
	 * permite ler os e-mails de um servidor IMAP ou POP3, preferencialmente IMAP
	 * @param isImap, se se verificar "verdadeiro"(true) irá ler mensagens do servidor IMAP, se for falso lê do POP3.
	 *
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
					if (i < 5) {
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

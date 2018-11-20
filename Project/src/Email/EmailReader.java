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
	
	public List<MessagePrint> getMensagemDoIscte() {
		return MensagemDoIscte;
	}
//	public Gui gui;
//	public EmailReader(Gui gui) {
//		this.gui=gui;
//	}
   public static void main(String[] args) {
	   EmailReader em = new EmailReader();
	   em.readEmails(true);
       
   }
 
   /**
    * Method reads emails from the IMAP or POP3 server.
    * @param isImap - if true then we are reading messages from the IMAP server, if no then read from the POP3 server.
    */
   private static void readEmails(boolean isImap) {
       // Create all the needed properties - empty!
       Properties connectionProperties = new Properties();
       // Create the session
       Session session = Session.getDefaultInstance(connectionProperties,null);
      List<MessagePrint> MensagemDoIscte = new ArrayList<MessagePrint>();
       try {
           System.out.print("Connecting to the IMAP server...");
           // Connecting to the server
           // Set the store depending on the parameter flag value
           String storeName = isImap ? "imaps" : "pop3";    
           Store store = session.getStore(storeName);
            
           // Set the server depending on the parameter flag value
           String server = isImap ? "imap.outlook.com" : "pop3.outlook.com";
           store.connect(server,"grfas@iscte-iul.pt","Reconhecimento45.");
            
           System.out.println("done!");
            
           // Get the Inbox folder
           Folder inbox = store.getFolder("Inbox");
            
           // Set the mode to the read-only mode
           inbox.open(Folder.READ_ONLY);
            
           // Get messages
           Message messages[] = inbox.getMessages();
            
           System.out.println("Reading messages...");
            
           // Display the messages
           for(Message message:messages) {
               for (Address a: message.getFrom()){
            	   String b = a.toString();
                  
               
               String result = b.split(" ")[0];
               if(result.equals("ISCTE-IUL")) {
               System.out.println("From:" +a);
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
                 MessagePrint mp = new MessagePrint(message.getFrom().toString(),message.getSubject(), content.toString());
                 MensagemDoIscte.add(mp);
                 
               }
               System.out.println("---");
           }
           }
           }
            
       } catch (Exception e) {
           e.printStackTrace();
       }
        
       }
}

package Email;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

/**
* Class reads emails
*
* @author outlook
*
*/
public class EmailReader {
 
   public static void main(String[] args) {
       readEmails(true);
   }
 
   /**
    * Method reads emails from the IMAP or POP3 server.
    * @param isImap - if true then we are reading messages from the IMAP server, if no then read from the POP3 server.
    */
   private static void readEmails(boolean isImap){
       // Create all the needed properties - empty!
       Properties connectionProperties = new Properties();
       // Create the session
       Session session = Session.getDefaultInstance(connectionProperties,null);
        
       try {
           System.out.print("Connecting to the IMAP server...");
           // Connecting to the server
           // Set the store depending on the parameter flag value
           String storeName = isImap ? "imaps" : "pop3";    
           Store store = session.getStore(storeName);
            
           // Set the server depending on the parameter flag value
           String server = isImap ? "imap.outlook.com" : "pop3.outlook.com";
           store.connect(server,"Mail","Pass");
            
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
               System.out.println("---");
           }
           }
           }
            
       } catch (Exception e) {
           e.printStackTrace();
       }
        
       }
}

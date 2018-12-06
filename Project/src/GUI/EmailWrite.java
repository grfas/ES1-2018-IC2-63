package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.restfb.types.Post;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class EmailWrite extends JFrame {

	private JPanel contentPane;
	private JButton btnEnviar;
	private JTextField destinoEscritaEmail;
	private JTextField assuntoEscritaEmail;
	private JTextArea textoEscritaEmail;
	private String user;
	private String mensagem;
	 
	 private String pass;
	/**
	 * Launch the application.
	 */
	public EmailWrite(String User,String Pass,String mensagem) {		
		this.user=User;
		this.pass=Pass;
		this.mensagem=mensagem;
		init();
		events();
	}
	
	private void events() {
		
		
		
		btnEnviar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					sendEmail(user, destinoEscritaEmail.getText(), 
							assuntoEscritaEmail.getText(), textoEscritaEmail.getText());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				dispose();
				
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		destinoEscritaEmail = new JTextField();
		destinoEscritaEmail.setColumns(10);
		
		assuntoEscritaEmail = new JTextField();
		assuntoEscritaEmail.setColumns(10);

		
		textoEscritaEmail = new JTextArea();
		textoEscritaEmail.setColumns(10);
		textoEscritaEmail.setText(mensagem);
		
		btnEnviar = new JButton("Enviar");
		
		JLabel lblEndereo = new JLabel("Destino:");
		
		JLabel lblAssunto = new JLabel("Assunto");
		
		JLabel lblNewLabel = new JLabel("Texto:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(assuntoEscritaEmail, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAssunto)
						.addComponent(destinoEscritaEmail, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addComponent(lblEndereo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textoEscritaEmail, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEnviar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEndereo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(destinoEscritaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAssunto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(assuntoEscritaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textoEscritaEmail, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEnviar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	 public void sendEmail(String from1,String to1, String Subject1, String Text1) throws AddressException, MessagingException {
			

	      // Assuming you are sending email from localhost
//	      String host = "localhost";
	      System.out.println("from who "+from1);
	      System.out.println("to who "+to1);
	      System.out.println("Subject why "+Subject1);
	      System.out.println("Text for what"+Text1);
	     
	     
          /** Parâmetros de conexão com servidor Gmail */
			final String username = from1;
			final String password = pass;
	 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.office365.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.localhost", "127.0.0.1");
	 
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to1));
				message.setSubject(Subject1);
				message.setText(Text1);
	 
				Transport.send(message);
	 
				System.out.println("Email enviado com sucesso!");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	

}

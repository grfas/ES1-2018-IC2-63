package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.restfb.Facebook;
import com.restfb.types.Post;

import Email.EmailReader;
import Email.MessagePrint;
import Facebook.InicializadorFacebook;
import Twitter.TwitterApp;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame {
	private DefaultListModel<String> model = new DefaultListModel<>();
	private DefaultListModel<String> modelEmail = new DefaultListModel<>();
	private DefaultListModel<String> modelFacebook = new DefaultListModel<>();
	private JPanel contentPane1;
	private JButton btnActualizarT;
	private static  TwitterApp twitter;
	JList listaTweets = new JList<>(model);
	JList listaEmails = new JList<>(modelEmail);
	JList listaFacebookposts= new JList<>(modelFacebook);
	String selecao;
	private List<Status> listaEstados;
	private List<String> listaPosts;
	JTextArea areaTweet = new JTextArea();
	JTextArea areaEmail= new JTextArea();
	JTextArea areaFacebook = new JTextArea();
	private JButton btnActualizarF;
	private JButton btnActualizarE;
	private JButton btnAlterarFiltroE;
	private JButton btnAlterarFiltroT;
	private JButton btnEscreverEmail;
	private JButton btnReencaminharMail;
	private JTextField textFieldF;
	private JTextField textFieldE;
	private JTextField txtFiltroT;
	private static EmailReader email ;
	private static InicializadorFacebook facebook;
	private static LoginBox passBox;
	
	/**
	 * Launch the application.
	 * @throws TwitterException 
	 */
	public static void main(String[] args) {

				passBox = new LoginBox(email);
				passBox.correLogin();

		System.out.println("oioi");
		System.out.println("11:18 - 4/12/2018");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					Gui frame = new Gui();
					frame.setVisible(true);
					//					frame.relistTweets();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		twitter= new TwitterApp();
//		String name = JOptionPane.showInputDialog("Introduza o user do email");
//		JPasswordField pwd = new JPasswordField(10);
//		int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_OPTION);
//		if(action < 0)JOptionPane.showMessageDialog(null,"Cancel, X or escape key selected");
		
		facebook= new InicializadorFacebook();
		try {
			
			twitter.initTwitter();
			facebook.IniciaFace();


		} catch (TwitterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}




	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		init();
		events();

	}

	/**
	 * atualização da lista de status/tweets
	 * 
	 */
	private void relistTweets() {

		for(Status s : twitter.getListaTweets()){
			model.addElement(s.getUser().getName()+ " - "+s.getCreatedAt());
			System.out.println(s.getUser().getName()+ " - "+s.getCreatedAt());
		}


	}
	

	/**
	 * atualização da lista emails 
	 */
	private void relistaEmails() {

		for(MessagePrint s : email.getMensagemDoIscte()){
			model.addElement(s.getFrom() + " - "+s.getTitulo());
			System.out.println(s.getFrom() + " - "+s.getTitulo());
		}
		

	}
	
	public void getMail() {
		
	}
	private void relistaFacebookPosts() {
		for(Post p : facebook.getMensagemDoIscte()) {
			modelFacebook.addElement((p.getFrom())+ " - "+p.getCaption());
			System.out.println(p.getFrom() + " - "+p.getCaption());
		}
	}

	private void events() {
		
		
			
		btnActualizarF.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				listaFacebookposts.removeAll();
				facebook.actualizaFace();
				for (Post p : facebook.getMensagemDoIscte()) {
					modelFacebook.addElement(p.getId()+ " - "+p.getMessage());
					
					
//					modelFacebook.addElement(p.getFrom().getName()+ " - "+p.getCaption());
				}
				
				areaFacebook.setText(null);
				
			}
			
		});
		
		

		btnActualizarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaTweets.removeAll();
				try {
					twitter.actualizaTwitter();
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Status s : twitter.getListaTweets()){
					model.addElement(s.getUser().getName()+ " - "+s.getCreatedAt());
					
				}

//				listaTweets = new JList<>(model);

				System.out.println("button clicked!");

				areaTweet.setText(null);
				//				relistTweets();


			}
		});

		btnActualizarE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelEmail.clear();
				email=passBox.getMail();
				System.out.println("lista email"+ email.getMensagemDoIscte());

				for(MessagePrint s : email.getMensagemDoIscte()){
					modelEmail.addElement(s.getFrom() + " - "+s.getTitulo());

					System.out.println(s.getFrom() + " - "+s.getTitulo());
				}



				System.out.println("button email clicked!");

				areaEmail.setText(null);
				//				relistTweets();


			}
		});
		btnAlterarFiltroE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				email.setFiltroEmail(textFieldE.getText());
				email.readEmails(true);
				System.out.println("filtro"+ email.getFiltroEmail());

				System.out.println("button filtro email clicked!");


			}
		});
		
		btnAlterarFiltroT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				twitter.setFiltro(txtFiltroT.getText());
				
				System.out.println("filtro"+ twitter.getFiltro());

				System.out.println("button filtro twitter clicked!");


			}
		});
		
		btnEscreverEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmailWrite escritaEmail = new EmailWrite();
				
				escritaEmail.setVisible(true);

			}
		});
		
		btnReencaminharMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmailWrite escritaEmail = new EmailWrite();
				
				escritaEmail.setVisible(true);

			}
		});


		listaFacebookposts.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				areaFacebook.setText(null);
				String selectedValue = (String) listaFacebookposts.getSelectedValue();
				System.out.println("lolo" + listaFacebookposts.getSelectedValue());
				for(Post p : facebook.getMensagemDoIscte()) {
					if(selectedValue.equals(p.getId()+ " - "+p.getMessage())){
						
						areaFacebook.setText(p.getMessage()); 	
					}
				}



			}
		});
		
		listaTweets.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				areaTweet.setText(null);
				String selectedValue = (String) listaTweets.getSelectedValue();
				System.out.println("l " + listaTweets.getSelectedValue());
				for(Status s : twitter.getListaTweets()) {
					if(selectedValue.equals(s.getUser().getName()+ " - "+s.getCreatedAt())){
						
						areaTweet.setText(s.getText()); 	
					}
				}



			}
		});

		listaEmails.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				areaEmail.setText(null);
				String selectedValue = (String) listaEmails.getSelectedValue();
				System.out.println(selectedValue);
				for(MessagePrint mp : email.getMensagemDoIscte()){
					if(selectedValue.equals(mp.getFrom()+ " - "+mp.getTitulo())){
						
						areaEmail.setText(mp.getTexto()); 	
					}
				}



			}
		});
	}


	private void actualizarTweets() {
		this.listaEstados.clear();
		this.listaEstados=twitter.getListaTweets();
	}



	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 390);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane1 = new GroupLayout(contentPane1);
		gl_contentPane1.setHorizontalGroup(
				gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
						.addGap(1)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
				);
		gl_contentPane1.setVerticalGroup(
				gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
						.addGap(5)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
				);

		JPanel panelEmail = new JPanel();
		tabbedPane.addTab("Email", null, panelEmail, null);

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPaneE = new JScrollPane();

		btnActualizarE = new JButton("Actualizar");

		textFieldE = new JTextField();
		textFieldE.setColumns(10);

		btnAlterarFiltroE = new JButton("Alterar Filtro");
		
		btnEscreverEmail = new JButton("Enviar email");
		
		btnReencaminharMail = new JButton("Reencaminhar");
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(
			gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEmail.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPaneE, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAlterarFiltroE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReencaminharMail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEscreverEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnActualizarE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panelEmail.setVerticalGroup(
			gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneE, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addGroup(gl_panelEmail.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnActualizarE)
					.addGap(28)
					.addComponent(textFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterarFiltroE)
					.addGap(45)
					.addComponent(btnEscreverEmail)
					.addGap(18)
					.addComponent(btnReencaminharMail)
					.addContainerGap(88, Short.MAX_VALUE))
		);


		scrollPaneE.setRowHeaderView(listaEmails);

		
		scrollPane.setViewportView(areaEmail);
		panelEmail.setLayout(gl_panelEmail);

		JPanel panelFacebook = new JPanel();
		tabbedPane.addTab("Facebook", null, panelFacebook, null);

		JScrollPane scrollPane_2 = new JScrollPane();

		JScrollPane scrollPane_3 = new JScrollPane();

		btnActualizarF = new JButton("Actualizar");

		textFieldF = new JTextField();
		textFieldF.setColumns(10);

		JButton btnAlterarFiltroF = new JButton("Alterar Filtro");
		GroupLayout gl_panelFacebook = new GroupLayout(panelFacebook);
		gl_panelFacebook.setHorizontalGroup(
				gl_panelFacebook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFacebook.createSequentialGroup()
						.addGap(1)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGap(2)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelFacebook.createParallelGroup(Alignment.LEADING)
								.addComponent(btnActualizarF)
								.addComponent(textFieldF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAlterarFiltroF))
						.addContainerGap(32, Short.MAX_VALUE))
				);
		gl_panelFacebook.setVerticalGroup(
				gl_panelFacebook.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addGroup(gl_panelFacebook.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnActualizarF)
						.addGap(18)
						.addComponent(textFieldF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAlterarFiltroF)
						.addContainerGap(202, Short.MAX_VALUE))
				);

		
		scrollPane_3.setViewportView(areaFacebook);


		scrollPane_2.setViewportView(listaFacebookposts);
		panelFacebook.setLayout(gl_panelFacebook);

		JPanel panelTwitter = new JPanel();
		tabbedPane.addTab("Twitter", null, panelTwitter, null);

		JScrollPane scrollPane_4 = new JScrollPane();

		JScrollPane scrollPane_5 = new JScrollPane();

		btnActualizarT = new JButton("Actualizar");

		txtFiltroT = new JTextField();
		txtFiltroT.setText("Filtro");
		txtFiltroT.setColumns(10);

		btnAlterarFiltroT = new JButton("Alterar Filtro");
		/* 
		 * Painel do Twitter
		 */
		
		JButton btnRetweetar = new JButton("Retweetar");
		GroupLayout gl_panelTwitter = new GroupLayout(panelTwitter);
		gl_panelTwitter.setHorizontalGroup(
			gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelTwitter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAlterarFiltroT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtFiltroT)
						.addComponent(btnActualizarT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRetweetar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_panelTwitter.setVerticalGroup(
			gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnActualizarT)
					.addGap(33)
					.addComponent(txtFiltroT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterarFiltroT)
					.addGap(40)
					.addComponent(btnRetweetar)
					.addContainerGap(129, Short.MAX_VALUE))
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
		);


		
		scrollPaneE.setViewportView(listaEmails);

		scrollPane_5.setViewportView(areaTweet);
		scrollPane_4.setViewportView(listaTweets);
		panelTwitter.setLayout(gl_panelTwitter);
		contentPane1.setLayout(gl_contentPane1);
	}
}

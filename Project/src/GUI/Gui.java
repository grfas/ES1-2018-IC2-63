package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Email.EmailReader;
import Email.MessagePrint;
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
	private JPanel contentPane1;
	private JButton btnActualizarT;
	private static TwitterApp twitter;
	JList listaTweets = new JList(model);
	JList listaEmails = new JList<>(modelEmail);
	String selecao;
	private List<Status> listaEstados;
	JTextArea areaTweet = new JTextArea();
	JTextArea areaEmail= new JTextArea();
	private JButton btnActualizarF;
	private JButton btnActualizarE;
	private JButton btnAlterarFiltroE;
	private JTextField textFieldF;
	private JTextField textFieldE;
	private static EmailReader email ;

	/**
	 * Launch the application.
	 * @throws TwitterException 
	 */
	public static void main(String[] args) {



		System.out.println("oioi");
		System.out.println("14:39 - 20/11//2018");

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
		String name = JOptionPane.showInputDialog("Introduza o user do email");
		String pass = JOptionPane.showInputDialog("Introduza a PASS do user");
		email= new EmailReader(name,pass);
		try {
			email.readEmails(true);
			twitter.initTwitter();


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

	private void events() {

		btnActualizarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				model.clear();
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
				System.out.println("lista email"+ email.getMensagemDoIscte());

				for(MessagePrint s : email.getMensagemDoIscte()){
					modelEmail.addElement(s.getFrom() + " - "+s.getTitulo());

					System.out.println(s.getFrom() + " - "+s.getTitulo());
				}



				System.out.println("button email clicked!");

				areaTweet.setText(null);
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

//		listaTweets.addMouseListener(new MouseAdapter() {
//			  public void mouseClicked(MouseEvent evt) {
//			   if (evt.getClickCount() == 1) {
//			    int index = listaTweets.locationToIndex(evt.getPoint());
//			    for(int i=0; i<model.size(); i++) {
//			    	if(i==index) {
//			    		if(selectedValue.equals(s.getUser().getName()+ " - "+s.getCreatedAt())){
//							areaTweet.setText(null);
//							areaTweet.setText(s.getText()); 	
//						}
//			    	}
//			    }
////			    twitter.imprimeIndex(index);
////			    indiceTwitter = index;
//			   }
//			  }
//			 });


		
		listaTweets.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				areaTweet.setText(null);
				String selectedValue = (String) listaTweets.getSelectedValue();
				System.out.println("lolo" + listaTweets.getSelectedValue());
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
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(
				gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEmail.createSequentialGroup()
						.addGap(1)
						.addComponent(scrollPaneE, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
								.addComponent(btnActualizarE)
								.addComponent(textFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAlterarFiltroE))
						.addContainerGap(40, Short.MAX_VALUE))
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
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAlterarFiltroE)
						.addContainerGap(192, Short.MAX_VALUE))
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

		JTextArea areaPosts = new JTextArea();
		scrollPane_3.setViewportView(areaPosts);

		JList listaPosts = new JList();
		scrollPane_2.setViewportView(listaPosts);
		panelFacebook.setLayout(gl_panelFacebook);

		JPanel panelTwitter = new JPanel();
		tabbedPane.addTab("Twitter", null, panelTwitter, null);

		JScrollPane scrollPane_4 = new JScrollPane();

		JScrollPane scrollPane_5 = new JScrollPane();

		btnActualizarT = new JButton("Actualizar");

		JTextField txtFiltroT = new JTextField();
		txtFiltroT.setText("Filtro");
		txtFiltroT.setColumns(10);

		JButton btnAlterarFiltroT = new JButton("Alterar Filtro");

		GroupLayout gl_panelTwitter = new GroupLayout(panelTwitter);
		gl_panelTwitter.setHorizontalGroup(
				gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTwitter.createParallelGroup(Alignment.LEADING)
								.addComponent(btnActualizarT, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFiltroT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAlterarFiltroT))
						.addContainerGap(44, Short.MAX_VALUE))
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
						.addContainerGap(192, Short.MAX_VALUE))
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

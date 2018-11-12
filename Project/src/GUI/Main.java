package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Twitter.TwitterApp;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JPanel contentPane1;
	private JButton btnActualizar;
	private static TwitterApp twitter;
	JList listaTweets = new JList(model);
	String selecao;
	private List<Status> listaEstados;
	JTextArea areaTweet = new JTextArea();
	
	/**
	 * Launch the application.
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		System.out.println("ola");
	
		twitter= new TwitterApp();
		twitter.initTwitter();
		for(Status si: twitter.getListaTweets())
		{
			System.out.println(si.getUser().getName()+" -- "+si.getText());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main frame = new Main();
					frame.setVisible(true);
					frame.relistTweets();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		init();
		events();
		
	}
	
	private void relistTweets() {

		for(Status s : TwitterApp.getListaTwitts()){
			model.addElement(s.getUser().getName()+ " - "+s.getCreatedAt());
			System.out.println(s.getUser().getName()+ " - "+s.getCreatedAt());
		}
		
		
	}

	private void events() {
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				model.clear();
				for(Status s : twitter.getListaTweets()){
					model.addElement(s.getUser().getName()+ " - "+s.getCreatedAt());
					
				}

				System.out.println("button clicked!");
//				model.clear();
				areaTweet.setText(null);
				relistTweets();
				

			}
		});
		
		listaTweets.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				String selectedValue = (String) listaTweets.getSelectedValue();
				System.out.println(selectedValue);
				for(Status s : TwitterApp.getListaTwitts()) {
					if(selectedValue.equals(s.getUser().getName()+ " - "+s.getCreatedAt())){
						areaTweet.setText(null);
						areaTweet.setText(s.getText()); 	
					}
				}
				
				
				
			}
		});
	}
	
//	private void actualizarTweets() {
//		this.listaEstados.clear();
//		this.listaEstados=TwitterApp.getListaTwitts();
//	}

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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(
			gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEmail.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_panelEmail.setVerticalGroup(
			gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
		);
		
		JList listaEmails = new JList<>();
		scrollPane_1.setRowHeaderView(listaEmails);
		
		JTextArea areaEmails = new JTextArea();
		scrollPane.setViewportView(areaEmails);
		panelEmail.setLayout(gl_panelEmail);
		
		JPanel panelFacebook = new JPanel();
		tabbedPane.addTab("Facebook", null, panelFacebook, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panelFacebook = new GroupLayout(panelFacebook);
		gl_panelFacebook.setHorizontalGroup(
			gl_panelFacebook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFacebook.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		gl_panelFacebook.setVerticalGroup(
			gl_panelFacebook.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
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
		
		btnActualizar = new JButton("Actualizar");
		
		GroupLayout gl_panelTwitter = new GroupLayout(panelTwitter);
		gl_panelTwitter.setHorizontalGroup(
			gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panelTwitter.setVerticalGroup(
			gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnActualizar)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
		);
		
		
		scrollPane_5.setViewportView(areaTweet);
		
		
		scrollPane_4.setViewportView(listaTweets);
		panelTwitter.setLayout(gl_panelTwitter);
		contentPane1.setLayout(gl_contentPane1);
	}
}

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
	JList list_2 = new JList(model);
	String selecao;
	JTextArea textArea_2 = new JTextArea();
	
	/**
	 * Launch the application.
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		
		twitter= new TwitterApp();
		twitter.initTwitter();
		for(Status si: twitter.getListaTwitts())
		{
			System.out.println(si.getUser().getName()+" -- "+si.getText());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main frame = new Main();
					frame.setVisible(true);
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

	private void events() {
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				for(Status s : twitter.getListaTwitts()){
					model.addElement(s.getUser().getName()+ " - "+s.getCreatedAt());
					
				}
			}
		});
		
		list_2.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String selectedValue = (String) list_2.getSelectedValue();
				
				textArea_2.setText(selecao); 
				
				
			}
		});
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 364);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane1 = new GroupLayout(contentPane1);
		gl_contentPane1.setHorizontalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addGap(1)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane1.setVerticalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addGap(5)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_panelEmail.setVerticalGroup(
			gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEmail.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JList list = new JList<>();
		scrollPane_1.setRowHeaderView(list);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
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
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panelFacebook.setVerticalGroup(
			gl_panelFacebook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFacebook.createSequentialGroup()
					.addGroup(gl_panelFacebook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFacebook.createSequentialGroup()
							.addGap(1)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelFacebook.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		
		JList list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
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
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panelTwitter.setVerticalGroup(
			gl_panelTwitter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTwitter.createSequentialGroup()
					.addGroup(gl_panelTwitter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTwitter.createSequentialGroup()
							.addGap(1)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelTwitter.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelTwitter.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnActualizar)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_5.setViewportView(textArea_2);
		
		
		scrollPane_4.setViewportView(list_2);
		panelTwitter.setLayout(gl_panelTwitter);
		contentPane1.setLayout(gl_contentPane1);
	}
}

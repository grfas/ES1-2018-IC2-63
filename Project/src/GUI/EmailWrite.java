package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.restfb.types.Post;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class EmailWrite extends JFrame {

	private JPanel contentPane;
	private JButton btnEnviar;
	/**
	 * Launch the application.
	 */
	public EmailWrite() {
		
		
		init();
		events();
	}
	
	private void events() {
		
		
		
		btnEnviar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
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
		
		JTextField destinoEscritaEmail = new JTextField();
		destinoEscritaEmail.setColumns(10);
		
		JTextField assuntoEscritaEmail = new JTextField();
		assuntoEscritaEmail.setColumns(10);
		
		JTextField textoEscritaEmail = new JTextField();
		textoEscritaEmail.setColumns(10);
		
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
}

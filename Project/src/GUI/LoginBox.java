package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Email.EmailReader;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

	/**
	 * 
	 * @author Gon�alo Ferreira e Jo�o Est�v�o
	 * Classe para a caixa de login da GUI
	 *
	 */
public class LoginBox extends JFrame {

	private String passwordInput;
	private String emailInput;
	private JPanel contentPane;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private JTextField emailLog;
	
	private Gui gui;

	public LoginBox(Gui gui) {
		this.gui = gui;
		init();
		events();
	}

	/**
	 * correLogin,
	 * inicia a aplica��o.
	 */
	public void correLogin() {
		LoginBox frame = new LoginBox(gui);
		frame.setVisible(true);
	}

	/**
	 * init,
	 * cria a moldura.
	 */
	public void init() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		emailLog = new JTextField();
		emailLog.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 11));

		passwordField = new JPasswordField();

		JLabel lblNewLabel = new JLabel("Introduza o email ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));

		JLabel lblNewLabel_1 = new JLabel("Introduza a password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(49)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addGap(26).addComponent(btnLogin).addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1)
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(emailLog, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
										.addGap(46))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(16).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(emailLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(24).addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnLogin)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(28, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * events,
	 * procedimento que associa os eventos da aplica��o a cada ac��o 
	 */
	private void events() {

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String stringValueOfCharArray = String.valueOf(passwordField.getPassword());
				setLoginInput(emailLog.getText());
				setLoginInput();
				
				setPassInput(stringValueOfCharArray);
				
				setPassInput();
				gui.readMails(getLoginInput(), getPassInput());
				dispose();
			}
		});
	}

	/**
	 * getLoginInput
	 * Getter que devolve o e-mail de login
	 *@return emailInput
	 */
	public String getLoginInput() {
		return emailInput;
	}
	/**
	 * setLoginInput,
	 * Setter para o LoginInput
	 * @param emailInput, e-mail com o qual pretendemos iniciar sess�o.
	 */
	public void setLoginInput() {
		gui.setLogUser(getLoginInput());
	}
	
	/**
	 * setPassInput,
	 * Setter para o PassInput
	 * @param passwordInput, palavra-passe com a qual pretendemos iniciar sess�o.
	 */
	public void setPassInput() {
		gui.setLogPass(getPassInput());
	}

	/**
	 * getLoginInput
	 * Getter que devolve o passeInput
	 *@return passwordInput, palavra-passe que usamos 
	 */
	public String getPassInput() {
		return passwordInput;
	}

	/**
	 * setLoginInput,
	 * Setter para o LoginInput
	 * @param emailInput, e-mail com o qual pretendemos iniciar sess�o.
	 */
	public void setLoginInput(String input) {
		this.emailInput = input;
	}
	/**
	 * setPassInput,
	 * Setter para o PassInput
	 * @param passwordInput, palavra-passe com a qual pretendemos iniciar sess�o.
	 */
	public void setPassInput(String input) {
		this.passwordInput = input;
	}

}

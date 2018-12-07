package Email;

import javax.mail.Address;
/**
 * @author Gon�alo Ferreira
 * Classe MessagePrint, para o objeto que comp�e o conte�do das mensagens
 */

public class MessagePrint {
	
	private Address from;
	private String titulo;
	private String texto;
	
	
	/**Construtor do objecto MessagePrint,
	 * inicializa��o from, titulo, texto
	 * @param from, este � o endere�o do remetente
	 * @param titulo, este � o assunto do e-mail
	 * @param texto, corpo da mensagem 
	 */
	public MessagePrint(Address from,String titulo, String texto) {
		this.from=from;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	/**
	 * getTitulo,
	 * Getter que devolve o titulo (assunto) da mensagem.
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * setTitulo,
	 * Setter para o titulo.
	 * @param titulo, � o titulo que queremos definir para a mensagem. 
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * getTexto,
	 * Getter que devolve o texto da mensagem (conte�do do e-mail).
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * setTexto,
	 * Setter para o texto do email
	 * @param texto, � o texto que queremos apresentar na mensagem.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * getFrom,
	 * Getter que devolve o remetente da mensagem (from).
	 * @return from
	 */
	public Address getFrom() {
		return from;
	}

	/**
	 * setFrom,
	 * Setter para o endere�o de email remetente
	 * @param from, � o remetente do e-mail.
	 */
	public void setFrom(Address from) {
		this.from = from;
	}
	
	
	
	
}

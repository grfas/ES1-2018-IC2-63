package Email;

import javax.mail.Address;
/**
 * @author Gonçalo Ferreira
 * Classe MessagePrint, para o objeto que compõe o conteúdo das mensagens
 */

public class MessagePrint {
	
	private Address from;
	private String titulo;
	private String texto;
	
	
	/**Construtor do objecto MessagePrint,
	 * inicialização from, titulo, texto
	 * @param from, este é o endereço do remetente
	 * @param titulo, este é o assunto do e-mail
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
	 * @param titulo, é o titulo que queremos definir para a mensagem. 
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * getTexto,
	 * Getter que devolve o texto da mensagem (conteúdo do e-mail).
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * setTexto,
	 * Setter para o texto do email
	 * @param texto, é o texto que queremos apresentar na mensagem.
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
	 * Setter para o endereço de email remetente
	 * @param from, é o remetente do e-mail.
	 */
	public void setFrom(Address from) {
		this.from = from;
	}
	
	
	
	
}

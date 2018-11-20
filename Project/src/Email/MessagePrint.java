package Email;

import javax.mail.Address;

public class MessagePrint {
	
	private Address from;
	private String titulo;
	private String texto;
	
	public MessagePrint(Address from,String titulo, String texto) {
		this.from=from;
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}
	
	
	
	
}

package Email;

public class MessagePrint {
	
	private String from;
	private String titulo;
	private String texto;
	
	public MessagePrint(String from,String titulo, String texto) {
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
	
	
}

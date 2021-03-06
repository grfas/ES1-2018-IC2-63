package Facebook;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import com.restfb.types.Post;

import Email.MessagePrint;

import com.restfb.Parameter;
import com.restfb.Version;

import Facebook.Constantes;
import Facebook.CustomUser;
import xmltry.Offline;
	/**
	 * 
	 * @author Francisco Bruno
	 *
	 */
public class InicializadorFacebook {
	public List<Post> mensagemDoIscte = new ArrayList<Post>();
	

	private Connection<Post> myFeed;
	private FacebookClient facebookClient;
	/**
	 * IniciaFace, 
	 * inicia a conex�o com a api do facebook, atrav�s do token de acesso
	 */
	public void IniciaFace() {
		facebookClient = new DefaultFacebookClient(Constantes.MY_ACCESS_TOKEN, Version.LATEST);

		CustomUser user = facebookClient.fetchObject("Me", CustomUser.class,
				Parameter.with("fields", "id, name, email, first_name, last_name,hometown"));

		System.out.println("First Name= " + user.getFirstName());
		System.out.println("Last Name= " + user.getLastName());
		System.out.println("Full Name= " + user.getFullName());
		System.out.println("Email= " + user.getEmail());
		
		actualizaFace();
	}
	
	/**
	 * actualizaFace,
	 * atualiza o facebook
	 */
	public void actualizaFace() {
		myFeed = facebookClient.fetchConnection("me/feed", Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : myFeed) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && aPost.getMessage().contains("Direito")) {
					System.out.println("---- Post " + counter5 + " ----");
					System.out.println("Id: " + "fb.com/" + aPost.getId());
					System.out.println("Message: " + aPost.getMessage());
					//System.out.println("Created: " + aPost.getCreatedTime());
					mensagemDoIscte.add(aPost);
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nN� of Results: " + counter5 + "/" + counterTotal);
			System.out.println(mensagemDoIscte.size());
			
			

	}
	/**
	 * getMensagemDoIscte,
	 * Getter que devolve uma Lista de Posts com conte�do do ISCTE.
	 * @return MensagemDoIscte 
	 */
	public List<Post> getMensagemDoIscte() {
		return mensagemDoIscte;
	}
	
	/**
	 * setMensagemDoIscte,
	 * Setter que define uma Lista de Posts com conte�do do ISCTE.
	 * @param mensagemDoIscte 
	 */
	public void setMensagemDoIscte(List<Post> mensagemDoIscte) {
		this.mensagemDoIscte = mensagemDoIscte;
	}

}


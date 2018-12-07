package Facebook;


import java.util.Date;

import com.restfb.Facebook;
import com.restfb.types.Post;



/**
 * @author Francisco
 *Class customizavel para utilizadores do Facebook
 */
public class CustomUser {
	
	@Facebook("post")
	private Post post;
	
	@Facebook("first_name")
	private String firstName;

	@Facebook("last_name")
	private String lastName;

	@Facebook("name")
	private String fullName;

	@Facebook("email")
	private String email;

	@Facebook("birthday")
	private Date birthday;


	/**
	 * getFirstName,
	 * Getter que devolve o primeiro nome do utilizador.
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getLastName,
	 * Getter que devolve o último nome do utilizador.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setLastName,
	 * Setter para definir o último nome do utilizador
	 * @param fullName, é o último nome do utilizador.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * getFullName,
	 * Getter que devolve o nome completo do utilizador.
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * setFullName,
	 * Setter para definir o nome completo do utilizador
	 * @param fullName, é o nome completo do utilizador.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * getEmail,
	 * Getter que devolve o e-mail do utilizador.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setEmail,
	 * Setter para definir o e-mail do utilizador
	 * @param email, é o e-mail utilizador.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * getBirthday,
	 * Getter que devolve a data de nascimento do utilizador.
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;

	}
	
	/**
	 * setBirthday,
	 * Setter para definir a data de nascimento do utilizador
	 * @param birthday, data de nascimento do utilizador.
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * getPost,
	 * Getter que devolve uma publicação.
	 * @return post
	 */
	public Post getPost() {
		
		return post;
	}
}
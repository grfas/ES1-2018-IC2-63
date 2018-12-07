package Facebook;


import com.restfb.Facebook;

/**
 * @author Francisco Bruno 
 *Classe customizavel de uma página de Facebook
 */
public class CustomPage {

	@Facebook("first_name")
	private String firstName;

	@Facebook("name")
	private String fullName;

	@Facebook
	private String email;

	@Facebook
	private String hometown;

	@Facebook
	private String fan_count;

	/**
	 * getFullName,
	 * Getter que devolve o nome completo da página.
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * setFullName,
	 * Setter para definir o nome completo da página
	 * @param fullName, é o nome completo da página.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * getEmail,
	 * Getter que devolve o e-mail da página.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail,
	 * Setter para definir o e-mail da página
	 * @param email, é o e-mail da página.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getFanCount,
	 * Getter que devolve o fan count.
	 * @return fan_count
	 */
	public String getFanCount() {
		return fan_count;
	}

	/**
	 * setFanCount,
	 * Setter para definir o fan count
	 * @param fan_count.
	 */
	public void setFanCount(String fan_count) {
		this.fan_count = fan_count;
	}

}

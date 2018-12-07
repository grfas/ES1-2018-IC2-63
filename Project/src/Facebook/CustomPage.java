package Facebook;


import com.restfb.Facebook;

/**
 * @author Francisco Bruno 
 *Classe customizavel de uma p�gina de Facebook
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
	 * Getter que devolve o nome completo da p�gina.
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * setFullName,
	 * Setter para definir o nome completo da p�gina
	 * @param fullName, � o nome completo da p�gina.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * getEmail,
	 * Getter que devolve o e-mail da p�gina.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail,
	 * Setter para definir o e-mail da p�gina
	 * @param email, � o e-mail da p�gina.
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

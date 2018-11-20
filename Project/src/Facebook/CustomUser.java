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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;

	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Post getPost() {
		
		return post;
	}
}
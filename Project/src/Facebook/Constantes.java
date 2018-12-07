package Facebook;


/**
 * @author Francisco Bruno
 * Classe com os valores utilizados pela api do facebook
 *
 */
public class Constantes {
 
	/**
	 * getRedirectUri,
	 * Getter que redirect_uri.
	 * @return REDIRECT_URI
	 */
   public static String getRedirectUri() {
		return REDIRECT_URI;
	}

	/**
	 * getMyAccessToken,
	 * Getter que devolve o token de acesso (my_access_token).
	 * @return MY_ACCESS_TOKEN
	 */
	public static String getMyAccessToken() {
		return MY_ACCESS_TOKEN;
	}


public static final String REDIRECT_URI
                 = "http://localhost:8080/facebookfriends/FriendsListServlet";
 
   
   /**
    * Access token dado pelo facebook, na GRAPH API
    * 
    */
public static final String MY_ACCESS_TOKEN = "EAAKXRQavMcIBAN46mZA6JVcaH0W5tUV9Wz3I4LN39AFw4TDwv8nu8wZCeK68J9Vq5HKcvGJfWZA2Q2p3ZCw2d7mxcmfpiKmcfb9Q4lFa3fm2V7Rcieoh6dH2c3uvl8ZCuhe0MI2uQAYCEj1ID2livEUuZCo9hsAGs7xwoHjlOcOxCEpVnJouKH";
 
  
 
}
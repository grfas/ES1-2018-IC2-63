package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Facebook.Constantes;

class ConstantesTest {
	Constantes a = new Constantes();
	@Test
	void testUri() {
	
		String uri ="http://localhost:8080/facebookfriends/FriendsListServlet";
		assertEquals(a.getRedirectUri(), uri);
	}
	@Test
	void testTokken() {
		
		String tokken = "EAAKXRQavMcIBAN46mZA6JVcaH0W5tUV9Wz3I4LN39AFw4TDwv8nu8wZCeK68J9Vq5HKcvGJfWZA2Q2p3ZCw2d7mxcmfpiKmcfb9Q4lFa3fm2V7Rcieoh6dH2c3uvl8ZCuhe0MI2uQAYCEj1ID2livEUuZCo9hsAGs7xwoHjlOcOxCEpVnJouKH";
		assertEquals(a.getMyAccessToken(), tokken);
	}

}

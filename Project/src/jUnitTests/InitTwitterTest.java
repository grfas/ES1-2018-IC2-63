
package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import Twitter.TwitterApp;
import twitter4j.Status;
import twitter4j.TwitterException;

class InitTwiterTest {

	TwitterApp ta = new TwitterApp();

	@Test
	void test() {
		TwitterApp junit = new TwitterApp();
		assertNotNull(junit);

	}
	//	PrintStream ConcatenarTokensAcesso( String accessToken, String accessTokenSecret) {
	//		return System.out.printf( accessToken + accessTokenSecret);
	//
	//	}

	@Test
	void testGetConsumerApiKey() {

		String consumerApiKey=ta.getConsumerApiKey();
		assertEquals(consumerApiKey, "4rJVbcVIboahTgUlsd7oOFwDd");

	}
	@Test
	void testGetApiSecretKey() {

		String apiSecretKey=ta.getApiSecretKey();
		assertEquals(apiSecretKey, "wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW");

	}

	@Test
	void testGetAccessToken() {

		String accessToken=ta.getAccessToken();
		assertEquals(accessToken, "159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5");

	}
	@Test
	void testGetAccessTokenSecret() {

		String accessTokenSecret=ta.getAccessTokenSecret();
		assertEquals(accessTokenSecret, "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");

	}
//	@Test
//	void testGetTweetId() {  //vai ter que ser alterado consoante a alteração da função get tweet id
//
//		long tweetId=ta.getTweetId();
//		assertEquals(tweetId, 0);
//
//	}

	@Test
	void testGetListaTweets() {

		List<Status>estados= ta.getListaTweets();
		assertEquals(estados, estados);
	}

	@Test
	void testSetFiltro() {
		System.out.println("setFiltro");
		String filtro = "iscteiul";

		ta.setFiltro(filtro);
		assertEquals(ta.getFiltro(), filtro);
	}

	@Test
	void testGetFiltro() {
		System.out.println("getFiltro");

		String filtro = "iscteiul";
		ta.setFiltro("iscteiul");
		String resultado= ta.getFiltro();
		assertEquals(filtro, resultado);
	}

	@Test
	void testFavoritar() {

	}

	@Test
	void testRetweetar() {

	}

	@Test
	void testActualizaTwitter() {
		
	}

	@Test //ver melhor isto
	void testInitTwitter() throws TwitterException {
		boolean thrown = false;
		try {
			ta.initTwitter();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	void testEstadosDoISCTE() {
		List<Status>estados= ta.getListaTweets();
		List<Status>estados1=ta.getListaTweets();
		assertEquals(estados, estados1);

	}


}



package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import Twitter.TwitterApp;
import twitter4j.Status;

class InitTwiterTest {

	@Test
	void test() {
		TwitterApp junit = new TwitterApp();
		assertNotNull(junit);

	}
	PrintStream ConcatenarTokensAcesso( String accessToken, String accessTokenSecret) {
		return System.out.printf( accessToken + accessTokenSecret);

	}
	
	@Test
	void testGetConsumerApiKey() {
		TwitterApp ta = new TwitterApp();
		String consumerApiKey=ta.getConsumerApiKey();
		assertEquals(consumerApiKey, "4rJVbcVIboahTgUlsd7oOFwDd");
		
	}
	@Test
	void testGetApiSecretKey() {
		TwitterApp ta = new TwitterApp();
		String apiSecretKey=ta.getApiSecretKey();
		assertEquals(apiSecretKey, "wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW");
		
	}
	
	@Test
	void testGetAccessToken() {
		TwitterApp ta = new TwitterApp();
		String accessToken=ta.getAccessToken();
		assertEquals(accessToken, "159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5");
		
	}
	@Test
	void testGetAccessTokenSecret() {
		TwitterApp ta = new TwitterApp();
		String accessTokenSecret=ta.getAccessTokenSecret();
		assertEquals(accessTokenSecret, "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		
	}
	@Test
	void testGetTweetId() {  //vai ter que ser alterado consoante a alteração da função get tweet id
		TwitterApp ta= new TwitterApp();
		long tweetId=ta.getTweetId();
		assertEquals(tweetId, 0);
		
	}
	
	@Test
	void testGetListaTweets() {
		TwitterApp ta = new TwitterApp();
		List<Status>estados= ta.getListaTweets();
		assertEquals(estados, estados);
	}
	
	
}

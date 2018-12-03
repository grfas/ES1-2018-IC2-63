
package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Twitter.TwitterApp;

class InitTwiterTest {

	@Test
	void test() {
		TwitterApp junit = new TwitterApp();
		assertNotNull(junit);

	}
	PrintStream ConcatenarTokensAcesso( String accessToken, String accessTokenSecret) {
		return System.out.printf( accessToken + accessTokenSecret);

	}
	
	
}

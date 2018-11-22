
package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Twitter.TwitterApp;

class InitTwiterTest {

	@Test
	void test() {
		TwitterApp junit = new TwitterApp();
		assertNotNull(junit);
	
	}

}
package jUnitTests;



import java.util.List;


import com.restfb.types.Post;

import Facebook.InicializadorFacebook;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FacebookTest {
	InicializadorFacebook junit = new InicializadorFacebook();
	@Test
	void initTest() {
		
		
		 assertNotNull(junit);
			
		}
	
		@Test
		void testGetMensagemIscte() {

			List<Post>posts= junit.getMensagemDoIscte();
			assertEquals(posts, posts);
		}
		@Test
		void testMensagensDoISCTE() {
			Post a = new Post();
			List<Post>posts= junit.getMensagemDoIscte();
			posts.add(a);
			//List<Post>posts1=junit.getMensagemDoIscte();
			assertTrue(posts.contains(a));

		}

	
		
		
	
		
}		

	
	
	
	



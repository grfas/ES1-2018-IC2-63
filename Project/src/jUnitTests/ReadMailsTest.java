package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Email.EmailReader;

class ReadMailsTest {

	
	
		@Test
		void test() {
			EmailReader junit= new EmailReader(null, null);
			 assertNotNull(junit);
			
		}
	

}



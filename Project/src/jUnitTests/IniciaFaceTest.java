package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Facebook.InicializadorFacebook;



class IniciaFaceTest {

	@Test
	void test() {
		InicializadorFacebook junit = new InicializadorFacebook();
		
	 assertNotNull(junit);
		
	}

}
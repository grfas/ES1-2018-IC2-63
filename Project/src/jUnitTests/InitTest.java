package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.Gui;

class InitTest {

	@Test
	void test() {
		Gui junit = new Gui();
		assertNotNull(junit);	}

}

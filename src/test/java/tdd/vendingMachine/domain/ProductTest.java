package tdd.vendingMachine.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void justSimpleValueTest() {
		assertTrue(Product.CHOCOLATE_BAR.getPrice() == 350 );
		assertTrue(Product.COLA_DRINK_025.getPrice() == 220 );
		assertTrue(Product.MINERAL_WATER_033.getPrice() == 140 );
	}

}

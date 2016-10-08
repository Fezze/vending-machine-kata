package tdd.vendingMachine.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CoinTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void justSimpleValueTest() {
		assertTrue(Coin.COIN_10G.getValue() == 10 );
		assertTrue(Coin.COIN_20G.getValue() == 20 );
		assertTrue(Coin.COIN_50G.getValue() == 50 );
		assertTrue(Coin.COIN_1ZL.getValue() == 100 );
		assertTrue(Coin.COIN_2ZL.getValue() == 200 );
		assertTrue(Coin.COIN_5ZL.getValue() == 500 );
	}

}

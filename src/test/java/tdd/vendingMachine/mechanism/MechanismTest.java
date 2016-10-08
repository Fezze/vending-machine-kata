package tdd.vendingMachine.mechanism;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tdd.vendingMachine.domain.Coin;

public class MechanismTest {

protected Mechanism mechanism;
	
	@Before
	public void setUp() throws Exception {
		this.mechanism = new BasicMechanism();
	}

	@Test
	public void ifThereIsManyMoney() {
		
		assertFalse( mechanism.isEnoughCoins( this.initBigCashbox() , 100 ).isEmpty());
		assertFalse( mechanism.isEnoughCoins( this.initBigCashbox() , 5000 ).isEmpty());
		assertFalse( mechanism.isEnoughCoins( this.initBigCashbox() , 8800 ).isEmpty());
		assertTrue( mechanism.isEnoughCoins( this.initBigCashbox() , 9000 ).isEmpty());
		assertTrue( mechanism.isEnoughCoins( this.initBigCashbox() , 1 ).isEmpty());
	}
	
	@Test
	public void ifThereIsSmallMoney() {
		
		assertTrue( mechanism.isEnoughCoins( this.initSmallCashbox() , 100 ).isEmpty());
		assertTrue( mechanism.isEnoughCoins( this.initSmallCashbox() , 90 ).isEmpty());
		assertFalse( mechanism.isEnoughCoins( this.initSmallCashbox() , 80 ).isEmpty());
		assertTrue( mechanism.isEnoughCoins( this.initSmallCashbox() , 9000 ).isEmpty());
		assertTrue( mechanism.isEnoughCoins( this.initSmallCashbox() , 1 ).isEmpty());
	}
	
	public Cashbox initBigCashbox()
	{
		Cashbox cashbox = new BasicCashbox();
		cashbox.putCoins(Coin.COIN_10G, 10);
		cashbox.putCoins(Coin.COIN_20G, 10);
		cashbox.putCoins(Coin.COIN_50G, 10);
		cashbox.putCoins(Coin.COIN_1ZL, 10);
		cashbox.putCoins(Coin.COIN_2ZL, 10);
		cashbox.putCoins(Coin.COIN_5ZL, 10);
		return cashbox;
	}
	
	public Cashbox initSmallCashbox()
	{
		Cashbox cashbox = new BasicCashbox();
		cashbox.putCoins(Coin.COIN_10G, 1);
		cashbox.putCoins(Coin.COIN_20G, 1);
		cashbox.putCoins(Coin.COIN_50G, 1);
		return cashbox;
	}

}

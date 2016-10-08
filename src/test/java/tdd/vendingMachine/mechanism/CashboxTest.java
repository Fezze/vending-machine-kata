package tdd.vendingMachine.mechanism;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import tdd.vendingMachine.domain.Coin;

public class CashboxTest {

	protected Cashbox cashbox;
	protected Random random;
	
	@Before
	public void setUp() throws Exception {
		this.cashbox = new BasicCashbox();
		this.random = new Random();
	}

	@Test
	public void isEmpty() {		
		assertTrue( this.cashbox.isEmpty() );
	}
	
	@Test
	public void isSetZero() {		
		for( Coin coin : Coin.values()  )
		{
			assertTrue(  0 == this.cashbox.getCountCoins( coin ) );
		}
	}
	
	@Test
	public void puttedOK() {
		for( Coin coin : Coin.values()  )
		{
			this.cashbox.putCoin(coin);
			assertTrue( 1 == this.cashbox.getCountCoins( coin ) );
			this.cashbox.putCoin(coin);
			assertTrue( 2 == this.cashbox.getCountCoins( coin ) );
		}
	}
	
	@Test
	public void puttedManyOK() {	
		int randomInt, randomInt2;
		for( Coin coin : Coin.values()  )
		{
			randomInt = Math.abs( this.random.nextInt());
			this.cashbox.putCoins(coin , randomInt );
			assertTrue( randomInt == this.cashbox.getCountCoins( coin ) );
			randomInt2 = Math.abs( this.random.nextInt());
			this.cashbox.putCoins(coin , randomInt2 );
			assertTrue( ( randomInt + randomInt2 ) == this.cashbox.getCountCoins( coin ) );
		}
	}
	
	@Test
	public void puttedAndRemove() {	
		int randomInt, randomInt2;
		for( Coin coin : Coin.values()  )
		{
			randomInt = Math.abs( this.random.nextInt());
			randomInt2 = Math.abs( this.random.nextInt());
			
		
			this.cashbox.putCoins(coin , Math.max(randomInt, randomInt2) );
			assertTrue( Math.max(randomInt, randomInt2) == this.cashbox.getCountCoins( coin ) );
			
			this.cashbox.removeCoins(coin , Math.min(randomInt, randomInt2) );
			assertTrue( Math.abs( randomInt - randomInt2 ) == this.cashbox.getCountCoins( coin ) );
		}
	}
	
	@Test
	public void sumAllValueTest() {			
		float sum = 0.0f;
		
		for( Coin coin : Coin.values()  )
		{
			sum += coin.getValue();
			this.cashbox.putCoin(coin);
			
		}
		
		assertTrue( sum == this.cashbox.sumAllValue() );
	}
	
	@Test
	public void connectCashboxTest() {	
		Cashbox tmpCashbox = new BasicCashbox();

		for( Coin coin : Coin.values()  )
		{

			this.cashbox.putCoin(coin);
			tmpCashbox.putCoins(coin, 2);
			
		}
		
		this.cashbox.connectCashbox(tmpCashbox);
		
		for( Coin coin : Coin.values()  )
		{
			assertTrue( this.cashbox.getCountCoins(coin) == 3 );			
		}
	}
	
	@Test
	public void removeByCashboxTest() {	
		Cashbox tmpCashbox = new BasicCashbox();

		for( Coin coin : Coin.values()  )
		{
			this.cashbox.putCoins(coin, 4);
			tmpCashbox.putCoin(coin);			
		}
		
		this.cashbox.removeByCashbox(tmpCashbox);
		
		for( Coin coin : Coin.values()  )
		{
			assertTrue( this.cashbox.getCountCoins(coin) == 3 );			
		}
	}

}

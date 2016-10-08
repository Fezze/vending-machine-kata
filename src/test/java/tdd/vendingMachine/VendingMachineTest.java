package tdd.vendingMachine;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import tdd.vendingMachine.display.BasicDisplay;
import tdd.vendingMachine.display.DisplayMessage;
import tdd.vendingMachine.domain.Coin;
import tdd.vendingMachine.domain.Product;
import tdd.vendingMachine.mechanism.BasicCashbox;
import tdd.vendingMachine.mechanism.BasicMechanism;
import tdd.vendingMachine.mechanism.BasicShelve;
import tdd.vendingMachine.mechanism.Shelve;

public class VendingMachineTest {

protected VendingMachine vendingMachine;
	
	@Test
	public void test() {
	 	assertTrue( true );
	}

	@Before
	public void setUp() throws Exception {
		BasicCashbox godCoins = new BasicCashbox();
		godCoins.putCoins(Coin.COIN_10G, 10);
		godCoins.putCoins(Coin.COIN_20G, 10);
		godCoins.putCoins(Coin.COIN_50G, 10);
		godCoins.putCoins(Coin.COIN_1ZL, 10);
		godCoins.putCoins(Coin.COIN_2ZL, 10);
		godCoins.putCoins(Coin.COIN_5ZL, 10);
		
		this.vendingMachine = new VendingMachineBasic( new BasicDisplay( DisplayMessage.EMPTY_MESSAGE.getMessage() ) , godCoins , new BasicCashbox() , new BasicMechanism() );	
		
		BasicShelve godShelve = new BasicShelve();
		godShelve.addProduct( Product.CHOCOLATE_BAR );
		godShelve.addProduct( Product.CHOCOLATE_BAR );
		godShelve.addProduct( Product.CHOCOLATE_BAR );
		this.vendingMachine.AddShelve( godShelve );
		
		godShelve = new BasicShelve();
		godShelve.addProduct( Product.COLA_DRINK_025 );
		godShelve.addProduct( Product.COLA_DRINK_025 );
		godShelve.addProduct( Product.COLA_DRINK_025 );
		godShelve.addProduct( Product.COLA_DRINK_025 );
		
		godShelve = new BasicShelve();
		godShelve.addProduct( Product.MINERAL_WATER_033 );
		godShelve.addProduct( Product.MINERAL_WATER_033 );
		this.vendingMachine.AddShelve( godShelve );
	
	}
	
	@Test
	public void removeProduct()
	{
		this.vendingMachine.getProduct( 0 );
		assertTrue( this.vendingMachine.getSelectedShelve() == this.vendingMachine.getShelves().get(0) );
		Shelve tmp = this.vendingMachine.getSelectedShelve();
		int tmpCount =  tmp.getProductsCount();		
		this.vendingMachine.putCoin( Coin.COIN_5ZL );
		assertTrue( tmpCount - tmp.getProductsCount() == 1 );
		assertTrue( this.vendingMachine.getCashbox().getCountCoins( Coin.COIN_5ZL ) == 11 );		
		assertTrue( this.vendingMachine.getSelectedShelve() == null );
	}
	
	@Test
	public void removeProductRestZero()
	{
		this.vendingMachine.getProduct( 0 );
		assertTrue( this.vendingMachine.getSelectedShelve() == this.vendingMachine.getShelves().get(0) );
		Shelve tmp = this.vendingMachine.getSelectedShelve();
		int tmpCount =  tmp.getProductsCount();		
		this.vendingMachine.putCoin( Coin.COIN_2ZL );
		assertTrue( tmpCount - tmp.getProductsCount() == 0 );
		assertTrue( this.vendingMachine.getSelectedShelve() != null );
		assertTrue( this.vendingMachine.getPuttedCashbox().sumAllValue() == Coin.COIN_2ZL.getValue() );
		this.vendingMachine.putCoin( Coin.COIN_20G );
		assertTrue( tmpCount - tmp.getProductsCount() == 1 );
		assertTrue( this.vendingMachine.getSelectedShelve() == null );
	}
	
	@Test
	public void removeProductRestToBig()
	{
		this.vendingMachine.getProduct( 0 );
		this.vendingMachine.getCashbox().emptyCashbox();
		assertTrue( this.vendingMachine.getSelectedShelve() == this.vendingMachine.getShelves().get(0) );
		Shelve tmp = this.vendingMachine.getSelectedShelve();
		int tmpCount =  tmp.getProductsCount();		
		this.vendingMachine.putCoin( Coin.COIN_2ZL );
		assertTrue( tmpCount - tmp.getProductsCount() == 0 );
		assertTrue( this.vendingMachine.getSelectedShelve() != null );
		assertTrue( this.vendingMachine.getPuttedCashbox().sumAllValue() == Coin.COIN_2ZL.getValue() );
		this.vendingMachine.putCoin( Coin.COIN_1ZL );
		assertTrue( tmpCount - tmp.getProductsCount() == 0 );
		assertTrue( this.vendingMachine.getSelectedShelve() == null );
	}
}

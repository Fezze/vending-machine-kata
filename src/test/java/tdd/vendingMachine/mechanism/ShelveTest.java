package tdd.vendingMachine.mechanism;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tdd.vendingMachine.domain.Product;


public class ShelveTest {

	protected Shelve shelve;

    @Before
    public void setUp() {
        // given
        this.shelve = new BasicShelve();
    }
	
	@Test
	public void EverytingOk() {
		shelve.addProduct( Product.CHOCOLATE_BAR );
		shelve.addProduct( Product.CHOCOLATE_BAR );
		shelve.addProduct( Product.CHOCOLATE_BAR );
		shelve.addProduct( Product.CHOCOLATE_BAR );
		assertTrue( shelve.getProductsCount() == 4 );
	}
	
	@Test
	public void NotingOk() {
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ) );
		assertFalse(shelve.addProduct( Product.COLA_DRINK_025 ) );
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ) );
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ) );
		assertTrue( shelve.getProductsCount() == 3 );
	}
	
	@Test
	public void removAndAdd() {	
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ));
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ));
		assertTrue(shelve.addProduct( Product.CHOCOLATE_BAR ));
		assertTrue( shelve.getProductsCount() == 3 );
		shelve.removeProduct();
		shelve.removeProduct();
		shelve.removeProduct();
		assertTrue( shelve.getProductsCount() == 0 );
		assertTrue(shelve.addProduct( Product.COLA_DRINK_025 ));
		assertTrue( shelve.getProductsCount() == 1 );
	}

}

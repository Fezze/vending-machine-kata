package tdd.vendingMachine.mechanism;

import java.util.ArrayList;
import java.util.List;

import tdd.vendingMachine.domain.Product;

public class BasicShelve implements Shelve {

	private List<Product> products;
	
	public BasicShelve() {
		this.products = new ArrayList<Product>();
	}


	@Override
	public int getProductsCount() {
		return products.size();
	}

	@Override
	public boolean addProduct(Product product) {
		if( this.getProductsCount() == 0 || ( this.getProductsCount() > 0 && this.products.get(0) == product ) )
		{
			this.products.add(product);
			return true;
		}	
		return false;
	}
	
	@Override
	public void removeProduct()
	{
		this.products.remove( this.getProductsCount() - 1 );	
	}

	@Override
	public int getProductPrice( )
	{
		if( this.products.isEmpty() ){ return 0; }
		return this.products.get(0).getPrice();
	}
	
}

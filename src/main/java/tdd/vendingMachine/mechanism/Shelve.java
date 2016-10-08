package tdd.vendingMachine.mechanism;

import tdd.vendingMachine.domain.Product;

public interface Shelve {

	int getProductsCount();

	boolean addProduct(Product product);

	void removeProduct();

	int getProductPrice();

}
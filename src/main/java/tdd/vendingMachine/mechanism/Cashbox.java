package tdd.vendingMachine.mechanism;

import tdd.vendingMachine.domain.Coin;

public interface Cashbox {

	void emptyCashbox();

	void putCoin(Coin coin);

	void putCoins(Coin coin, int n);

	void removeCoin(Coin coin);

	void removeCoins(Coin coin, int n);

	int getCountCoins(Coin coin);

	boolean isEmpty();

	int sumAllValue();

	void connectCashbox(Cashbox tmpCashbox);

	void removeByCashbox(Cashbox tmpCashbox);

	String convertIntToPrice( int price );
	
}
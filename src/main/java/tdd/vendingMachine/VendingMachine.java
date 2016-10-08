package tdd.vendingMachine;

import java.util.List;

import tdd.vendingMachine.display.Display;
import tdd.vendingMachine.domain.Coin;
import tdd.vendingMachine.mechanism.Cashbox;
import tdd.vendingMachine.mechanism.Mechanism;
import tdd.vendingMachine.mechanism.Shelve;

public interface VendingMachine {

	void AddShelve(Shelve shelve);

	void getProduct(int id);

	void putCoin(Coin coin);

	void cancel();

	// Tylko dla testów i tylko by bardziej już nie komplikować.
	Display getDisplay();

	Shelve getSelectedShelve();

	Cashbox getCashbox();

	Cashbox getPuttedCashbox();

	Mechanism getMechanism();

	List<Shelve> getShelves();

}
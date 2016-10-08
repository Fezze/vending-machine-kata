package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.List;

import tdd.vendingMachine.display.Display;
import tdd.vendingMachine.display.DisplayMessage;
import tdd.vendingMachine.domain.Coin;
import tdd.vendingMachine.mechanism.Cashbox;
import tdd.vendingMachine.mechanism.Mechanism;
import tdd.vendingMachine.mechanism.Shelve;

public class VendingMachineBasic implements VendingMachine
{
	private Display display;
	private Shelve selectedShelve;
	private Cashbox cashbox;
	private Cashbox puttedCashbox;
	private Mechanism mechanism;	
	private List<Shelve> shelves;
	
	public VendingMachineBasic( Display display, Cashbox cashbox , Cashbox puttedCashbox , Mechanism mechanism )
	{
		this.display = display;
		this.cashbox = cashbox;
		this.puttedCashbox = puttedCashbox;
		this.mechanism = mechanism;
		this.shelves = new ArrayList<Shelve>();
	}
	
	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#AddShelve(tdd.vendingMachine.mechanism.Shelve)
	 */
	@Override
	public void AddShelve( Shelve shelve )
	{
		this.shelves.add( shelve );
	}
	
	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getProduct(int)
	 */
	@Override
	public void getProduct( int id )
	{
		if( this.shelves.size() <= id )
		{
			this.display.setMessage( DisplayMessage.NO_ITEM_ON_THIS_NUMBER.getMessage() );
		}
		else
		{						
			if( this.shelves.get( id ).getProductsCount() == 0 )
			{
				this.display.setMessage( DisplayMessage.EMPTY_PRODUCT_SHELVES.getMessage() );
			}
			else
			{
				this.selectedShelve = this.shelves.get( id );
				this.checkStatus();
			}
		}
	}
	
	private void checkStatus()
	{
		if( this.puttedCashbox.sumAllValue() >= this.selectedShelve.getProductPrice() )
		{
			this.releaseOfTheProduct( );
		} 
		else
		{
			this.display.setMessage( DisplayMessage.NOT_ENOUGHT_MONEY.getMessage() + this.cashbox.convertIntToPrice( this.selectedShelve.getProductPrice() - this.puttedCashbox.sumAllValue()) );
		}
	}
	
	private void releaseOfTheProduct(  )
	{
		int rest = this.puttedCashbox.sumAllValue() - this.selectedShelve.getProductPrice();
		if( rest > 0 )
		{
			
			Cashbox tmpCashbox = mechanism.isEnoughCoins(this.cashbox, rest);
			if( tmpCashbox.isEmpty() )
			{
				this.puttedCashbox.emptyCashbox();
				this.display.setMessage( DisplayMessage.RELEAS_ALL_MONEY.getMessage() );
			}
			else
			{
				this.cashbox.removeByCashbox( tmpCashbox );
				this.cashbox.connectCashbox( this.puttedCashbox );
				this.selectedShelve.removeProduct();
				this.display.setMessage( DisplayMessage.EMPTY_MESSAGE.getMessage() );
			}
		}
		else
		{
			this.cashbox.connectCashbox( this.puttedCashbox );
			this.selectedShelve.removeProduct();
			this.display.setMessage( DisplayMessage.EMPTY_MESSAGE.getMessage() );
		}
		this.selectedShelve = null;
	}
	
	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#putCoin(tdd.vendingMachine.domain.Coin)
	 */
	@Override
	public void putCoin( Coin coin )
	{
		this.puttedCashbox.putCoin(coin);
		if( this.selectedShelve != null )
		{
			this.checkStatus();
		}
		else
		{
			this.display.setMessage( DisplayMessage.CURRENT_STATUS.getMessage() + this.cashbox.convertIntToPrice( this.puttedCashbox.sumAllValue() ) );
		}
	}
	
	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#cancel()
	 */
	@Override
	public void cancel()
	{
		this.puttedCashbox.emptyCashbox();
		this.selectedShelve = null;
		this.display.setMessage( DisplayMessage.EMPTY_MESSAGE.getMessage() );
	}

	
	// Tylko dla testów i tylko by bardziej już nie komplikować.
	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getDisplay()
	 */
	@Override
	public Display getDisplay() {
		return display;
	}

	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getSelectedShelve()
	 */
	@Override
	public Shelve getSelectedShelve() {
		return selectedShelve;
	}

	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getCashbox()
	 */
	@Override
	public Cashbox getCashbox() {
		return cashbox;
	}

	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getPuttedCashbox()
	 */
	@Override
	public Cashbox getPuttedCashbox() {
		return puttedCashbox;
	}

	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getMechanism()
	 */
	@Override
	public Mechanism getMechanism() {
		return mechanism;
	}

	/* (non-Javadoc)
	 * @see tdd.vendingMachine.VendingMachine#getShelves()
	 */
	@Override
	public List<Shelve> getShelves() {
		return shelves;
	}
}

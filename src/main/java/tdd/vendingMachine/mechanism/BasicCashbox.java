package tdd.vendingMachine.mechanism;

import java.util.HashMap;
import java.util.Map;

import tdd.vendingMachine.domain.Coin;

public class BasicCashbox implements Cashbox {
	private Map< Coin, Integer > cashbox;
	
	public BasicCashbox()
	{		
		this.cashbox = new HashMap< Coin , Integer >();
		for( Coin coin : Coin.values()  )
		{
			this.cashbox.put( coin , 0 );
		}
	}

	@Override
	public void emptyCashbox()
	{
		for( Coin coin : Coin.values()  )
		{
			this.cashbox.put( coin , 0 );
		}
	}
	
	@Override
	public void putCoin( Coin coin )
	{
		this.putCoins( coin , 1 );
	}
	
	@Override
	public void putCoins( Coin coin , int n )
	{
		this.cashbox.put( coin , this.cashbox.get( coin ) + n );
	}
	
	@Override
	public void removeCoin( Coin coin )
	{
		this.removeCoins( coin , 1 );
	}
	
	@Override
	public void removeCoins( Coin coin , int n )
	{
		this.cashbox.put( coin , this.cashbox.get( coin ) - n );
	}
	
	@Override
	public int getCountCoins( Coin coin )
	{
		return this.cashbox.get( coin );
	}
	

	@Override
	public boolean isEmpty()
	{
		for( Coin coin : Coin.values()  )
		{
			if( this.cashbox.get( coin ) != 0 ) return false;
		}
		return true;
	}
	
	@Override
	public int sumAllValue()
	{
		int tmp = 0;
		for( Coin coin : Coin.values() )
		{
			tmp += coin.getValue() * this.cashbox.get( coin );
		}
		return tmp;
	}
	
	@Override
	public void connectCashbox( Cashbox tmpCashbox )
	{
		for( Coin coin : Coin.values() )
		{
			this.putCoins( coin, tmpCashbox.getCountCoins(coin) );
			tmpCashbox.removeCoins(coin, tmpCashbox.getCountCoins(coin));
		}
	}
	
	@Override
	public void removeByCashbox( Cashbox tmpCashbox )
	{
		for( Coin coin : Coin.values() )
		{
			this.removeCoins( coin, tmpCashbox.getCountCoins(coin) );
		}
	}
	
	public String convertIntToPrice( int price )
	{
		return "" + ((int)price/100) +"." + (price%100);
	}
}

package tdd.vendingMachine.mechanism;

import tdd.vendingMachine.domain.Coin;

public class BasicMechanism implements Mechanism
{
	@Override
	public Cashbox isEnoughCoins( Cashbox  cashbox , int rest )
	{
		Cashbox tmpCashbox = new BasicCashbox();
		int count;
		
		for( Coin coin : Coin.values() )
		{
			if( coin.getValue() > rest && cashbox.getCountCoins( coin ) == 0  )
			{
				continue;
			}
		
			count = (int)(rest / coin.getValue());			
			if( count > cashbox.getCountCoins( coin ) )
			{
				rest = rest - ( cashbox.getCountCoins( coin ) * coin.getValue() );
				tmpCashbox.putCoins( coin , cashbox.getCountCoins( coin ) );
			}
			else
			{
				rest = rest - ( count * coin.getValue() );
				tmpCashbox.putCoins( coin , count );
			}
		}
		if( rest > 0  )
		{
			return new BasicCashbox();
		}
		return tmpCashbox;
	}
}

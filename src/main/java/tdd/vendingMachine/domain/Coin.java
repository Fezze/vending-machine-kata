package tdd.vendingMachine.domain;

public enum Coin {

	COIN_5ZL( 500 ),
	COIN_2ZL( 200 ),
	COIN_1ZL( 100 ),
	COIN_50G( 50 ),
	COIN_20G( 20 ),
    COIN_10G( 10 );
    
    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public String getConvertValue()
    {
    	return "" + ((int)this.value/100) +"." + (this.value%100);
    }
}


package tdd.vendingMachine.domain;

public enum Product {

    COLA_DRINK_025( 350 , "Cola Drink 0,25l" ),
    CHOCOLATE_BAR( 220 , "Chocolate bar" ),
    MINERAL_WATER_033( 140 , "Mineral Water 0,33l" );

    private final int price;
    private final String name;

    Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    
    public String getName(){
    	return name;
    }
}

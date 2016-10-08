package tdd.vendingMachine.display;

public enum DisplayMessage {
	EMPTY_MESSAGE(""),
	NO_ITEM_ON_THIS_NUMBER("Brak Przedmiotu o podanym numerze"),
	NOT_ENOUGHT_MONEY("Brakuje jeszcze: "),
	CURRENT_STATUS("Aktualny stan: "),
	RELEAS_ALL_MONEY("Z powodu braku monet oddaje ci cale pieniadze "),
	EMPTY_PRODUCT_SHELVES("Produkt się skończył");

    private final String message;

    DisplayMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
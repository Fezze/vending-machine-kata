package tdd.vendingMachine.display;

public class BasicDisplay implements Display
{
	private String message;
	
	public BasicDisplay(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage()
	{
		return this.message;
	}

	@Override
	public void setMessage(String message)
	{
		this.message = message;		
	}

}

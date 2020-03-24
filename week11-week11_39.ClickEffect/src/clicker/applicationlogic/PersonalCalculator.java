package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {
	private int currentValue;
	
	@Override
	public int giveValue() {
		return currentValue;
	}
	
	@Override
	public void increase() {
		currentValue++;
	}
}

public class CalculatorState {
	private static int currentValue;
	
	public static int getCurrentValue() {
		return currentValue;
	}
	
	public static void add(int amount) {
		currentValue += amount;
	}
	
	public static void subtract(int amount) {
		currentValue -= amount;
	}
	
	public static void clear() {
		currentValue = 0;
	}
}


public class Main {
	
	public static void main(String[] args) {
		int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(build(t));
	}
	
	public static String build(int[] t) {
		StringBuilder sb = new StringBuilder("{\n ");
		
		for (int i = 0; i < t.length; i++) {
			boolean shouldAddNewLine = i != 0 && i % 4 == 0;
			boolean isLastLine = i == t.length - 1;
			String numberSeparator = (isLastLine) ? "": ", ";
			
			if (shouldAddNewLine)
				sb.append("\n ");
			
			sb.append(t[i] + numberSeparator);
			
			if (isLastLine) {
				sb.append("\n}\n");
			}
		}
		return sb.toString();
	}
}

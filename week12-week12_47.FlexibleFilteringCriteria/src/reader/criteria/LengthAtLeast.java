package reader.criteria;

public class LengthAtLeast implements Criterion {
	private int minLength;
	
	public LengthAtLeast(int minLength) {
		this.minLength = minLength;
	}
	
	@Override
	public boolean complies(String line) {
		return line.length() >= minLength;
	}
}

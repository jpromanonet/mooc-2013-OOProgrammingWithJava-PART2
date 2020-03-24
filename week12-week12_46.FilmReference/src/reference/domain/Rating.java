package reference.domain;

public enum Rating {
	BAD(-5),
	MEDIOCRE(-3),
	NOT_WATCHED(0),
	NEUTRAL(1),
	FINE(3),
	GOOD(5);
	
	private int ratingValue;
	
	private Rating(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
	public int getValue() {
		return ratingValue;
	}
}

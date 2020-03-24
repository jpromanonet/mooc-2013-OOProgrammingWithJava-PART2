package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {
	@Override
	public boolean complies(String line) {
		return line.endsWith("!") || line.endsWith("?");
	}
}

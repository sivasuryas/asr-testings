package project.speech.evaluator;

public class EvaluatorResult {
	private int hits;
	private int substitutions;
	private int deletions;
	private int insertions;

	public EvaluatorResult(int h, int s, int d, int i) {
		hits = h;
		substitutions = s;
		deletions = d;
		insertions = i;
	}
	
	public int getHits() {
		return hits;
	}

	public int getSubstitutions() {
		return substitutions;
	}

	public int getDeletions() {
		return deletions;
	}

	public int getInsertions() {
		return insertions;
	}

}


package acme.spamFilter;

import java.util.Map;

public class SpamFilter {

	private Map<String, Double>	spamTuples;

	private Double				spamThreshold;


	public SpamFilter(Map<String, Double> spamTuples, Double spamThreshold) {
		super();
		this.spamTuples = spamTuples;
		this.spamThreshold = spamThreshold;
	}

	public Boolean checkIsNotSpam(String text) {
		String[] textSplit = text.toLowerCase().split("\\s+");
		Double totalWeight = 0.;
		for (String word : textSplit) {
			if (spamTuples.containsKey(word)) {
				totalWeight += spamTuples.get(word);
			}
		}
		Double spamValue = totalWeight / textSplit.length;
		return spamValue < spamThreshold;
	}

	public Map<String, Double> getSpamTuples() {
		return spamTuples;
	}

	public void setSpamTuples(Map<String, Double> spamTuples) {
		this.spamTuples = spamTuples;
	}

	public Double getSpamThreshold() {
		return spamThreshold;
	}

	public void setSpamThreshold(Double spamThreshold) {
		this.spamThreshold = spamThreshold;
	}
}

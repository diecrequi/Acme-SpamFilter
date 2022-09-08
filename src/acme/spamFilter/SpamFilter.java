
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
		String textFormatted = text.toLowerCase().replaceAll("\\s+", " ");
		Double totalWeight = 0.;
		for (String spamTerm : spamTuples.keySet()) {
		        Integer count = textFormatted.split(spamTerm, -1).length-1;
			    totalWeight += spamTuples.get(spamTerm) * count;
		}
		Double spamValue = totalWeight / textFormatted.split(" ").length;
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

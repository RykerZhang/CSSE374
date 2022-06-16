package textprocessor;

public class SubstitutionTransformer implements Transformer {
	private String pattern;
	private String replacement;
	
	public SubstitutionTransformer(String pattern, String replacement) {
		this.pattern = pattern;
		this.replacement = replacement;
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	@Override
	public String transform(String text) {
		return text.replaceAll(pattern, replacement);
	}
}

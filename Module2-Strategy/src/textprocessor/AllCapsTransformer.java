package textprocessor;

public class AllCapsTransformer implements Transformer {

	@Override
	public String transform(String text) {
		if(text == null)
			return null;
		return text.toUpperCase();
	}
}

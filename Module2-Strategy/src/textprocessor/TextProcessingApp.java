package textprocessor;

public class TextProcessingApp {
	public static void main(String[] args) {
		String text = "This is also sample text. It will be processed by this application.";

		Transformer transformer1 = new AllCapsTransformer();

		Transformer transformer2 = new SubstitutionTransformer("processed", "transformed");
		
		//Suppose we use AllCapsTransformer first and later switched to the substitutionTransformer. So the transformer in the processor constructor is 
		// transformer1 now. 
		TextProcessor processor = new TextProcessor(text, transformer1);
		ProcessorUI ui = new ProcessorUI(processor, transformer1, transformer2, "AllCaps Transformer", "Substitution Transformer");
		
		ui.show();
	}
}

package amazon.choices;

public enum LeftNavigationSection {

	DIGITAL_CONTENT_DEVICES("digital content & devices"),
	SHOP_BY_CATEGORY("shop by category");
	 private final String text;

	 LeftNavigationSection(final String text) {
	        this.text = text;
	    }
	 
	 @Override
	    public String toString() {
	        return text;
	    }
}

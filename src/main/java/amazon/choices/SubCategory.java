package amazon.choices;

public enum SubCategory {
	
	TELEVVISIONS("Televisions"),
	HEADPHONES("Headphones");
	
	 private final String text;

	 SubCategory(final String text) {
	        this.text = text;
	    }
	 
	 @Override
	    public String toString() {
	        return text;
	    }

}

package amazon.choices;

public enum Category {
	TV_APPLIANCES_ELECTRONICS("TV, Appliances, Electronics"),
	MOBILES_COMPUTERS("Mobiles, Computers");
	
	 private final String text;

	 Category(final String text) {
	        this.text = text;
	    }
	 
	 @Override
	    public String toString() {
	        return text;
	    }

}

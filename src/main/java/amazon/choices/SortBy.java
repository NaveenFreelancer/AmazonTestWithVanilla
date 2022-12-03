package amazon.choices;

public enum SortBy {
	LOW_TO_HIHG("Price: Low to High"),
	HIGH_TO_LOW("Price: High to Low"),
	AVG_CUST_REVIEW("Avg. Customer Review"),
	NEWEST_ARRIVALS("Newest Arrivals");
	
	 private final String text;

	 SortBy(final String text) {
	        this.text = text;
	    }
	 
	 @Override
	    public String toString() {
	        return text;
	    }

}

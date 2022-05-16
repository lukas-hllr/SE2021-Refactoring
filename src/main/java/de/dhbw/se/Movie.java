package de.dhbw.se;
public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private final String title;
	private int priceCode;
	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}
	public int getPriceCode() {
		return this.priceCode;
	}
	public void setPriceCode(int pricecode) {
		this.priceCode = pricecode;
	}
	public String getTitle () {
		return this.title;
	};
}
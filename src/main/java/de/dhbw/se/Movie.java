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

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle () {
		return this.title;
	};

	public double getPrice(int daysRented) {
		double result = 0;
		switch (this.getPriceCode()) {
			case Movie.REGULAR -> {
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
			}
			case Movie.NEW_RELEASE -> {
				result += daysRented * 3;
			}
			case Movie.CHILDREN -> {
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
			}
		}
		return result;
	}
}
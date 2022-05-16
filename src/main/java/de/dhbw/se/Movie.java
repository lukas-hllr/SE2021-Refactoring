package de.dhbw.se;

import de.dhbw.se.price.ChildrenPrice;
import de.dhbw.se.price.NewReleasePrice;
import de.dhbw.se.price.Price;
import de.dhbw.se.price.RegularPrice;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private final String title;
	public Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case REGULAR:
				price = new RegularPrice();
				break;
			case CHILDREN:
				price = new ChildrenPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			default:
				throw new IllegalArgumentException("PriceCode not found!");
		}
	}

	public String getTitle () {
		return this.title;
	};

	public double getPrice(int daysRented) {
		return price.getPrice(daysRented);
	}
}
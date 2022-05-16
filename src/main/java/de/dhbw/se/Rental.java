package de.dhbw.se;

class Rental {
	private final Movie movie;
	private final int daysRented;
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	public int getDaysRented() {
		return this.daysRented;
	}
	public Movie getMovie() {
		return this.movie;
	}

	public double getPrice() {
		double result = 0;
		switch (this.getMovie().getPriceCode()) {
			case Movie.REGULAR -> {
				result += 2;
				if (this.getDaysRented() > 2)
					result += (this.getDaysRented() - 2) * 1.5;
			}
			case Movie.NEW_RELEASE -> {
				result += this.getDaysRented() * 3;
			}
			case Movie.CHILDREN -> {
				result += 1.5;
				if (this.getDaysRented() > 3)
					result += (this.getDaysRented() - 3) * 1.5;
			}
		}
		return result;
	}

	public int getFrequentRenterPoints() {
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			return 2;
		}
		return 1;
	}
}

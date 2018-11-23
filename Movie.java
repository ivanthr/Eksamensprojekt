
public class Movie {
	public String title;
	public int year;
	public String[] categories;
	public double rating;
	public Movie(String title, int year, String[] categories, double rating) {
		this.title = title;
		this.year = year;
		this.categories = categories;
		this.rating = rating;
	}
	
	public String toString() {
		return "" + title + ", " + year + ", " + categories[0] + ", " + rating;
	}
}

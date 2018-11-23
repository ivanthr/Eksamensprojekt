
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
		String cats = "[ ";
		String sep = "";
		for(String s : categories) {
			cats += sep + s;
			sep = ", ";
		}
		cats += " ]";
		
		return "" + title + ", " + year + ", " + cats + ", " + rating;
	}
}

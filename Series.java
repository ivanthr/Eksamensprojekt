
public class Series {
	public String title;
	public boolean hasFinished;
	public int[] years; //years[0] = start year, years[1] = end year
	public String[] categories;
	public double rating;
	public String[] seasons;
	
	public Series(String title, int yearStart, int yearEnd, String[] categories, double rating, String[] seasons) {
		this.years = new int[2];
		this.title = title;
		this.hasFinished = true;
		this.years[0] = yearStart;
		this.years[1] = yearEnd;
		this.categories = categories;
		this.rating = rating;
		this.seasons = seasons;
	}
	
	public Series(String title, int yearStart, String[] categories, double rating, String[] seasons) {
		this.years = new int[1];
		this.title = title;
		this.hasFinished = false;
		this.years[0] = yearStart;
		this.categories = categories;
		this.rating = rating;
		this.seasons = seasons;
	}
	
	public String toString() {
		String cats = "[ ";
		String sep = "";
		for(String s : categories) {
			cats += sep + s;
			sep = ", ";
		}
		cats += " ]";
		String seasonsStr = "season";
		if(seasons.length > 1) seasonsStr += "s";
		if(hasFinished) {
			return "" + title + ", " + years[0] + "-" + years[1] + ", " + cats + ", " + rating + ", " + seasons.length + " " + seasonsStr;	
		}
		return "" + title + ", " + years[0] + "-?" + ", " + cats + ", " + rating + ", " + seasons.length + " " + seasonsStr;
	}
}

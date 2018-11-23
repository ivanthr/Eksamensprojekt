import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		MovieReader mr = new MovieReader("C:\\Users\\Bruger\\eclipse-workspace\\EP\\src\\movies.txt");
		List<Movie> movies = new ArrayList<Movie>();
		try {
			movies = mr.read();
		} catch (FileNotFoundException e) {
			System.out.println("FFE: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOE: " + e.getMessage());
		}
		
		int i = 0;
		for(Movie m : movies) {
			System.out.println(i + ": " + m + " -- " + m.getClass());
			i++;
		}
		
		SeriesReader sr = new SeriesReader("C:\\Users\\Bruger\\eclipse-workspace\\EP\\src\\series.txt");
		List<Series> series = new ArrayList<Series>();
		try {
			series = sr.read();
		} catch (FileNotFoundException e) {
			System.out.println("FFE: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOE: " + e.getMessage());
		}
		
		for(Series s : series) {
			System.out.println(i + ": " + s + " -- " + s.getClass());
			i++;
		}
	}

}

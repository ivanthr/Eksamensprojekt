import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MovieReader {
	private String filename;
	public MovieReader(String filename) {
		this.filename = filename;
	}
	
	public List<Movie> read() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		List<Movie> movies = read(br);
		br.close();
		return movies;
	}
	
	private List<Movie> read(BufferedReader br) throws IOException {
		List<Movie> movies = new ArrayList<Movie>();
		
		while(br.ready()) {
			String line = br.readLine();
			String[] parts = line.split(";");
			String title = parts[0].trim();
			int year = Integer.parseInt(parts[1].trim());
			String[] categoryParts = parts[2].split(",");
			String[] categories = new String[categoryParts.length];
			for(int i=0; i<categories.length; i++) {
				categories[i] = categoryParts[i].trim();
			}			
			String d = parts[3].replace(',', '.').trim();
			double rating = Double.parseDouble(d);
			movies.add(new Movie(title, year, categories, rating));
		}
		
		return movies;
		
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SeriesReader {
	private String filename;
	
	public SeriesReader(String filename) {
		this.filename = filename;
	}
	
	public List<Series> read() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		List<Series> series = read(br);
		br.close();
		return series;
	}
	
	private List<Series> read(BufferedReader br) throws IOException {
		List<Series> series = new ArrayList<Series>();
		
		while(br.ready()) {
			String line = br.readLine();
			String[] parts = line.split(";");

			// find title
			String title = parts[0].trim();
			// find years
			int yearStart = -1;
			int yearEnd = -1;
			String[] years = parts[1].trim().split("-");
			if(years.length == 1) {
				if(parts[1].contains("-")) { // only one season in this series
					yearStart = Integer.parseInt(years[0]);
					yearEnd = -1;
				} else {
					yearStart = yearEnd = Integer.parseInt(years[0]);
				}
			} else if(years.length == 2) {
				yearStart = Integer.parseInt(years[0]);
				yearEnd = Integer.parseInt(years[1]);
			}
			// find categories
			String[] categoryParts = parts[2].split(",");
			String[] categories = new String[categoryParts.length];
			for(int i=0; i<categories.length; i++) {
				categories[i] = categoryParts[i].trim();
			}
			//find rating
			String d = parts[3].replace(',', '.').trim();
			double rating = Double.parseDouble(d);
			// find seasons
			String[] seasons = parts[4].trim().split(",");
			// add series
			if(yearEnd > 0) {
				series.add(new Series(title, yearStart, yearEnd, categories, rating, seasons));
			} else {
				series.add(new Series(title, yearStart, categories, rating, seasons));
			}
		}
		
		return series;
		
	}
}
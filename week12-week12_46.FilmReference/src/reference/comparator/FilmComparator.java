package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
	private Map<Film, List<Rating>> ratings;
	
	public FilmComparator(Map<Film, List<Rating>> ratings) {
		this.ratings = ratings;
	}
	
	private double getAverageRating(Film film) {
		int sum = 0;
		for (Rating rating :
				ratings.get(film)) {
			sum += rating.getValue();
		}
		
		return (double)(sum/ratings.size());
	}
	
	@Override
	public int compare(Film o1, Film o2) {
		double avg1 = getAverageRating(o1);
		double avg2 = getAverageRating(o2);
		
		return (int)(avg2 - avg1);
	}
}

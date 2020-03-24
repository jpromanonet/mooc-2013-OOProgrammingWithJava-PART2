package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
	private Map<Film, List<Rating>> filmListRatingsHashMap;
	private Map<Person, HashMap<Film, Rating>> personalRatings;
	
	public RatingRegister() {
		filmListRatingsHashMap = new HashMap<Film, List<Rating>>();
		personalRatings = new HashMap<Person, HashMap<Film, Rating>>();
	}
	
	public void addRating(Film film, Rating rating) {
		if (filmListRatingsHashMap.containsKey(film)) {
			filmListRatingsHashMap.get(film).add(rating);
		} else {
			List<Rating> ratings = new ArrayList<Rating>();
			ratings.add(rating);
			filmListRatingsHashMap.put(film, ratings);
		}
	}
	
	public void addRating(Person person, Film film, Rating rating) {
		addRating(film, rating);
		
		if (personalRatings.containsKey(person)) {
			personalRatings.get(person).put(film, rating);
		} else {
			HashMap<Film, Rating> newRating = new HashMap<Film, Rating>();
			newRating.put(film, rating);
			personalRatings.put(person, newRating);
		}
	}
	
	public List<Rating> getRatings(Film film) {
		if (filmListRatingsHashMap.containsKey(film))
			return filmListRatingsHashMap.get(film);
		
		return null;
	}
	
	public Rating getRating(Person person, Film film) {
		if (personalRatings.containsKey(person) && personalRatings.get(person).containsKey(film))
			return personalRatings.get(person).get(film);
		
		return Rating.NOT_WATCHED;
	}
	
	public Map<Film, List<Rating>> filmRatings() {
		return filmListRatingsHashMap;
	}
	
	public Map<Film, Rating> getPersonalRatings(Person person) {
		if (!personalRatings.containsKey(person))
			addEmptyReviewer(person);
		return personalRatings.get(person);
		
	}
	
	private void addEmptyReviewer(Person person) {
		HashMap<Film, Rating> emptyRatingMap = new HashMap<Film, Rating>();
		personalRatings.put(person, emptyRatingMap);
	}
	
	public List<Person> reviewers() {
		return new ArrayList<Person>(personalRatings.keySet());
	}
}

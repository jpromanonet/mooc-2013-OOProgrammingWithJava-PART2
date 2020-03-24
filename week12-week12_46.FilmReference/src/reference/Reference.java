package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
	private RatingRegister register;
	
	public Reference(RatingRegister register) {
		this.register = register;
	}
	
	private int calculateSimilarityBetween(Person person1, Person person2) {
		Map<Film, Rating> personalRatingPerson1 = register.getPersonalRatings(person1);
		Map<Film, Rating> personalRatingPerson2 = register.getPersonalRatings(person2);
		int similarity = 0;
		for (Film film :
				personalRatingPerson1.keySet()) {
			if (personalRatingPerson2.keySet().contains(film))
				similarity += (personalRatingPerson1.get(film).getValue() * personalRatingPerson2.get(film).getValue());
		}
		
		return similarity;
	}
	
	private Person mostSuitablePerson(List<Person> people, Person person) {
		Person mostSuitable = null;
		Integer tempSimilarity = 0;
		
		for (Person otherPerson :
				people) {
			
			if (person.equals(otherPerson))
				continue;
			
			Integer similarity = calculateSimilarityBetween(person, otherPerson);
			
			if (similarity > tempSimilarity)
				mostSuitable = otherPerson;
			
			tempSimilarity = similarity;
		}
		
		return mostSuitable;
	}
	
	private Film recommendFromSuitablePerson(Person needsRecommendation, FilmComparator filmComparator) {
		Person suitablePerson = mostSuitablePerson(register.reviewers(), needsRecommendation);
		if (suitablePerson == null)
			return null;
		
		List<Film> recommendedFilms = createListFromSuitablePerson(suitablePerson, needsRecommendation);
		return recommendHighestRatedFilm(recommendedFilms, filmComparator);
	}
	
	private List<Film> createListFromSuitablePerson(Person suitablePerson, Person needsRecommendation) {
		List<Film> recommendedFilms = new ArrayList<Film>();
		Map<Film, Rating> suitablePersonRatings = register.getPersonalRatings(suitablePerson);
		Map<Film, Rating> personRatings = register.getPersonalRatings(needsRecommendation);

		if (personRatings.keySet().containsAll(suitablePersonRatings.keySet())) {
			return null;
		}

		int ratingThreshold = 1;

		for (Film film :
				suitablePersonRatings.keySet()) {
			if (ratingAboveThreshold(suitablePersonRatings, film, ratingThreshold) && !watched(personRatings, film)) {
				recommendedFilms.add(film);
			}
		}

		return recommendedFilms;
	}
	
	private boolean watched(Map<Film, Rating> watchedMap, Film film) {
		return watchedMap.keySet().contains(film);
	}
	
	private boolean ratingAboveThreshold(Map<Film, Rating> filmRatingMap, Film film, int threshold) {
		return filmRatingMap.get(film).getValue() > threshold;
	}
	
	public Film recommendFilm(Person person) {
		Map<Film, List<Rating>> filmRatings = register.filmRatings();
		FilmComparator comparator = new FilmComparator(filmRatings);
		
		if(!canFindSimilarTastes(person)) {
			return recommendHighestRatedFilm(new ArrayList<Film>(filmRatings.keySet()), comparator);
		} else {
			return recommendFromSuitablePerson(person, comparator);
		}
	}
	
	private boolean canFindSimilarTastes(Person needsRecommendation) {
		Map<Film, Rating> personRatings = register.getPersonalRatings(needsRecommendation);
		return (personRatings != null && !personRatings.isEmpty());
	}
	
	private Film recommendHighestRatedFilm(List<Film> movies, FilmComparator comparator) {
		movies.sort(comparator);
		return movies.get(0);
	}
}

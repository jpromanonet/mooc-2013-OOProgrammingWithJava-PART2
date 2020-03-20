package Phonesearch;

import java.util.HashSet;
import java.util.Set;

public class Phone {
    private Set<String> numbers;

    public Phone() {
        this.numbers = new HashSet<String>();
    }

    public void add(String number) {
        this.numbers.add(number);
    }

    public Set<String> getNumbers() {
        return numbers;
    }
}
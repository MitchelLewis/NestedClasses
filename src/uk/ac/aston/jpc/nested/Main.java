package uk.ac.aston.jpc.nested;

import java.util.function.Consumer;

import static uk.ac.aston.jpc.nested.v4.SteppingRange.range;

public class Main {

	public static void main(String[] args) {
		SizedIterable<Integer> r = range(5, 5, 101);
		r.forEach(System.out::println);
		System.out.println("There are " + r.size() + " numbers.");
	}

}

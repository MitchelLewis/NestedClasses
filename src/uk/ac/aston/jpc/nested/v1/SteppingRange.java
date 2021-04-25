package uk.ac.aston.jpc.nested.v1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uk.ac.aston.jpc.nested.SizedIterable;

public class SteppingRange implements SizedIterable<Integer> {
	private final int min, step, max;

	public SteppingRange(int min, int step, int max) {
		this.min = min;
		this.step = step;
		this.max = max;
	}

	private static class SteppingRangeIterator implements Iterator<Integer> {
		private int current;
		private SteppingRange range;

		public SteppingRangeIterator(SteppingRange rangeObj) {
			this.current = rangeObj.min;
			this.range = rangeObj;
		}

		@Override
		public boolean hasNext() {
			return current < range.max;
		}

		@Override
		public Integer next() {
			if (current >= range.max) {
				throw new NoSuchElementException();
			}
			final int result = current;
			current += range.step;
			return result;
		}

	}

	@Override
	public Iterator<Integer> iterator() {
		return new SteppingRangeIterator(this);
	}

	public static SizedIterable<Integer> range(int min, int step, int max) {
		return new SteppingRange(min, step, max);
	}
}

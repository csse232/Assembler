package io;
/**
	 * A generic pair of values used to return multiple values.
	 * 
	 * @author Marc Schmitt
	 *
	 * @param <T>
	 * @param <E>
	 */
	public class Pair<T, E> {
		private T value1;
		private E value2;

		public Pair(T val1, E val2) {
			this.value1 = val1;
			this.value2 = val2;
		}

		public void setValues(T val1, E val2) {
			this.value1 = val1;
			this.value2 = val2;
		}

		public T getValue1() {
			return this.value1;
		}

		public E getValue2() {
			return this.value2;
		}

		public void setValue1(T val1) {
			this.value1 = val1;
		}

		public void setValue2(E val2) {
			this.value2 = val2;
		}
	}
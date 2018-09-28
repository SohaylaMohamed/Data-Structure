package eg.edu.alexu.csd.datastructure.linkedList.cs18_32;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**.
 * @author Sohayla Mohamed
 *
 */
public class PolynomialSolver implements IPolynomialSolver {

/**
*
 */
  private DoublyLinkedList a = new DoublyLinkedList();
/**
*
*/
 private  DoublyLinkedList b = new DoublyLinkedList();
/**
*
*/
private DoublyLinkedList c = new DoublyLinkedList();
	/**.
     *
	 */
	private DoublyLinkedList r = new DoublyLinkedList();

	/**.
	 * sort an array
	 *
	 * @param anArray
	 *            unsorted array
	 * @param size
	 *            the number of rows in an array
	 *
	 */
	public void sorting(final int[][] anArray, final int size) {
		int minIndex;
		int index;
		for (index = 0; index < size - 1; index++) {
			minIndex = getMinIndex(anArray, index, size - 1);
			swap(anArray, index, minIndex);
		}
	}

	/**.
	 * gets the min value's index
	 *
	 * @param anArray
	 *            an array
	 * @param first
	 *            first index
	 * @param last
	 *            last index
	 * @return min index of an array
	 *
	 */
	public int getMinIndex(final int[][] anArray,
			final int first, final int last) {
		int minIndex;
		int index;
		minIndex = first;
		for (index = first + 1; index <= last; index++) {
			if (anArray[index][1] < anArray[minIndex][1]) {
				minIndex = index;
			}
		}
		return minIndex;
	}

	/**.
	 * Swap two elements in an array
	 *
	 * @param arr
	 *            an array
	 * @param s
	 *            first Row index
	 * @param t
	 *            second row index
	 */
	public void swap(final int[][] arr, final int s, final int t) {
		int temp1 = arr[s][0];
		int temp2 = arr[s][1];
		arr[s][0] = arr[t][0];
		arr[s][1] = arr[t][1];
		arr[t][0] = temp1;
		arr[t][1] = temp2;
	}

	/**.
	 * checks if a list is set or nor
	 *
	 * @param poly
	 *            char which points to a list
	 *
	 * @return true if set ,false if not
	 *
	 */
	public boolean checkSet(final char poly) {
		DoublyLinkedList list = new DoublyLinkedList();
		if (poly == 'A' || poly == 'a') {
			list = a;
		} else if (poly == 'B' || poly == 'b') {
			list = b;
		} else if (poly == 'C' || poly == 'c') {
			list = c;
		} else if (poly == 'R' || poly == 'r') {
			list = r;
		}
		return list.isEmpty();
	}

	/**.
	 * Set polynomial terms (coefficients & exponents)
	 *
	 * @param poly
	 *            name of the polynomial
	 * @param terms
	 *            array of [coefficients][exponents]
	 */
	public void setPolynomial(final char poly, final int[][] terms) {
		if (poly == 'A' || poly == 'a') {
			if (!a.isEmpty()) {
				a.clear();
			}

		} else {
			if (poly == 'B' || poly == 'b') {
				if (!b.isEmpty()) {
					b.clear();
				}

			} else {
				if (poly == 'C' || poly == 'c') {
					if (!c.isEmpty()) {
						c.clear();
					}

				}

			}
		}
		if (terms == null || terms.length == 0) {
			throw null;
		}
		for (int i = 0; i < terms.length - 1; i++) {
			if (terms[i][1] < terms[i + 1][1]) {
				throw new RuntimeException();
			}
		}
		int max = 0;
		for (int i = 0; i < terms.length; i++) {
			if (max < terms[i][1]) {
				max = terms[i][1];
			}
			if ((terms[i][1]) < 0 || max != terms[0][1]) {
				throw null;
			}
		}
		if (poly != 'A' && poly != 'B' && poly != 'C'
				&& poly != 'a' && poly != 'b' && poly != 'c') {
			throw new RuntimeException();
		}

		int rows = terms.length;

		DoublyLinkedList list = new DoublyLinkedList();
		int index = 0;
		sorting(terms, rows);
		for (int i = 0; i < rows; i++) {
			int exp = terms[i][1];
			if (exp == index) {
				list.add(index, terms[i][0]);
				index++;
			} else {
				while (exp != index) {
					list.add(index, 0);
					index++;
				}
				list.add(index, terms[i][0]);

				index++;

			}
		}
		if (poly == 'A' || poly == 'a') {
			a = list;

		} else {
			if (poly == 'B' || poly == 'b') {
				b = list;

			} else {
				if (poly == 'C' || poly == 'c') {
					c = list;

				}

			}
		}

	}

	/**.
	 * Print the polynomial in human readable representation
	 *
	 * @param poly
	 *            name of the polynomial
	 * @return polynomial in the form like 27x^2+x-1
	 */
	public String print(final char poly) {
		DoublyLinkedList p = new DoublyLinkedList();
		String polynomial = "", word = null;
		Node temp = null;
		if (poly == 'A' || poly == 'a') {
			temp = a.tail.getPrev();
			p = a;
		} else if (poly == 'B' || poly == 'b') {
			temp = b.tail.getPrev();
			p = b;
		} else if (poly == 'C' || poly == 'c') {
			temp = c.tail.getPrev();
			p = c;
		} else if (poly == 'R' || poly == 'r') {
			temp = r.tail.getPrev();
			p = r;
		} else {
			throw null;
		}
		if (p.isEmpty()) {
			return null;
		}
		int counter = p.size() - 1;
		if ((int) temp.getValue() != 0) {
			word = (int) temp.getValue() + "X^" + counter;
			polynomial = word + polynomial;
			counter--;
			temp = temp.getPrev();
		}
		while (temp != p.head) {
			if ((Integer) temp.getValue() != 0) {
				if (counter == 0) {
					if ((Integer) temp.getValue() < 0) {
					 polynomial = polynomial
							 + temp.getValue();
					} else {
						polynomial = polynomial
							+ '+' + temp.getValue();
					}
				} else {
					if (counter == 1) {
						word = (Integer) temp.getValue()
							+ "X^" + counter;
					if ((Integer) temp.getValue() < 0) {
						polynomial = polynomial + word;
						} else {
						 polynomial = polynomial
								 + "+" + word;
						}
					} else {
						word = (Integer) temp.getValue()
							+ "X^" + counter;
					if ((Integer) temp.getValue() < 0) {
						polynomial = polynomial + word;
						} else {
						polynomial = polynomial
								+ "+" + word;
						}
					}
				}
			}
			counter--;
			temp = temp.getPrev();
		}
		if (polynomial == "") {
			polynomial = "0^0";
		}
		if (polynomial.charAt(0) == '+') {
			polynomial = polynomial.substring(1);
		}
		return polynomial;
	}

	/**.
	 * Clear the polynomial
	 *
	 * @param poly
	 *            name of the polynomial
	 */
	public void clearPolynomial(final char poly) {
		if (poly == 'A' || poly == 'a') {
			if (a.isEmpty()) {
				throw new RuntimeException();
			}
			a.clear();

		} else {
			if (poly == 'B' || poly == 'b') {
				if (b.isEmpty()) {
					throw new RuntimeException();
				}
				b.clear();

			} else {
				if (poly == 'C' || poly == 'c') {
					if (c.isEmpty()) {
						throw new RuntimeException();
					}
					c.clear();

				} else if (poly == 'R' || poly == 'r') {
					if (r.isEmpty()) {
						throw new RuntimeException();
					}
					r.clear();

				} else {
					throw null;
				}
			}
		}

	}

	/**.
	 * Evaluate the polynomial
	 *
	 * @param poly
	 *            name of the polynomial
	 * @param value
	 *            polynomial constant value
	 * @return the value of the polynomial
	 */
	public float evaluatePolynomial(final char poly, final float value) {
		float result = 0, counter = 0;
		DoublyLinkedList p = new DoublyLinkedList();
		Node temp = null;
		if (poly == 'A' || poly == 'a') {
			temp = a.head.getNext();
			p = a;
		} else if (poly == 'B' || poly == 'b') {
			temp = b.head.getNext();
			p = b;
		} else if (poly == 'C' || poly == 'c') {
			temp = c.head.getNext();
			p = c;
		} else if (poly == 'R' || poly == 'r') {
			temp = r.head.getNext();
			p = r;
		} else {
			throw new RuntimeException();
		}
		if (temp == null) {
			throw new RuntimeException();
		}

		while (temp.getNext() != p.tail) {
			if ((Integer) temp.getValue() != 0) {
				result += (Integer) temp.getValue()
						* Math.pow(value, counter);
			}
			temp = temp.getNext();
			counter++;
		}
		result += (Integer) temp.getValue() * Math.pow(value, counter);
		return result;
	}

	/**.
	 * Add two polynomials
	 *
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] add(final char poly1, final char poly2) {
		DoublyLinkedList p1 = new DoublyLinkedList();
		DoublyLinkedList p2 = new DoublyLinkedList();
		DoublyLinkedList sum = new DoublyLinkedList();
		Node temp1 = null, temp2 = null;

		int result, counter = 0;
		if (poly1 == 'A' || poly1 == 'a') {
			temp1 = a.head.getNext();
			p1 = a;
		} else if (poly1 == 'B' || poly1 == 'b') {
			temp1 = b.head.getNext();
			p1 = b;
		} else if (poly1 == 'C' || poly1 == 'c') {
			temp1 = c.head.getNext();
			p1 = c;
		} else if (poly1 == 'R' || poly1 == 'r') {
			p1 = r;
			temp1 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}

		if (poly2 == 'A' || poly2 == 'a') {
			temp2 = a.head.getNext();
			p2 = a;
		} else if (poly2 == 'B' || poly2 == 'b') {
			temp2 = b.head.getNext();
			p2 = b;
		} else if (poly2 == 'C' || poly2 == 'c') {
			temp2 = c.head.getNext();
			p2 = c;
		} else if (poly2 == 'R' || poly2 == 'r') {
			p2 = r;
			temp2 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}
		if (temp1 == null || temp2 == null
				|| p1.isEmpty() || p2.isEmpty()) {
			throw null;
		}

		int size1 = p1.size(), size2 = p2.size();
		while (counter < size1 && counter < size2) {
			result = (Integer) temp1.getValue()
					+ (Integer) temp2.getValue();
			sum.add(result);
			counter++;
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		if (counter < size1) {
			while (counter < size1) {
				sum.add(temp1.getValue());
				temp1 = temp1.getNext();
				counter++;
			}
		} else {
			while (counter < size2) {
				sum.add(temp2.getValue());
				temp2 = temp2.getNext();
				counter++;
			}
		}

		r = sum;

		int[][] temp = new int[sum.size()][2];
		int j = 0;
		for (int i = sum.size() - 1; i >= 0; i--) {
			if ((int) sum.get(i) != 0) {
				temp[j][0] = (int) sum.get(i);
				temp[j][1] = i;
				j++;
			}
		}

		int[][] re = new int[j][2];
		for (int i = 0; i < j; i++) {
			re[i][0] = temp[i][0];
			re[i][1] = temp[i][1];
		}
		return re;
	}

	/**.
	 * Subtract two polynomials
	 *
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] subtract(final char poly1, final char poly2) {
		Node temp1 = null, temp2 = null;
		DoublyLinkedList o1 = new DoublyLinkedList();
		DoublyLinkedList o2 = new DoublyLinkedList();
		DoublyLinkedList o = new DoublyLinkedList();

		int result, counter = 0;
		if (poly1 == 'A' || poly1 == 'a') {
			temp1 = a.head.getNext();
			o1 = a;
		} else if (poly1 == 'B' || poly1 == 'b') {
			temp1 = b.head.getNext();
			o1 = b;
		} else if (poly1 == 'C' || poly1 == 'c') {
			temp1 = c.head.getNext();
			o1 = c;
		} else if (poly1 == 'R' || poly1 == 'r') {
			o1 = r;
			temp1 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}

		if (poly2 == 'A' || poly2 == 'a') {
			temp2 = a.head.getNext();
			o2 = a;
		} else if (poly2 == 'B' || poly2 == 'b') {
			temp2 = b.head.getNext();
			o2 = b;
		} else if (poly2 == 'C' || poly2 == 'c') {
			temp2 = c.head.getNext();
			o2 = c;
		} else if (poly2 == 'R' || poly2 == 'r') {
			o2 = r;
			temp2 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}
		if (temp1 == null || temp2 == null) {
			throw new RuntimeException();
		}
		if (o1 == o2) {
			r.clear();
			r.add(0);
			int[][] arr = new int[1][2];
			arr[0][0] = 0;
			arr[0][1] = 0;
			return arr;
		}
		int size1 = o1.size(), size2 = o2.size();
		while (counter < size1 && counter < size2) {
			result = (Integer) temp1.getValue()
					- (Integer) temp2.getValue();
			o.add(result);
			counter++;
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		if (counter < size1) {
			while (counter < size1) {
				o.add(temp1.getValue());
				temp1 = temp1.getNext();
				counter++;
			}
		} else {
			while (counter < size2) {
				o.add(-1 * (Integer) temp2.getValue());
				temp2 = temp2.getNext();
				counter++;
			}
		}
		r = o;

		int j = 0;
		int[][] arr = new int[o.size()][2];
		for (int i = o.size() - 1; i >= 0; i--) {
			if ((int) o.get(i) != 0) {
				arr[j][0] = (int) o.get(i);
				arr[j][1] = i;
				j++;
			}
		}

		int[][] sub = new int[j][2];
		for (int i = 0; i < j; i++) {
			sub[i][0] = arr[i][0];
			sub[i][1] = arr[i][1];
		}
		return sub;
	}

	/**.
	 * Multiply two polynomials
	 *
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] multiply(final char poly1, final char poly2) {
		DoublyLinkedList p1 = new DoublyLinkedList();
		DoublyLinkedList p2 = new DoublyLinkedList();
		DoublyLinkedList mult = new DoublyLinkedList();

		Node temp1 = null, temp2 = null;

		if (poly1 == 'A' || poly1 == 'a') {
			p1 = a;
			temp1 = a.head.getNext();
		} else if (poly1 == 'B' || poly1 == 'b') {
			p1 = b;
			temp1 = b.head.getNext();
		} else if (poly1 == 'C' || poly1 == 'c') {
			p1 = c;
			temp1 = c.head.getNext();

		} else if (poly1 == 'R' || poly1 == 'r') {
			p1 = r;
			temp1 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}

		if (poly2 == 'A' || poly2 == 'a') {
			p2 = a;
			temp2 = a.head.getNext();

		} else if (poly2 == 'B' || poly2 == 'b') {
			p2 = b;
			temp2 = b.head.getNext();

		} else if (poly2 == 'C' || poly2 == 'c') {
			p2 = c;
			temp2 = c.head.getNext();

		} else if (poly2 == 'R' || poly2 == 'r') {
			p2 = r;
			temp2 = r.head.getNext();
		} else {
			throw new RuntimeException();
		}

		if (temp1 == null || temp2 == null) {
			throw new RuntimeException();
		}

		int exp, co;
		int counter = 0;
		int size1 = p1.size();
		int size2 = p2.size();

		for (int i = 0; i < size1; i++) {
			counter = 0;
			temp2 = p2.head.getNext();
			for (int j = 0; j < size2; j++) {

				exp = i + j;
				co = (Integer) temp1.getValue()
						* (Integer) temp2.getValue();

				while (counter != exp) {
					if (counter < mult.size()) {
						counter++;
					} else {
						mult.add(0);
						counter++;
					}
				}
				if (counter < mult.size()) {
					mult.set(counter, co
						+ (Integer) mult.get(counter));
					counter++;
				} else {
					mult.add(counter, co);
					counter++;
				}

				temp2 = temp2.getNext();

			}

			temp1 = temp1.getNext();

		}
		r = mult;

		int[][] temp = new int[mult.size()][2];
		int indexI = 0;
		for (int k = mult.size() - 1; k >= 0; k--) {
			if ((int) mult.get(k) != 0) {
				temp[indexI][0] = (int) mult.get(k);
				temp[indexI][1] = k;
				indexI++;
			}
		}

		int[][] re = new int[indexI][2];
		for (int k = 0; k < indexI; k++) {
			re[k][0] = temp[k][0];
			re[k][1] = temp[k][1];
		}

		return re;
	}

}

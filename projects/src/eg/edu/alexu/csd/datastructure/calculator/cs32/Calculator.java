package eg.edu.alexu.csd.datastructure.calculator.cs32;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**.
 * @author Sohayla Mohamed
 *
 */
public class Calculator implements ICalculator {
  /**.
  * Adds given two numbers
  *
  * @param x
  *            first number
  * @param y
  *            second number
  * @return the sum of the two numbers
  */
  public int add(final int x, final int y) {
    final int z = x + y;
    return z;
  }

  /**.
   * Divids two numbers
   *
   * @param x
   *            first number
   * @param y
   *            second number
   * @return the division result
   */
  public float divide(final int x, final int y) {

    final float z = (float) x / (float) y;
    return z;
  }
}

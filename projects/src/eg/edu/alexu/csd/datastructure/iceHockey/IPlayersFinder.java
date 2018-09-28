package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

/**
 * @author Sohayla Mohamed
 *
 */
public interface IPlayersFinder {
/**.
* Search for players locations at the given photo
*
* @param photo
*            Two dimension array of photo contents Will contain between 1
*            and 50 elements, inclusive
* @param team
*            Identifier of the team
* @param threshold
*            Minimum area for an element Will be between 1 and 10000,
*            inclusive
* @return Array of players locations of the given team
*/
java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

/**
* @param x
*            the row number
* @param y
*            the column number
* @param visited
*            the boolean array that shows the teams locations
* @param rows
*            the number of rows
* @param cols
*            the number of columns
*/
void dfs(int x, int y, boolean[][] visited, int rows, int cols);

/**
* @param x1
*            the y coordinate of the first cell
* @param x2
*            the y coordinate of the last cell
* @param y1
*            the x coordinate of the first cell
* @param y2
*            the x coordinate of the last cell
* @return the center location coordeinates
*/
Point avg(int x1, int x2, int y1, int y2);

}

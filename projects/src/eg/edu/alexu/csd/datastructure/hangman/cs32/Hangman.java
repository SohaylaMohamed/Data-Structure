package eg.edu.alexu.csd.datastructure.hangman.cs32;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Arrays;
import java.util.Random;



/**.
 * @author Sohayla Mohamed
 *
 */

public class Hangman implements IHangman {

 /**.
*
 */
private String[] dictionary;

  /**.
 *
 */
private String secretWord;
  /**.
 *
 */
private int wrongGuesses;
  /**.
 *
 */
private char[] guessedWord;

  /**.
  * Set dictinary words to pick secret words from
  *
  *    @param words
  *              an array of words
  */
  public void setDictionary(final String[] words) {
    if (words == null) {
      dictionary = null;
    } else {
      dictionary = Arrays.copyOf(words, words.length);
    }
  }

 /**.
     * Pick a random secret word from dictionary and returns it
     *
     * @return secret word
     */
 public String selectRandomSecretWord() {
    if (dictionary == null) {
      return null;
    } else {

    Random randI = new Random();
    int index = randI.nextInt(dictionary.length);
    secretWord = dictionary[index];
    guessedWord = new char[secretWord.length()];
    for (int i = 0; i < secretWord.length(); i++) {
           guessedWord[i] = '-';
     }

    return secretWord;
    }
}

 /**.
* Receive a new user guess, and verify it against the secret word.
*
* @param c
*            case insensitive user guess. If c is NULL then ignore it and
*            do no change
* @return secret word with hidden characters
*/
public String guess(final Character c) {
  String ch = String.valueOf(c);
  String w = new String(guessedWord);
  if (ch == null) {

     return w;

  } else {
  if (secretWord == null) {
     return null;
  } else {
      if (w == secretWord) {
           return null;
      } else {
           char nc = Character.toLowerCase(c);
           int i;
           int found = 0;
           String temp = secretWord;
           temp = temp.toLowerCase();
           for (i = 0; i < secretWord.length(); i++) {
           if (temp.charAt(i) == nc) {
                        guessedWord[i] = secretWord.charAt(i);
                        found = 1;
                    }
                    }
                    if (found == 0) {
                      wrongGuesses--;
                    }
                    if (wrongGuesses <= 0) {
                      return null;
                     } else {
                        String word = new String(guessedWord);

                      return word;
                   }
                    }
      }
  }
}

/**.
* Set the maximum number of wrong guesses
*
* @param max
*            maximum number of wrong guesses, If is NULL,
*             then assume it 0
*/
public void setMaxWrongGuesses(final Integer max) {
    if (max == null) {
       wrongGuesses = 0;
     } else {
       wrongGuesses = max;
     }

    }

}

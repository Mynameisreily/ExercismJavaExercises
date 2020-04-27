import java.util.*;

public class PigLatinTranslator {

  public String translate(String phrase) {

    // Splitting the string for each word (if there are multiple)
    String[] piggy = phrase.split("\\s+");
    String fin = "";

    // Different arrays of specific things to look for in the strings
    ArrayList<Character> vowel = new ArrayList<Character>();
    vowel.add('a');
    vowel.add('e');
    vowel.add('i');
    vowel.add('o');
    vowel.add('u');

    /*
     *
     * Rule 1 - Done
     *
     * Rule 2 - Done
     *
     * Rule 3 - Done
     *
     * Rule 4 - Done
     *
     */

    for (String word : piggy) {

      Boolean weDone = false;
      Boolean consFlag = false;

      String flipflop = "";
      String ay = "";

      word = word.toLowerCase();
      int len = word.length();

      if (len == 2 && word.charAt(1) == 'y') {

        flipflop = "y" + word.charAt(0) + "ay";

      } else {
        for (int i = 0; i < len; i++) {

          char letter = word.charAt(i);

          if (weDone) {

            flipflop += letter;

          } else {
            if (letter == 'x' || letter == 'y') {
              if (i == 0) {
                if ((letter == 'x') && (word.charAt(1) == 'r')) {

                  flipflop += 'x';
                  ay = "ay";
                  weDone = true;

                } else if ((letter == 'y') && (word.charAt(1) == 't')) {

                  flipflop += 'y';
                  ay = "ay";
                  weDone = true;

                } else {
                  ay += letter;
                  consFlag = true;
                }
              } else {
                if (letter == 'y') {
                  ay += "ay";
                  flipflop += letter;
                  weDone = true;
                } else {
                  consFlag = true;
                  ay += letter;
                }
              }
            } else if (vowel.contains(letter)) {
              if (consFlag && (word.charAt(i - 1) == 'q') && word.charAt(i) == 'u') {
                ay += "uay";
                weDone = true;
              } else {
                ay += "ay";
                flipflop += letter;
                weDone = true;
              }

            } else {
              consFlag = true;
              ay += letter;
            }
          }
        }
        flipflop += ay;
      }
      fin += flipflop + " ";
    }
    return fin.substring(0, fin.length() - 1);
  }
}

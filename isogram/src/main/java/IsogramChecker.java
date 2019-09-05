import java.util.*;

class IsogramChecker {

    boolean isIsogram(String phrase) {
      //Spaces and Hyphens are not included
      //No Repeating Letters
      ArrayList<Character> letters = new ArrayList<Character>();

      for(int i = 0; i < phrase.length(); i++) {
        char c = phrase.charAt(i);

        if(c != '-' && c != ' ') {
          if(letters.contains(Character.toUpperCase(c))) {
            return false;
          } else {
            letters.add(Character.toUpperCase(c));
          }
        }
      }
      return true;
    }
}

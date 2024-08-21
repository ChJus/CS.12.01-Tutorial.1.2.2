public class HiddenWord {
  // Stores word to be guessed
  private final String word;

  public HiddenWord(String word) {
    this.word = word.toUpperCase();
  }

  // Gets the word to be guessed
  public String getHiddenWord() {
    return word;
  }

  // Returns a string representing the letters and positions
  // that were guessed correctly:
  // - if the letter is the same in the hidden word and guess, reveal the letter at that position
  // - if a letter in guess is in the hidden word but another position, place "+" at that position
  // - if a letter in guess is not in the hidden word, place "*" at that position
  public String getHint(String guess) {
    // Reject guesses that are not in full caps
    if (!guess.equals(guess.toUpperCase())) {
      throw new IllegalArgumentException("Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
    }

    // Reject guesses whose length is not the same as the hidden word
    if (guess.length() != word.length()) {
      throw new IllegalArgumentException("Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + word.length() + " characters. Your guess must be a word with " + word.length() + " characters!");
    }

    String result = "";

    // Go through each character in the guess
    for (int i = 0; i < guess.length(); i++) {
      char c = guess.charAt(i);

      // Cases:
      // 1: the character in the current position matches the one in the hidden word
      // 2: the character in the current position is present elsewhere in the hidden word
      // 3: the character in the current position is not in the hidden word
      if (c == word.charAt(i)) result += c;
      else if (word.contains(c + "")) result += "+";
      else result += "*";
    }
    return result;
  }
}

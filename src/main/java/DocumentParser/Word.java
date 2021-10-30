package DocumentParser;

import Tokenizer.Token;

public class Word {
    private final Token word;

    Word(Token word) {
        this.word = word;
    }

    public String getWord() {
        return word.getValue();
    }
}

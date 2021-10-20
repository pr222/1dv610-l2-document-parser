package DocumentParser;

import Tokenizer.Token;

public class Word {
    Token word;

    Word(Token word) {
        this.word = word;
    }

    public String getWord() {
        return word.getValue();
    }
}

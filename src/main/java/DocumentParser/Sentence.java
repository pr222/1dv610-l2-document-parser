package DocumentParser;

import Tokenizer.Token;
import java.util.ArrayList;

public abstract class Sentence {
    ArrayList<Word> words;
    Token endMarker;

    public Sentence(Token endMarker) {
        this.words = new ArrayList<>();
        this.endMarker = endMarker;
    }

    public String getSentence() {
        return buildSentence();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    private String buildSentence() {
        StringBuilder sentence = new StringBuilder();

        for (Word word : words) {
            sentence.append(word.getWord()).append(" ");
        }

        sentence.replace(sentence.length()-1, sentence.length(), endMarker.getValue());

        return sentence.toString();
    }
}

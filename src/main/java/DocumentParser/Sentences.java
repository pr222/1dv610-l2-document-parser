package DocumentParser;

import java.util.ArrayList;

public class Sentences {
    private final ArrayList<Sentence> sentences;

    public Sentences() {
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public ArrayList<Sentence> getListOfSentences() {
        return sentences;
    }
}

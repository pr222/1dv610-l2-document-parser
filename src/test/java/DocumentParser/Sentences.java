package DocumentParser;

import java.util.ArrayList;

public class Sentences {
    ArrayList<Sentence> sentences;

    public Sentences() {
        this.sentences = new ArrayList<>();
    }

    public void insertSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public ArrayList<Sentence> getListOfSentences() {
        return sentences;
    }
}

package DocumentParser;

import Tokenizer.Token;

import java.util.ArrayList;

public class Document {
    private Sentences sentences;
    private Token endMarker;

    public Document() {
        this.sentences = new Sentences();
        this.endMarker = new Token("END", "");
    }

    public void addToSentences(Sentence sentence) {
        sentences.addSentence(sentence);
    }

    public ArrayList<Sentence> getAllSentences() {
        return sentences.getListOfSentences();
    }

    public ArrayList<Sentence> getAllRegular() {
        // TODO: Return all Regular
        return new ArrayList<>();
    }

    public ArrayList<Sentence> getAllQuestions() {
        // TODO: Return all Question
        return new ArrayList<>();
    }

    public ArrayList<Sentence> getAllExclamations() {
        // TODO: Return all Exclamation
        return new ArrayList<>();
    }
}

package DocumentParser;

import java.util.ArrayList;

public class Document {
    private final Sentences sentences;

    public Document() {
        this.sentences = new Sentences();
    }

    public void addToSentences(Sentence sentence) {
        sentences.addSentence(sentence);
    }

    public ArrayList<Sentence> getAllSentences() {
        return sentences.getListOfSentences();
    }

    public ArrayList<Sentence> getAllRegular() {
        ArrayList<Sentence> regular = new ArrayList<>();

        for (Sentence sentence : sentences.getListOfSentences()) {
            if (sentence instanceof Regular) {
                regular.add(sentence);
            }
        }

        return regular;
    }

    public ArrayList<Sentence> getAllQuestions() {
        ArrayList<Sentence> question = new ArrayList<>();

        for (Sentence sentence : sentences.getListOfSentences()) {
            if (sentence instanceof Question) {
                question.add(sentence);
            }
        }

        return question;
    }

    public ArrayList<Sentence> getAllExclamations() {
        ArrayList<Sentence> exclamation = new ArrayList<>();

        for (Sentence sentence : sentences.getListOfSentences()) {
            if (sentence instanceof Exclamation) {
                exclamation.add(sentence);
            }
        }

        return exclamation;
    }
}

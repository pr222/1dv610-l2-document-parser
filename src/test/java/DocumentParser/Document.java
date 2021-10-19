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

    public ArrayList<Sentence> getAllSentences() {
        return sentences.getListOfSentences();
    }


}

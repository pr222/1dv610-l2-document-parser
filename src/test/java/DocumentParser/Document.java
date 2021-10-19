package DocumentParser;

import Tokenizer.Token;

public class Document {
    private Sentences sentences;
    private Token endMarker;

    public Document() {
        this.sentences = new Sentences();
        this.endMarker = new Token("END", "");
    }

    public Sentences getSentences() {
        return sentences;
    }


}

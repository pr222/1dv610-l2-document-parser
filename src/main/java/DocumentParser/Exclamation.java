package DocumentParser;

import Tokenizer.Token;

public class Exclamation extends Sentence {

    public Exclamation(Token endMarker) throws Exception {
        super(endMarker);

        if(endMarker.getType().equals("EXCLAMATION")) {
            throw new Exception("Invalid end marker for Exclamation Sentence");
        }
    }
}

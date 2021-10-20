package DocumentParser;

import Tokenizer.Token;

public class Question extends Sentence {

    public Question(Token endMarker) throws Exception {
        super(endMarker);

        if(!endMarker.getType().equals("QUESTION")) {
            throw new Exception("Invalid end marker for Question Sentence");
        }
    }
}

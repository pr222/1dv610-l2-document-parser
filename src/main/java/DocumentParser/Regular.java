package DocumentParser;

import Tokenizer.Token;

public class Regular extends Sentence {

    public Regular(Token endMarker) throws Exception {
        super(endMarker);

        if(!endMarker.getType().equals("DOT")) {
            throw new Exception("Invalid end marker for Regular Sentence");
        }
    }
}

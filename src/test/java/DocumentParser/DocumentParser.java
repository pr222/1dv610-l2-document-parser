package DocumentParser;

import Tokenizer.TokenGrammar;
import Tokenizer.TokenMatchRule;
import Tokenizer.Tokenizer;
import Tokenizer.Token;

import java.util.ArrayList;


public class DocumentParser {
    private Document document;
    private final TokenGrammar grammar;

    public DocumentParser() {
        this.document = new Document();
        this.grammar = new TokenGrammar();

        TokenMatchRule word = new TokenMatchRule("WORD", "^[\\w|åäöÅÄÖ]+");
        grammar.addRule(word);

        TokenMatchRule dot = new TokenMatchRule("DOT", "^\\.");
        grammar.addRule(dot);

        TokenMatchRule question = new TokenMatchRule("QUESTION", "^\\?");
        grammar.addRule(question);

        TokenMatchRule exclamation = new TokenMatchRule("EXCLAMATION", "^\\!");
        grammar.addRule(exclamation);
    }

    public void parse(String newInput) throws Exception {
        Tokenizer tokenizer = new Tokenizer(grammar, newInput);

        ArrayList<Token> tokens = new ArrayList<>();

        while(tokenizer.getActiveToken().getType() != "END") {

            tokenizer.next();
        }
        Token token = new Token();
        // TODO: loop tokenizer until END
        // TODO: loops to build sentences, check for sentence types
    }

    public Document getParsedDocument() {
        return document;
    }

    public void resetDocument() {
        document = new Document();
    }
}

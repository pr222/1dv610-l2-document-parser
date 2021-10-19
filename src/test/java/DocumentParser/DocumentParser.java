package DocumentParser;

import Tokenizer.TokenGrammar;
import Tokenizer.TokenMatchRule;
import Tokenizer.Tokenizer;

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

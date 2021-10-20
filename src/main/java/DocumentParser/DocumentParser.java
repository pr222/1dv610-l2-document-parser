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

        while(!tokenizer.getActiveToken().getType().equals("END")) {
            if (tokenizer.getActiveToken().getType().equals("WORD")) {
                tokens.add(tokenizer.getActiveToken());
            } else {
                if (tokens.size() > 0) {
                    if (tokenizer.getActiveToken().getType().equals("DOT")) {
                        Sentence sen = new Regular(tokenizer.getActiveToken());
                        for (Token tok : tokens) {
                            sen.addWord(new Word(tok));
                        }
                        document.addToSentences(sen);
                    } else if (tokenizer.getActiveToken().getType().equals("QUESTION")) {
                        Sentence sen = new Question(tokenizer.getActiveToken());
                        for (Token tok : tokens) {
                            sen.addWord(new Word(tok));
                        }
                        document.addToSentences(sen);
                    } else if (tokenizer.getActiveToken().getType().equals("EXCLAMATION")) {
                        Sentence sen = new Exclamation(tokenizer.getActiveToken());
                        for (Token tok : tokens) {
                            sen.addWord(new Word(tok));
                        }
                        document.addToSentences(sen);
                    }
                    tokens = new ArrayList<>();
                } else {
                    throw new Exception("Invalid sentence, a sentence must have at least one word");
                }
            }

            tokenizer.next();
        }


        // TODO: loops to build sentences, check for sentence types
    }

    private void documentize(Token token) {

    }

    public Document getParsedDocument() {
        return document;
    }

    public void resetDocument() {
        document = new Document();
    }
}

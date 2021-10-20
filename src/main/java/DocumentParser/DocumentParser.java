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

    public Document getParsedDocument() {
        return document;
    }

    public void resetDocument() {
        document = new Document();
    }

    public void parse(String newInput) throws Exception {
        ArrayList<Token> tokens = makeTokens(newInput);
        parseToDocument(tokens);
    }

    private ArrayList<Token> makeTokens(String input) throws Exception {
        Tokenizer tokenizer = new Tokenizer(grammar, input);

        ArrayList<Token> tokens = new ArrayList<>();

        while(!tokenizer.getActiveToken().getType().equals("END")) {
            tokens.add(tokenizer.getActiveToken());
            tokenizer.next();
        }

        return tokens;
    }

    private void parseToDocument(ArrayList<Token> tokens) throws Exception {
        ArrayList<Token> words = new ArrayList<>();

        for (Token token : tokens) {
            if (token.getType().equals("WORD")) {
                words.add(token);
            } else {
                if (words.size() > 0) {
                    Sentence sentence = makeSentence(token, words);
                    document.addToSentences(sentence);
                    words = new ArrayList<>();
                } else {
                    throw new Exception("Invalid sentence, a sentence must have at least one word");
                }
            }
        }
    }

    private Sentence makeSentence(Token endToken, ArrayList<Token> wordTokens) throws Exception {
        Sentence sentence;

        if (endToken.getType().equals("DOT")) {
            sentence = new Regular(endToken);
        } else if (endToken.getType().equals("QUESTION")) {
            sentence = new Question(endToken);
        } else if (endToken.getType().equals("EXCLAMATION")) {
            sentence = new Exclamation(endToken);
        } else {
            throw new Exception("Could not match a valid ending marker for sentence.");
        }

        for (Token token : wordTokens) {
            sentence.addWord(new Word(token));
        }

        return sentence;
    }
}

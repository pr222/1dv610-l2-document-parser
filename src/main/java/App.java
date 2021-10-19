import Tokenizer.Token;

public class App {
    public static void main(String[] args) {
        Token token = new Token("DOT", ".");
        System.out.println(token.getType());
    }
}

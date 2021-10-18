import Tokenizer.Token;

public class App {
    public static void main(String[] args) {
        String TEXT_RESET = "\u001B[0m";
        // String TEXT_RED = "\u001B[31m";
        String TEXT_COLOR = "\u001B[38;5;197m";
        String TEXT_BGCOLOR = "\u001B[48;5;30m";
        String TEXT_BOLD = "\u001B[1m";
        String TEXT_UNDERLINE = "\u001B[4m";
        String input = "  This text is red?  ";
        String output1 = "BOLD: " + TEXT_BOLD + TEXT_COLOR + TEXT_BGCOLOR + input + TEXT_RESET;
        String output2 = "REGULAR: " + TEXT_COLOR + TEXT_BGCOLOR + input + TEXT_RESET + "\u001B[2K";
        String output3 = "UNDERLINE: " + TEXT_UNDERLINE + TEXT_COLOR + TEXT_BGCOLOR + input + TEXT_RESET + "\u001B[2K";
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);

        Token token = new Token("DOT", ".");
        System.out.println(token.getType());
    }
}

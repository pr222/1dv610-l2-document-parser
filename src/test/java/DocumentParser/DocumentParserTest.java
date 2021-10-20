package DocumentParser;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DocumentParserTest {
    Document empty;
    Document with3RegularSentences;
    Document with1Regular1Question1Exclamation;
    Document with2Questions1Exclamation;
    Document with2Exclamations1Regular;

    @BeforeAll
    public void setupParser() throws Exception {
        DocumentParser parser = new DocumentParser();

        parser.parse(" ");
        empty = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("This  is  regular . Another one. Stopping with this.");
        with3RegularSentences = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("This is very regular. Another one? Stopping with this!");
        with1Regular1Question1Exclamation = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("Is this regular? Another one? Stopping with this!");
        with2Questions1Exclamation = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("Is not regular! Another one! Stopping with this.");
        with2Exclamations1Regular = parser.getParsedDocument();
        parser.resetDocument();
    }

    @Test void GIVEN_empty_askingForAllSentences_SHOULD_haveSize0() {
        Assertions.assertEquals(0, empty.getAllSentences().size());
    }

    @Test void GIVEN_with3RegularSentences_askingForAllSentences_SHOULD_haveSize3() {
        Assertions.assertEquals(3, with3RegularSentences.getAllSentences().size());
    }

    @Test void GIVEN_with3RegularSentences_askingForAllRegular_SHOULD_haveSize3() {
        Assertions.assertEquals(3, with3RegularSentences.getAllRegular().size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_askingForAllSentences_SHOULD_haveSize3() {
        Assertions.assertEquals(3, with1Regular1Question1Exclamation.getAllSentences().size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_askingForAllRegular_SHOULD_haveSize1() {
        Assertions.assertEquals(1, with1Regular1Question1Exclamation.getAllRegular().size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_askingForAllQuestions_SHOULD_haveSize1() {
        Assertions.assertEquals(1, with1Regular1Question1Exclamation.getAllQuestions().size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_askingForAllExclamations_SHOULD_haveSize1() {
        Assertions.assertEquals(1, with1Regular1Question1Exclamation.getAllExclamations().size());
    }

    @Test void GIVEN_with2Questions1Exclamation_askingForAllQuestions_SHOULD_haveSize2() {
        Assertions.assertEquals(2, with2Questions1Exclamation.getAllQuestions().size());
    }

    @Test void GIVEN_with2Questions1Exclamation_askingForAllExclamations_SHOULD_haveSize1() {
        Assertions.assertEquals(1, with2Questions1Exclamation.getAllExclamations().size());
    }

    @Test void GIVEN_with2Exclamations1Regular_askingForAllExclamations_SHOULD_haveSize2() {
        Assertions.assertEquals(2, with2Exclamations1Regular.getAllExclamations().size());
    }

    @Test void GIVEN_with2Exclamations1Regular_askingForAllRegulars_SHOULD_haveSize1() {
        Assertions.assertEquals(1, with2Exclamations1Regular.getAllRegular().size());
    }

    @Test void GIVEN_with3RegularSentences_theFirstSentence_SHOULD_returnRightFormattedString() {
        String sentence = with3RegularSentences.getAllSentences().get(0).getSentence();
        Assertions.assertEquals("This is regular.", sentence);
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_theSecondSentence_SHOULD_returnRightFormattedString() {
        String sentence = with1Regular1Question1Exclamation.getAllSentences().get(1).getSentence();
        Assertions.assertEquals("Another one?", sentence);
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_theThirdSentence_SHOULD_returnRightFormattedString() {
        String sentence = with1Regular1Question1Exclamation.getAllSentences().get(2).getSentence();
        Assertions.assertEquals("Stopping with this!", sentence);
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_theWordsInFirstSentence_SHOULD_haveSize4() {
        ArrayList<Word> words = with1Regular1Question1Exclamation.getAllSentences().get(0).getWords();
        Assertions.assertEquals(4, words.size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_theWordsInSecondSentence_SHOULD_haveSize2() {
        ArrayList<Word> words = with1Regular1Question1Exclamation.getAllSentences().get(1).getWords();
        Assertions.assertEquals(2, words.size());
    }

    @Test void GIVEN_with1Regular1Question1Exclamation_theWordsInThirdSentence_SHOULD_haveSize3() {
        ArrayList<Word> words = with1Regular1Question1Exclamation.getAllSentences().get(2).getWords();
        Assertions.assertEquals(3, words.size());
    }

    @Test void parsingInputStartingWithANonWord_SHOULD_THROW_EXCEPTION() {
        DocumentParser parser = new DocumentParser();
        Assertions.assertThrows(Exception.class, () -> parser.parse(". a"));
    }

    @Test void parsingInputWithoutWordsBetweenSentenceMarkers_SHOULD_THROW_EXCEPTION() {
        DocumentParser parser = new DocumentParser();
        Assertions.assertThrows(Exception.class, () -> parser.parse("a sentence? a true. ! not"));
    }
}

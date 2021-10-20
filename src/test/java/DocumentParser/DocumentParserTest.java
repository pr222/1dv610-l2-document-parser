package DocumentParser;

import org.junit.jupiter.api.*;

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

        parser.parse("");
        empty = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("This  is  regular . Another one. Stopping with this.");
        with3RegularSentences = parser.getParsedDocument();
        parser.resetDocument();

        parser.parse("This is regular. Another one? Stopping with this!");
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
}

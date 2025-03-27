package hw3;

import java.util.*;

/**
 * The {@code tester} class contains test cases to validate input handling logic
 * for questions and answers using {@link QuestionHandler} and {@link AnswerHandler}.
 * It prints test results to the console.
 */
public class tester {
    static int testCount = 0;
    static int passedCount = 0;
    
    /**
     * Default constructor for the tester class.
     */
    public tester() {
        // no-op
    }

    /**
     * Main method to execute standalone validation tests.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AnswerHandler answerHandler = new AnswerHandler();
        QuestionHandler questionHandler = new QuestionHandler();

        System.out.println("Running Standalone Validation Tests\n");

        // Test cases
        runQuestionTest("Valid Input",
                "HW2 User Stories",
                "I am a little confused on HW2. Which user stories should we apply and how do we know which ones follow CRUD?",
                false,
                questionHandler);

        runAnswerTest("Short Answer", "Nope", true, answerHandler);

        runQuestionTest("Long Title", "A".repeat(101), "Valid question?", true, questionHandler);
        runQuestionTest("Empty Question", "HW2 User Stories", "", true, questionHandler);
        runQuestionTest("Special Characters", "Test#Title';", "Some; *content'", false, questionHandler);

        System.out.println("\nTest Results:");
        System.out.println("Total Tests: " + testCount);
        System.out.println("Passed: " + passedCount);
        System.out.println("Failed: " + (testCount - passedCount));
    }

    /**
     * Runs a test for validating an answer.
     *
     * @param testName   the name of the test
     * @param input      the answer input
     * @param expectError whether an error is expected
     * @param handler    the {@link AnswerHandler} to use
     */
    private static void runAnswerTest(String testName, String input, boolean expectError, AnswerHandler handler) {
        testCount++;
        List<String> errors = handler.validateAnswer(input);
        boolean passed = (expectError == !errors.isEmpty());

        System.out.println("Test #" + testCount + ": " + testName);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Expected Error: " + expectError);
        System.out.println("Validation Errors: " + (errors.isEmpty() ? "None" : String.join(", ", errors)));
        System.out.println("Result: " + (passed ? "PASSED" : "FAILED"));
        System.out.println("----------------------------------------");

        if (passed) passedCount++;
    }

    /**
     * Runs a test for validating a question.
     *
     * @param testName   the name of the test
     * @param title      the question title
     * @param question   the question content
     * @param expectError whether an error is expected
     * @param handler    the {@link QuestionHandler} to use
     */
    private static void runQuestionTest(String testName, String title, String question, boolean expectError, QuestionHandler handler) {
        testCount++;
        List<String> errors = handler.validateQuestion(title, question);
        boolean passed = (expectError == !errors.isEmpty());

        System.out.println("Test #" + testCount + ": " + testName);
        System.out.println("Title: \"" + title + "\"");
        System.out.println("Question: \"" + question + "\"");
        System.out.println("Expected Error: " + expectError);
        System.out.println("Validation Errors: " + (errors.isEmpty() ? "None" : String.join(", ", errors)));
        System.out.println("Result: " + (passed ? "PASSED" : "FAILED"));
        System.out.println("----------------------------------------");

        if (passed) passedCount++;
    }
}

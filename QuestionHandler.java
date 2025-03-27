package hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code QuestionHandler} class provides validation logic for questions.
 * <p>
 * A question must have a non-empty title (max 100 characters) and a non-empty
 * question body of at least 5 characters.
 */
public class QuestionHandler {
	
	/**
     * Default constructor for the QuestionHandler class.
     */
    public QuestionHandler() {
        // no-op
    }

    /**
     * Validates a question's title and content.
     *
     * @param title    the title of the question
     * @param question the content of the question
     * @return a list of validation error messages
     */
    public List<String> validateQuestion(String title, String question) {
        List<String> errors = new ArrayList<>();

        if (title == null || title.trim().isEmpty()) {
            errors.add("Title cannot be empty.");
        } else if (title.length() > 100) {
            errors.add("Title cannot exceed 100 characters.");
        }

        if (question == null || question.trim().isEmpty()) {
            errors.add("Question content cannot be empty.");
        } else if (question.trim().length() < 5) {
            errors.add("Question must be at least 5 characters long.");
        }

        return errors;
    }
}

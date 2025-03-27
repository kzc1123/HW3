package hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code AnswerHandler} class provides validation logic for answers.
 * <p>
 * An answer must be non-empty and at least 5 characters long.
 */
public class AnswerHandler {
	
	/**
     * Default constructor for the AnswerHandler class.
     */
    public AnswerHandler() {
        // no-op
    }

    /**
     * Validates the given answer string.
     *
     * @param answer the answer to validate
     * @return a list of validation error messages
     */
    public List<String> validateAnswer(String answer) {
        List<String> errors = new ArrayList<>();

        if (answer == null || answer.trim().isEmpty()) {
            errors.add("Answer cannot be empty.");
        } else if (answer.trim().length() < 5) {
            errors.add("Answer must be at least 5 characters long.");
        }

        return errors;
    }
}

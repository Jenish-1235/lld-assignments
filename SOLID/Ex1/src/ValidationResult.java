import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final boolean success;
    private final List<String> errors;

    public static ValidationResult ok() {
        return new ValidationResult(true, Collections.emptyList());
    }

    public static ValidationResult fail(List<String> errors) {
        return new ValidationResult(false, Collections.unmodifiableList(new ArrayList<>(errors)));
    }

    private ValidationResult(boolean success, List<String> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getErrors() {
        return errors;
    }
}

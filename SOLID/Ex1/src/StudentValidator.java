import java.util.ArrayList;
import java.util.List;

public class StudentValidator {

    public ValidationResult validate(RawStudentData data) {
        List<String> errors = new ArrayList<>();
        if (data.name.isBlank())
            errors.add("name is required");
        if (data.email.isBlank() || !data.email.contains("@"))
            errors.add("email is invalid");
        if (data.phone.isBlank() || !data.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");
        if (!(data.program.equals("CSE") || data.program.equals("AI") || data.program.equals("SWE")))
            errors.add("program is invalid");

        if (errors.isEmpty())
            return ValidationResult.ok();
        return ValidationResult.fail(errors);
    }
}

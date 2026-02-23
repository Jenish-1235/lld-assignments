import java.util.Collections;
import java.util.List;

public class CgrRule implements EligibilityRule {
    @Override
    public List<String> reasons(StudentProfile s) {
        if (s.cgr < 8.0) {
            return List.of("CGR below 8.0");
        }
        return Collections.emptyList();
    }
}

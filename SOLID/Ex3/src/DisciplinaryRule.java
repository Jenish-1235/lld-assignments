import java.util.Collections;
import java.util.List;

public class DisciplinaryRule implements EligibilityRule {
    @Override
    public List<String> reasons(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return List.of("disciplinary flag present");
        }
        return Collections.emptyList();
    }
}

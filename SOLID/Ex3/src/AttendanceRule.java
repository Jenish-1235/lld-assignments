import java.util.Collections;
import java.util.List;

public class AttendanceRule implements EligibilityRule {
    @Override
    public List<String> reasons(StudentProfile s) {
        if (s.attendancePct < 75) {
            return List.of("attendance below 75");
        }
        return Collections.emptyList();
    }
}

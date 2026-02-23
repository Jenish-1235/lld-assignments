import java.util.List;

/**
 * Abstraction for persisting student records. Onboarding flow depends on this,
 * not FakeDb.
 */
public interface StudentStore {
    void save(StudentRecord r);

    int count();

    List<StudentRecord> all();
}

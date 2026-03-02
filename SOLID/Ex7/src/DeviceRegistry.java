import java.util.*;

public class DeviceRegistry {
    private final List<SmartClassroomDevice> devices = new ArrayList<>();

    public void add(SmartClassroomDevice d) {
        devices.add(d);
    }

    public <T> T getFirstCapable(Class<T> cap) {
        for (SmartClassroomDevice d : devices) {
            if (cap.isInstance(d))
                return cap.cast(d);
        }
        throw new IllegalStateException("No device with capability: " + cap.getSimpleName());
    }

    public <T> List<T> getAllCapable(Class<T> cap) {
        List<T> result = new ArrayList<>();
        for (SmartClassroomDevice d : devices) {
            if (cap.isInstance(d))
                result.add(cap.cast(d));
        }
        return result;
    }
}

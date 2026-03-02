public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {
        Powerable projector = reg.getFirstCapable(Powerable.class);
        projector.powerOn();
        reg.getFirstCapable(InputConnectable.class).connectInput("HDMI-1");

        reg.getFirstCapable(Dimmable.class).setBrightness(60);

        reg.getFirstCapable(Thermostat.class).setTemperatureC(24);

        System.out.println(
                "Attendance scanned: present=" + reg.getFirstCapable(AttendanceCapable.class).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (Powerable p : reg.getAllCapable(Powerable.class)) {
            p.powerOff();
        }
    }
}

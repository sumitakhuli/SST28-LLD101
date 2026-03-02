public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        // We still fetch specific devices but interact via minimal interfaces
        Powerable pjPower = (Powerable) reg.getFirstOfType("Projector");
        pjPower.powerOn();
        ((InputSwitchable) pjPower).connectInput("HDMI-1");

        BrightnessAdjustable lights = (BrightnessAdjustable) reg.getFirstOfType("LightsPanel");
        lights.setBrightness(60);

        TemperatureControllable ac = (TemperatureControllable) reg.getFirstOfType("AirConditioner");
        ac.setTemperatureC(24);

        SmartAttendanceScanner scan = (SmartAttendanceScanner) reg.getFirstOfType("AttendanceScanner");
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((Powerable) reg.getFirstOfType("Projector")).powerOff();
        ((Powerable) reg.getFirstOfType("LightsPanel")).powerOff();
        ((Powerable) reg.getFirstOfType("AirConditioner")).powerOff();
    }
}

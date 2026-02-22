public class ConsolePreview {
    public void printResult(String channel, SendResult r) {
        if (!r.ok) System.out.println(channel + " ERROR: " + r.message);
    }
}

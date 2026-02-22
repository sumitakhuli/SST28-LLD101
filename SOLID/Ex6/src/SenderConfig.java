class SendResult {
    public final boolean ok;
    public final String message;

    private SendResult(boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }

    public static SendResult success() { return new SendResult(true, null); }
    public static SendResult error(String message) { return new SendResult(false, message); }
}

public class SenderConfig {
    public int maxLen = 160;
}

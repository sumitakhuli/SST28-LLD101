public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final boolean ok;
    public final String message;

    private ExportResult(String contentType, byte[] bytes, boolean ok, String message) {
        this.contentType = contentType;
        this.bytes       = bytes;
        this.ok          = ok;
        this.message     = message;
    }

    public static ExportResult success(String contentType, byte[] bytes) {
        return new ExportResult(contentType, bytes, true, null);
    }

    public static ExportResult error(String message) {
        return new ExportResult(null, new byte[0], false, message);
    }
}

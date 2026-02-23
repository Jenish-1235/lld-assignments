public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final String errorMessage;

    public ExportResult(String contentType, byte[] bytes) {
        this(contentType, bytes != null ? bytes : new byte[0], null);
    }

    public ExportResult(String contentType, byte[] bytes, String errorMessage) {
        this.contentType = contentType;
        this.bytes = bytes != null ? bytes : new byte[0];
        this.errorMessage = errorMessage;
    }
}

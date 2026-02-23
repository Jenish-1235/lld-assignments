import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("req is required");
        }
        String titleEscaped = escapeCsvField(req.title != null ? req.title : "");
        String bodyEscaped = escapeCsvField(req.body != null ? req.body : "");
        String csv = "title,body\n" + titleEscaped + "," + bodyEscaped + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private static String escapeCsvField(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}

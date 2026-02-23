/**
 * Formats invoice data into exact invoice text. Single responsibility.
 */
public class InvoiceFormatter {

    public String format(InvoiceData data) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(data.invId).append("\n");
        for (LineItemDisplay line : data.lineItems) {
            out.append(String.format("- %s x%d = %.2f\n", line.name, line.qty, line.lineTotal));
        }
        out.append(String.format("Subtotal: %.2f\n", data.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", data.taxPct, data.tax));
        out.append(String.format("Discount: -%.2f\n", data.discount));
        out.append(String.format("TOTAL: %.2f\n", data.total));
        return out.toString();
    }
}

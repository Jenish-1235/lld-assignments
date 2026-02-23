import java.util.List;

/**
 * Structured bill data for formatting and persistence. No formatting logic.
 */
public class InvoiceData {
    public final String invId;
    public final List<LineItemDisplay> lineItems;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public InvoiceData(String invId, List<LineItemDisplay> lineItems, double subtotal,
            double taxPct, double tax, double discount, double total) {
        this.invId = invId;
        this.lineItems = lineItems;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}

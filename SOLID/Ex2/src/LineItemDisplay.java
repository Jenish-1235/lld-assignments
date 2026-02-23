/**
 * One line on the invoice: item name, qty, line total.
 */
public class LineItemDisplay {
    public final String name;
    public final int qty;
    public final double lineTotal;

    public LineItemDisplay(String name, int qty, double lineTotal) {
        this.name = name;
        this.qty = qty;
        this.lineTotal = lineTotal;
    }
}

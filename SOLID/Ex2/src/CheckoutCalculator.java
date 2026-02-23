import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Computes subtotal, tax, discount, total. No formatting or IO.
 */
public class CheckoutCalculator {
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;

    public CheckoutCalculator(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public InvoiceData calculate(String invId, Map<String, MenuItem> menu, List<OrderLine> lines, String customerType) {
        List<LineItemDisplay> lineItems = new ArrayList<>();
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineItems.add(new LineItemDisplay(item.name, l.qty, lineTotal));
        }

        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        return new InvoiceData(invId, lineItems, subtotal, taxPct, tax, discount, total);
    }
}

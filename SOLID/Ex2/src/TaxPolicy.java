/**
 * Abstraction for tax rules. New rules can be added without editing a big
 * method.
 */
public interface TaxPolicy {
    double taxPercent(String customerType);
}

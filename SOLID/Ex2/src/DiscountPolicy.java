/**
 * Abstraction for discount rules. New discounts can be added without editing a
 * long method.
 */
public interface DiscountPolicy {
    double discountAmount(String customerType, double subtotal, int lineCount);
}

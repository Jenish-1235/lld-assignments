import java.util.EnumMap;
import java.util.Map;

public class DefaultAddOnPricer implements AddOnPricer {
    private final Map<AddOn, Double> priceByAddOn;

    public DefaultAddOnPricer(Map<AddOn, Double> priceByAddOn) {
        this.priceByAddOn = new EnumMap<>(priceByAddOn);
    }

    @Override
    public Money price(AddOn addOn) {
        double amount = priceByAddOn.getOrDefault(addOn, 0.0);
        return new Money(amount);
    }
}

import java.util.Map;

public class DefaultRoomPricer implements RoomPricer {
    private final Map<Integer, Double> priceByRoomType;

    public DefaultRoomPricer(Map<Integer, Double> priceByRoomType) {
        this.priceByRoomType = priceByRoomType;
    }

    @Override
    public Money baseMonthly(int roomType) {
        double base = priceByRoomType.getOrDefault(roomType, 16000.0);
        return new Money(base);
    }
}

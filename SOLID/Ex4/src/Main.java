import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        Map<Integer, Double> roomPrices = Map.of(
                LegacyRoomTypes.SINGLE, 14000.0,
                LegacyRoomTypes.DOUBLE, 15000.0,
                LegacyRoomTypes.TRIPLE, 12000.0,
                LegacyRoomTypes.DELUXE, 16000.0);
        Map<AddOn, Double> addOnPrices = Map.of(
                AddOn.MESS, 1000.0,
                AddOn.LAUNDRY, 500.0,
                AddOn.GYM, 300.0);
        RoomPricer roomPricer = new DefaultRoomPricer(roomPrices);
        AddOnPricer addOnPricer = new DefaultAddOnPricer(addOnPrices);
        BookingRepo repo = new FakeBookingRepo();
        HostelFeeCalculator calc = new HostelFeeCalculator(roomPricer, addOnPricer, repo);

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        calc.process(req);
    }
}

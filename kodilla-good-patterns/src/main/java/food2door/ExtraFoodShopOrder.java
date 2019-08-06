package food2door;

import java.time.LocalDateTime;

public class ExtraFoodShopOrder implements OrderService {
    @Override
    public boolean process(User user, LocalDateTime orderDate, Shop shop) {
        System.out.println("Extra 25% off coffee");
        return true;
    }
}

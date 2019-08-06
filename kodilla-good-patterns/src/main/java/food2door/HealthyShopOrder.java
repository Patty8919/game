package food2door;

import java.time.LocalDateTime;

public class HealthyShopOrder implements OrderService {
    @Override
    public boolean process(User user, LocalDateTime orderDate, Shop shop) {
        return true;
    }
}

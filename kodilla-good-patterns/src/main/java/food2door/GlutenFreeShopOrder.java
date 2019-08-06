package food2door;

import java.time.LocalDateTime;

public class GlutenFreeShopOrder implements OrderService {
    @Override
    public boolean process(User user, LocalDateTime orderDate, Shop shop) {
        System.out.println("Take 3, pay for 2");
        return true;
    }
}

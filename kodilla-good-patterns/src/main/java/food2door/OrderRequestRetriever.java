package food2door;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jan", "Nowak");
        Shop shop = new Shop("ExtraFoodShopOrder", 3, "Coffee");

        LocalDateTime orderDate = LocalDateTime.of(2019,8,6,17,01);

        return new OrderRequest(user, orderDate, shop);
    }
}

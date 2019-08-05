package challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User ("Jan", "Nowak");
        LocalDateTime orderDate = LocalDateTime.of(2019,8,5,22,25);

        return new OrderRequest(user, orderDate);
    }
}

package challenges;

import java.time.LocalDateTime;

public class BookOrderRespository implements OrderRepository {

    @Override
    public boolean create(User user, LocalDateTime orderDate) {
        return true;
    }

    @Override
    public boolean create(org.apache.catalina.User user, LocalDateTime orderDate) {
        return true;
    }
}

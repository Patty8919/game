package challenges;

import java.time.LocalDateTime;

public interface OrderRepository {
    boolean create (User user, LocalDateTime orderDate);

    boolean create(org.apache.catalina.User user, LocalDateTime orderDate);
}

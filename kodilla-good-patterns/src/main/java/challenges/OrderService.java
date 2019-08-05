package challenges;


import java.time.LocalDateTime;

public interface OrderService {
    boolean order (User user, LocalDateTime orderDate);
}

package food2door;
import java.time.LocalDateTime;

public interface OrderService {
    boolean process(User user, LocalDateTime orderDate, Shop shop);
}

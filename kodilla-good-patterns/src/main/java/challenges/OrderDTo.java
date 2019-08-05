package challenges;


public class OrderDTo {
    public User user;
    public boolean isOrdered;

    public OrderDTo(User user, boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}

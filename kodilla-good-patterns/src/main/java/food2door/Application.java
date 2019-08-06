package food2door;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new GlutenFreeShopOrder());

        productOrderService.order(orderRequest);
    }
}

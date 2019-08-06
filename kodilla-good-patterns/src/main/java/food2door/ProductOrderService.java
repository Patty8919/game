package food2door;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;

    public ProductOrderService (final InformationService informationService,
                                final OrderService orderService) {
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDto order (final OrderRequest orderRequest) {
        boolean isOrdered = orderService.process(orderRequest.getUser(), orderRequest.getOrderDate(),
                orderRequest.getShop());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}

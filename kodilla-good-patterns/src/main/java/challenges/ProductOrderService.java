package challenges;


    public class ProductOrderService {
        private InformationService informationService;
        private OrderService orderService;
        private OrderRepository orderRepository;

        public ProductOrderService(final InformationService informationService,
                                   final OrderService orderService,
                                   final OrderRepository orderRepository) {
            this.informationService = informationService;
            this.orderService = orderService;
            this.orderRepository = orderRepository;
        }

        public OrderDTo process(final OrderRequest orderRequest) {
            boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrderDate());

            if(isOrdered) {
                informationService.inform(orderRequest.getUser());
                orderRepository.create(orderRequest.getUser(), orderRequest.getOrderDate());
                return new OrderDTo(orderRequest.getUser(), true);
            } else {
                return new OrderDTo(orderRequest.getUser(), false);
            }
        }
    }


package hello.core.order;

public interface OrderService {

    // 회원id, 상품명, 상품가격
    Order createOrder(Long memberId, String itemName, int itemPrice);

}

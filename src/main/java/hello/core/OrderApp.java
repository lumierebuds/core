package hello.core;


import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        // AppConfig 사용: 객체 생성이후 메서드를 통해 객체를 반환받아서 사용한다.
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L,"Kim", Grade.VIP);
        memberService.join(member);

        Long id = 1L;
        Order newOrder = orderService.createOrder(id,"우유",10000 );

        System.out.println("order= "+newOrder);
        System.out.println("calculated_price= "+newOrder.calculatePrice());

    }
}

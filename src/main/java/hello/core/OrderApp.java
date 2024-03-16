package hello.core;


import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L,"Kim", Grade.VIP);
        memberService.join(member);

        Long id = 1L;
        Order newOrder = orderService.createOrder(id,"우유",10000 );

        System.out.println("order= "+newOrder);
        System.out.println("calculated_price= "+newOrder.calculatePrice());

    }
}

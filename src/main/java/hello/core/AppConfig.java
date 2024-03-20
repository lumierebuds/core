package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

import java.nio.file.FileStore;

// AppConfig: 애플리케이션 전체에 적용하는 설정에 해당한다.
public class AppConfig {

    public MemberService memberService(){
        // 생성자 주입: 생성자를 통해 생성된 객체가 들어간다해서 불리는 용어
        return new MemberServiceImpl(memberRepository());
    }


    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상 금액
    */

    // 꿀팁: F2를 누르면 오류가 난곳 위치로 이동한다.
    int discount(Member member, int price);
}

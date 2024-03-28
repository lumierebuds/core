package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자 10000원 주문
        int priceA =  statefulService1.order("userA",10000);
        // ThreadB: B 사용자 20000원 주문 (A가 주문을 한 사이에 B가 주문을 했다.)
        int priceB = statefulService2.order("userB",20000);

        // ThreadA: 사용자A 주문 금액 조회 - ThreadB로 인해 값이 A가 주문한 금액이 변경되었다.
        System.out.println("price = "+priceA);

        Assertions.assertThat(priceA).isNotEqualTo(priceB);


    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}
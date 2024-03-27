package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){

        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈 이름을 가져오기

        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ // 스프링에 사용자가 등록했던 빈만 출력
                System.out.println("beanDefinitionName = " +beanDefinitionName +
                        " beanDefinition = " + beanDefinition);
            }
        }
    }
}

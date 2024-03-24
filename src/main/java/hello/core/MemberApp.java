package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // AppConfig 사용: 객체 생성이후 메서드를 통해 객체를 반환받아서 사용한다.
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // ApplicationContext: 스프링이 시작하는 코드
        // AppConfig 클래스에 존재하는 환경설정정보를 가지고 스프링 컨에 집어 넣어 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 환경설정 파일에 존재하는 메서드, 반환 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member: "+member.getName());
        System.out.println("find member: "+findMember.getName());
    }
}

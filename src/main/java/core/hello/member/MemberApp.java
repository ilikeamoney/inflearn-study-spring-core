package core.hello.member;

import core.hello.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        Member member1 = new Member(1L, "member1", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);

        System.out.println("member1 = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}

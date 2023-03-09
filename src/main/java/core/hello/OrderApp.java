package core.hello;

import core.hello.discount.DiscountPolicy;
import core.hello.member.Grade;
import core.hello.member.Member;
import core.hello.member.MemberService;
import core.hello.order.Order;
import core.hello.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        Long memberId = 1L;

        Member memberA = new Member(memberId, "MemberA", Grade.VIP);

        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("itemA = " + order);
    }
}

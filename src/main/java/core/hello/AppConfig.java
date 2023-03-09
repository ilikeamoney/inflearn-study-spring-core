package core.hello;

import core.hello.discount.DiscountPolicy;
import core.hello.discount.RateDiscountPolicy;
import core.hello.member.MemberRepository;
import core.hello.member.MemberService;
import core.hello.member.MemberServiceImpl;
import core.hello.member.MemoryMemberRepository;
import core.hello.order.OrderService;
import core.hello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig  {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

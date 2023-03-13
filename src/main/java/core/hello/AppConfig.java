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

// 의존관계(DI) 주입 방법

// (이 방법을 사용해야 한다.)
// 스프링 컨테이너 초기화시 생성자 주입이 가장 먼저 실행 된다.
// 1. 생성자 주입 (특징)
// 생성자 호출시점에서 딱 1번만 호출되는것이 보장
// 불변, 필수 의존관계에서 사용
// 스프링 빈인데 생성자가 한개라면 AutoWired 애너테이션을 사용하지 않아도 된다.

// 2. 수정자 주입 (특징)
// 선택, 변경 가능성이 있는 의존관계에서 사용가능
// 자바빈 프로퍼티 규약의 수정자 메서드를 사용하는 방식

// 3. 필드 주입 (특징)
// 코드가 간결해서 많은 개발자들을 유혹하지만 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인 단점이 있다.
// DI 프레임워크 없으면 아무것도 할 수 없다.
// 사용하지 말자.
// 애플리케이션 실제 코드와 관계 없는 테스트 코드
// 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별히 사용

// 4. 일반 메서드 주입 (특징)
// 한번에 여러 필드를 주입 받을 수 있다.
// 일반적으로 잘 사용하지 않는다.


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

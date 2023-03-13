package core.hello.order;

import core.hello.annotation.MainDiscountPolicy;
import core.hello.discount.DiscountPolicy;
import core.hello.member.Member;
import core.hello.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component

// Lombok 은 자바 언어에 편리한 생략 기능들을 제공한다.
// 꼭 숙지하자.
// Lombok 이 제공하는 RequiredArgsConstructor 애너태이션을 사용하면
// final 이 붙은 필드를 모아서 자동으로 생성자를 만들어 준다.

// @AutoWired 매칭 정보
// 1. 타입 매칭
// 2. 타입 매칭의 결과가 2개 이상이면 필드명, 파라미터명으로 빈 이름 매칭

// @Qualifier 매칭 정
// @Qualifier 애너테이션 붙은 것들 끼리 매칭한다.
// 없으면 빈 이름으로 매칭
// @Qualifier 애너테이션은 여러군데 막 남방 하지말고
// 명확하게 한곳에만 쓰자.

// Primary
// @Primary 애너테이션을 붙이면 기본으로 빈에 등록이 된다.

// 우선순위 Qualifier > Primary
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

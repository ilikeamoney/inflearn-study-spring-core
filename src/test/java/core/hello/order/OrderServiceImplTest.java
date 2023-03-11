package core.hello.order;

import core.hello.discount.RateDiscountPolicy;
import core.hello.member.Grade;
import core.hello.member.Member;
import core.hello.member.MemberServiceImpl;
import core.hello.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {

        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        Order member = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(member.getDiscountPrice()).isEqualTo(1000);
    }

}
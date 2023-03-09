package core.hello.discount;

import core.hello.member.Grade;
import core.hello.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member memberVIP = new Member(1L, "MemberVIP", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(memberVIP, 10000);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {

        // given
        Member memberB = new Member(2L, "memberB", Grade.BASIC);

        //when

        int discountPrice = discountPolicy.discount(memberB, 90000);

        //then

        assertThat(discountPrice).isEqualTo(0);
    }

}
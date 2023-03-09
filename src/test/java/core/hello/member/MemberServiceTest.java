package core.hello.member;

import core.hello.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }


    @Test
    void join() {

        //given

        Member member1 = new Member(1L, "MemberA", Grade.VIP);

        //when

        memberService.join(member1);
        Member member2 = memberService.findMember(1L);

        //then

        Assertions.assertThat(member1).isEqualTo(member2);
    }
}

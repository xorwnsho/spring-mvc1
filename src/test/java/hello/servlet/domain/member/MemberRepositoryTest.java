package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member hello1 = new Member("hello1", 20);
        Member hello2 = new Member("hello2", 21);

        memberRepository.save(hello1);
        memberRepository.save(hello2);

        //when
        List<Member> findMembers = memberRepository.findAll();

        //then

        assertThat(findMembers.size()).isEqualTo(2);
        assertThat(findMembers).contains(hello1, hello2);

    }
}
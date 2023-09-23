package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // 정적 임포트를 통해 실행한다면 클래스 이름을 생략 가능하다

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 끝나는다음 실행 하는걸 명시하는 어노테이션
    public void afterEach() {
        repository.clearStore(); // 테스트가 끝날떄마다 클리어 스토어 메서드를 작동한다.
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member(); // member1 객체를 선언한다.
        member1.setName("spring1"); // member1 객체의 이름을 spring이라고 설정한다
        repository.save(member1); // membr1 객체를 데이터 베이스에 저장한다

        Member member2 = new Member(); // 아까전 위랑 똑같이 member2를 데이터베이스에 저장한다
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); // spring1  이름을 가져온다

        assertThat(result).isEqualTo(member1); // 맴버1 객체에 값이 있는지 확인한다.
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); // 이름의 계수(사이즈) 는 2게인가
    }
}

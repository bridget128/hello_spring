package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장한다.
    Optional<Member> findById(Long id); //id로 회원을 찾는다
    Optional<Member> findByName(String name); //이름으로 회원찾기
    List<Member> findAll(); //모두찾는다.

}

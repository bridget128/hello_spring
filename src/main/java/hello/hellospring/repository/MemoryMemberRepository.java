package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override // 상속받은 메서드를 재정의 할 때 메서드 이름이 틀리지 않게 쓰기 위한 어노테이션이다 (클래스이 오버라이드랑 같다)
    public Member save(Member member) {
            member.setId(++sequence);
            store.put(member.getId(), member);
            return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

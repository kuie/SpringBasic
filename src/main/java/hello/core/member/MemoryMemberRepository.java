package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //저장소라 map 생성 스프링 입문강의 다시 확인
    //동시성 이슈 발생으로 컨커넌트 해시맵 사용해야함 (여러곳에서 접근해야해서) test용이기에 그냥 넘어감
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
    store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

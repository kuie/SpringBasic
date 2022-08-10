package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


/*
 * 주문 생성 요청이 오면 회원정보 조회, 할인정책 적용 => 이후 주문객체 생성해서 반환
 * 즉, 메모리 회원 리포와 고정금액 할인 정책 구현체로 생성
 * */

public class OrderServiceImpl implements OrderService {

    private  final MemberRepository memberRepository = new MemoryMemberRepository(); //회원찾기
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  //고정 할인 정책

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾기
        int discounyPrice = discountPolicy.discount(member, itemPrice); //할인에 대한건 discountPolicy 너가 알아서 해라 맡기는거임
        return new Order(memberId, itemName,itemPrice,discounyPrice); //order에 새로 담아서 보내주는거임
    }
}

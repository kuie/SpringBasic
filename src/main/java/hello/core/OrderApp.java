package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
memberService.join(member); //멤버 저장 메모리객체 삽입

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order); //tostring 호출됨
        System.out.println("ordercalculatePrice = " + order.calculatePrice());
    }
}

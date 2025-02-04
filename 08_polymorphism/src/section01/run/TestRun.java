package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

/**
 * 다형성 확인 + 기초
 */
public class TestRun {

	public static void main(String[] args) {
		
		// 부모 참조 변수 = 부모 객체
		// -> 양쪽 다 Parent 타입 == 컴퓨터 값 처리 원칙 잘 지켜짐!
		Parent p1 = new Parent();
		
		// p1이 호풀 가능한 메서드
		// - Parent의 메서드 + Object 한테 상속 받은 메서드
		System.out.println("p1.getLastName() : " + p1.getLastName());
		System.out.println("p1.hashCode() : " + p1.hashCode());
		
		System.out.println("----------------------------------------");
		
		// 자식 참조 변수 = 자식 객체
		Child c1 = new Child("신", 500, "붕붕이");
		
		// c1이 호출 가능한 메서드
		// - Child + Object, Parent에게 상속 받은 메서드
		
		System.out.println("c1.getCar() : " + c1.getCar());
		System.out.println("c1.getLastName() : " + c1.getLastName());
		System.out.println("c1.hashCode() : " + c1.hashCode());
		
		/* 다형성 (Polymorphism)
		 * - 하나의 객체가 다양한 객체 형태로 변하는 성질
		 * 
		 * 다형성 - 업캐스팅 (Up Casting)
		 * - 자식 객체의 형태를 부모 객체 형태로 변환
		 * 
		 * - '부모' 참조 변수 = new '자식' 객체;
		 * 	 -> 자식 객체가 부모 객체 형태로 변한 것 처럼 보임 
		 * 
		 */
		
		// 업캐스팅 확인
		// 부모 참조 변수 = 자식 객체 (오류 발생 X)
		// -> 값 처리 원칙 무시한거 아닌가? 어나더!!!
		//  -> 왜 ? 자식 객체 내 부모 객체 부분만 참조하기 때문에!!
		Parent p2 = new Child("김", 9999, "아반떼");
		
		// p2가 호출 가능한 메서드
		// - Parent, Object 메서드만 호출 가능
		// - Child 객체 이지만 Parent로 변경되어
		//   Child 메서드 인식 불가
		System.out.println("p2.getLastName() : " + p2.getLastName());
		System.out.println("p2.hashCode() : " + p2.hashCode());
    //System.out.println(p2.getCar()); 오류가 발생
		
	}
	
}

package section01;

public class Section01Run {
	public static void main(String[] args) {
		// 부모 객체 생성
		Parent p1 = new Parent();
		System.out.println("parent의 toString() : " + p1.toString());
		
		System.out.println("----------------------------------");
		Child1 c1 = new Child1();
		System.out.println("Child1의 toString() : " + c1.toString());
		System.out.println("Child1 만의 필드 laptop : " + c1.getLaptop());
		
		System.out.println("----------------------------------");
		Child2 c2 = new Child2();
		System.out.println("Child2의 toString() : " + c2.toString());
		System.out.println("Child2 만의 필드 Car : " + c2.getCar());
		
		System.out.println("----------------------------------");
		Child3 c3 = new Child3();
		System.out.println("Child3의 toString() : " + c3.toString());
		System.out.println("Child3 만의 필드 BitCoin : " + c3.getBitCoin());
	
		// 자식 객체 생성시 부모 객체도 같이 생성된다
		// *** Parent 객체 생성됨***
		// *** Child3 객체 생성됨***
	}
}

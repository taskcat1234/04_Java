package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		
		// student 기본 생성자를 이용해 객체 생성
		Student std1 = new Student(); 
		System.out.println(std1.toString());
		System.out.println("-------------------------------------------------------");
		
		
		Student std2 = new Student("20250004","맹구");
		System.out.println(std2.toString()); // 학번, 이름
		
		System.out.println("-------------------------------------------------------");
		
		// student 객체의 필드를 모두 초기화 하는 생성자 이용
		Student std3 = new Student("20250005","유리", 45, 55, 65,75);
		System.out.println(std3.toString()); // 학번, 이름, html,css,js,java
		
		System.out.println("-------------------------------------------------------");
		Student std4 = new Student("20250006","수지", 100, 100, 100, 100);
		System.out.println(std4.toString());
	}
}

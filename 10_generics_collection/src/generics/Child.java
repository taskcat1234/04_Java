package generics;

// 객체 생성시 지정되는 타입 T는
// Parent 또는 Parent 상속 관계인 타입만 가능!!
public class Child extends Parent{
	
	private int number;
	
	public Child() {
		// TODO Auto-generated constructor stub
	}
	
	public Child(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / number : " + number;
	}
	
}

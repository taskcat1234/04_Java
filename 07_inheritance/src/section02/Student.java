package section02;

/**
 *  person 클래스를 상송 받은 Student 클래스
 */
public class Student extends Person{
	private String schoolName; // 학교명
	
	/* super() 생성자
	 * - super 
	 * 
	 * - 현재 클래스의 상위 크래스(부모) 생성자를 호출하는 구문
	 * 
	 * - super() 생성자는 반드시
	 * 	 자식 생성자의 첫 번쨰 줄에 작성 되어야 한다!!!
	 *   (미작성 시 컴파일러 자동 추가)
	 *
	 * - 코드 길이 감소, 재사용성 증가 <-- 핵심
	 */
	
	// 기본 생성자
	public Student() {
		super(); // 부모 기본 생성자
		System.out.println("[Student 기본 생성자로 생성됨]");
	}
	
	// 매개 변수가 있는 생성자
	// -> Student가 가지고 있는 
	// 모든 필드(schoolName, name, age) 초기화
	
	// final 로 인한 super 오류 발생 super(name, age); 불가능!
	public Student(String name, int age, String schoolName) {
		super(name, age);
		System.out.println("[Student 매개 변수가 있는 생성자로 생성됨]");
	  // this.name = name; // 부모 필드 직접 접근 불가
    //setName(name);
    //setAge(age);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	/* super 참조 변수(부모 참조 변수)
	 * - 자식 내 부모 객체를 참조하는 변수
	 * - 부모의 필드/메서드에 접근하기 위해 사용
	 * 
	 */
	// 연속으로 재정의
	// Override.toString() -> person.toString() -> Student 로 재정의
	@Override
	public String toString() {
		// super.toString() : 부모의 toString() 메서드 호출
		// -> name : 홍길동 / age : 20
		return super.toString() + " / schoolName : " + schoolName;
//		return String.format(
//				"name : %s / age : %d / schoolName : %s",
//				getName(),getAge(),schoolName);
	}
	/* Person.introduce() 메서드 오버라이딩(재정의)
	 * 
	 */
	
	/* 오버라이딩 성립 조건
	 * [변경 불가]
	 * - 반환형
	 * - 메서드명
	 * - 매개변수(개수,순서,타입)
	 * 
	 * [변경 가능]
	 * - 접근 제어자 (기존 -> 넓은 범위)
	 * - 예외처리 (기존 -> 좁은 범위)
	 * 
	 */
	
	// Person.introduce()를 final 메서드로 변경한 경우
	// Cannot override the final method from Person
	@Override
	public String introduce(String alias) {
		return String.format(
				"[Student가 재정의] 내 이름은 %s, %s 이죠!",
				super.getName(), alias);
	}
	
}

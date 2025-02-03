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
	
	public String toString() {
		return String.format(
				"name : %s / age : %d / schoolName : %s",
				getName(),getAge(),schoolName);
	}
	
}

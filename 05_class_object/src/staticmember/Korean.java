package staticmember;

public class Korean {
	
	/* static (정적인, 고정된)
	 * - 고정된 영역(static 메모리 영역)에
	 *   모든 객체가 공유할 멤버(필드/메서드)를 생성해서 공유
	 *   
	 * - static이 붙은 멤버는
	 * 	 [프로그램 실행 시] static 영역에 할당되고
	 * 	 [프로그램 종료 시] 사라지게 된다
	 */
	
	public static int nationalCode = 82; // 국가 코드
	private String name; // 이름
	private String id;   // 주민등록번호
	
	/* 기본 생성자 */
	public Korean() {} // 클래스에 생성자가 없을 경우 컴파일러가 해당 방식으로 추가해줌
	
	/* 매개 변수가 있는 생성자 */
	public Korean(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	// 필드 간접 접근 메서드 (getter/setter)
	public String getName() {
		return name;
	}
	public void getName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void getId(String id) {
		this.id = id;
	}
	public int getNationalCode() {
		return nationalCode;
	}
	public void getNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}
	
	//
	public String toString() {
		return String.format(
				"이름 : %s / 주민등록번호 : %s / 국가코드 : %d"
				, name, id, nationalCode);
	}
	
	
}

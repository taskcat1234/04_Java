package section02;

import java.io.IOException;

/* throws : 메소드에서 발생한 예외를
 * 					메서드 호출부로 던지는 키워드
 * 
 * [throws 사용 이유]
 * 1) 경고의 의미
 * 		- 특정 메서드 호출 시 예외가 발생할 가능성을 안내
 * 2) 예외 처리를 한 곳에 묶어서 처리하기 위해
 * 		- try-catch가 코드 여기저기 흩어져 있는것은 좋지 않음
 * 			-> 예외를 한 곳에 모아 처리해야 유지보수성 향상
 */

public class ThrowsTest {
	
	public void method1() throws IOException{
		method2();
	// method2에서 throws IOException이 전달되서 넘어옴
	}
	public void method2() throws IOException{
		method3();
		// method3에서 throws IOException이 전달되서 넘어옴
	}
	public void method3() throws IOException{
		// Unhandled exception type IOException
		throw new IOException();
	}
	
	// -----------------------------------------------------------------
	
	/* [ Unchecked Exception ]
	 * - 예외 발생 여부를 확인하지 않아도 되는 예외
	 * 	== 예외 처리 구문(try-catch, throws)을
	 * 		 안써도 되는 예외
	 * 
	 * - RuntimeException의 자식 예외들이 이에 속함
	 * 
	 * [ Checked Exception ]
	 * - 예외 발생 여부를 꼭 확인해야되는 예외
	 * 	== 예외 처리 구문(try-catch, throws)을
	 * 		 무조건 작성해야 되는 예외
	 * 
	 * - 
	 */
	public void test1() throws IOException {
		// CheckedException 강제 발생
		throw new IOException(); 
		// 컴파일 에러 발생 -> 예외처리 후 에러 해결
	}
	
	// throws 구문을 작성하지 않아도
	// UncheckedException 발생 시 자동으로 호출부로 던짐!!!
	public void test2() {
		// UncheckedException 강제 발생
		// throw new RuntimeException();
		int num = 3/0; // ArithmeticException 발생
		// -> 컴파일 에러 발생 X -> 예외처리가 강제되지 않음
	}
	
	
	
	
	
	
	
	
	
}

package condition.service;

import java.util.Scanner;

/**
 * 기능(예제,연습문제) 제공용 클라스
 */
public class ConditionService {
	
	//필드(field) == 멤버 변수 == 인스턴트 변수
	//- 해당 클래스(객체) 내에서 언재든지, 어디서든지 사용가능한 변수
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1 ~ 10 사이 난수(정수)가
	 * 짝수인지 홀수인지 검사
	 */
	public void method1() {
		
		// Math.random() : 0.0 이상 1.0 미만 난수 발생
		int randomNumber = (int)(Math.random() * 10 + 1);
		
		//2로 나눴을 때 나머지가 0인지 아닌지 결과를 저장
		// == 0 이면 짝수(true), 1이면 홀수(false)
		boolean result = randomNumber % 2 == 0;
		System.out.println("randomNumber : " + randomNumber);
		//조건식 : 결과가 true 또는 false가 되는 식 
		if(result) {  // true인경우
			System.out.println("짝수 입니다.");
		} else {  // false인 경우
			System.out.println("홀수 입니다.");
		}
	}
	
	/**
	 * 나이를 입력 받아 "어린이", "청소년" , "성인" 구분
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 19세 초과 "성인"
	 * </pre>
	 */
	public void method2() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age <= 0) {  //else if 문을 활용해도된다.
			System.out.print("0포함 음수는 입력할수 없습니다.");
		}else {
			if(age > 19 ) {
				System.out.print("성인 입니다.");
			} else {
				if(age > 13) {
					System.out.print("청소년 입니다.");
				}else {
					System.out.print("어린이 입니다.");
				}
			}
		}
	}
	
	/**
	 * 나이를 입력 받아 "어린이", "청소년" , "성인" 구분
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 	- 14~16세 : 청소년(중)
	 * 	- 17~19세 : 청소년(고)
	 * 19세 초과 "성인"
	 * 0 미만 100 이상 "잘못 입력하셨습니다"
	 * </pre>
	 */
	public void method3() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		if(age < 0 || 100 <= age) {
			System.out.print("잘못 입력하셨습니다");
		}else {
			String result =(age <= 13) ? "어린이 입니다" : ((age <=19) ? ((age <=16) ? "청소년(중)" : "청소년(고) 입니다") : "성인 입니다");
			System.out.print(result);
		}
		// result = "청소년" + (age <= 16 ? "(중)":"(고)");
	}
	
	
	// ------------------------------------------------------------------------------------------------------------
	/* swic*/
	/**
	 * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		System.out.println("1.method1()");
		System.out.println("2.method2()");
		System.out.println("3.method3()");
		System.out.println("4.method4()");
		System.out.println("5.method5()");
		System.out.print("메뉴 번호 입력 >>");
		int input = sc.nextInt();
		
		//(중요) 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능!
		switch(input) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		default : System.out.println("없는 메뉴 번호 입니다.");
		}
	
	}
	
	public void method4() {
		System.out.print("이름 : ");
		String v0 = sc.next();
		System.out.print("중간고사 점수(40%) : ");
		int v1 = sc.nextInt();
		System.out.print("기말고사 점수(50%) : ");
		int v2 = sc.nextInt();
		System.out.print("과제(10%) : ");
		int v3 = sc.nextInt();
		if(v1 < 0 || 100 < v1 || v2 < 0 || 100 < v2 || v3 < 0 || 100 < v3) {
			System.out.print("잘못된 값입니다.");
		}else {
			v1 = (v1*40)/100;
			v2 = (v2*50)/100;
			v3 = (v3*10)/100;
			double v4 = v1 + v2 + v3;
			String v5 = "";
			System.out.println("");
			System.out.println(v0 + "의 최종점수 : " + v4);
			if(v4 < 60) {
				v5 = "F";
				System.out.println("성적 : " + v5);
			}else if(v4 < 65) {
				v5 = "D";
				System.out.println("성적 : " + v5);
			}else if(v4 < 70) {
				v5 = "D+";
				System.out.println("성적 : " + v5);
			}else if(v4 < 75) {
				v5 = "C";
				System.out.println("성적 : " + v5);
			}else if(v4 < 80) {
				v5 = "C+";
				System.out.println("성적 : " + v5);
			}else if(v4 < 85) {
				v5 = "B";
				System.out.println("성적 : " + v5);
			}else if(v4 < 90) {
				v5 = "B+";
				System.out.println("성적 : " + v5);
			}else if(v4 < 95) {
				v5 = "A";
				System.out.println("성적 : " + v5);
			}else{
				v5 = "A+";
				System.out.println("성적 : " + v5);
			}
		}
	}
	
//	public void method4() {
//		System.out.print("이름 : ");
//		String name = sc.next();
//		System.out.print("중간고사 점수(40%) : ");
//		int wndrks = sc.nextInt();
//		System.out.print("기말고사 점수(50%) : ");
//		int rlakf = sc.nextInt();
//		System.out.print("과제(10%) : ");
//		int rhkwp = sc.nextInt();
//		if(wndrks < 0 || 100 < wndrks || rlakf < 0 || 100 < rlakf || rhkwp < 0 || 100 < rhkwp) {
//			System.out.print("잘못된 값입니다.");
//		}else {
//			double sum = (wndrks *0.4) + (rlakf * 0.5) + (rhkwp *0.1);
//			String result; // 성적 저장용 변수
//      //자바 지역변수는 초기화 안되면 사용이 불가능
//			switch((int)sum/10) { // 10의 자리 계산 
//				//하나의 case에 여러 경우를 , 기호를 이용해서 작성 가능
//				// (Java만 가능한 기능)
//				case 10, 9  : result = "A"; break;
//				case 8  : result = "B"; break;
//				case 7  : result = "C"; break;
//				case 6  : result = "D"; break;
//				default : result = "F";
//			}
//			// 1의 자리 계산
//			if(sum == 100 || sum >= 60.0 && sum % 10 >= 5) {
//				result += "+";
//			}
//			// 결과 출력
//			System.out.printf("\n%s의 최종점수 : %.1f점\n", name,sum);
//			System.out.println("성적 : " + result);
//		}
//	}
}

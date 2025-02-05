package section03.dto;

/** Calculator 인터페이스 구현체
 * - 모든 인터페이스 구현체는 같은 형태를 띄고 있다!!!
 */

public class LSJCalculator implements Calculator{
	
	@Override
	public int plus(int a, int b) {
		int c = checkNum(a+b);
		return c;
	}

	@Override
	public int minus(int a, int b) {
		int c = checkNum(a-b);
		return c;
	}

	@Override
	public int multi(int a, int b) {
		int c = checkNum(a*b);
		return c;
	}

	@Override
	public double div(int a, int b) { 
		double c = checkNum2(a/b);
		return c;
	}

	@Override
	public int mod(int a, int b) {
		int c = checkNum(a%b);
		return c;
	}

	@Override //거듭제곱
	public int pow(int a, int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // 원의 넓이 반환
	public double areaOfCircle(double r) {
//		int c = checkNum(r*r*PI);
		return 10;
	}

}

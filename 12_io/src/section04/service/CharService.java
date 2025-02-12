package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class CharService {
	
	/* [ 문자 기반 스트림 ]
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * 
	 * - 문자만 작성된 파일(txt,bin 등)
	 * 	 채팅, JSON, 웹 요청(주소)/응답(HTMl)
	 * 
	 * - 문자 기반 스트림 최상위 인터페이스 : Reader(입력), Writer(출력)
	 * 
	 */
	
	public void fileOutput1() {
		FileWriter fw =null;
		
		try {
			String content = """
Come Back Home - 2NE1
(테스트를위한 가사 출력)
One two three
넌 나를 떠났지만
어딘가에서 너의 숨소리가 들려와

또 다시 Four five six
빨간 눈물이 내려와
나를 안던 너의 향기가 그립다

나를 위한 거라 했던 너의 말
거짓말처럼 차갑게 돌아섰던
너는 왜
너는 왜 you’re gone away

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로
Come back home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do

아무 대답 없는 니가 너무 밉지만
가끔은 너도 나를 그리워할까

너 없는 시간 속에 갇혀버린 난
앞을 볼 수가 없어 너무 두려워

아직도 못다한 많은 날들이
기다리고 있을 것만 같아
너는 어디에
어디에 too far away

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로

Come Back Home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do

이곳에 유일하게 남은 거라곤 너의 그림자
외로움보단 그리움이 날 괴롭힌다
손에 잡힐 것만 같은 너의 웃음소리
모래성처럼 힘없이 흩어진 순간들이
매일 밤 가위처럼 날 눌러
꿈속에서조차 네 이름을 또 불러
모든 걸 변하게 하는 시간 앞에도 변하지 않는 건
나는 너의 queen, you’re my ruler

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로

Come Back Home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do
""";
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "컴백홈.txt");
			
			// 문자 기반 스트림을 이용해서 출력하기
			fw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			fw.flush(); // close() 시 자동으로 수행됨
			
			System.out.println("출력 완료!");
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	/** 문자 기반 스트림 + 보조스트림을 이용한 파일 출력*/
	public void fileOutput2() {
		FileWriter fw =null;
		BufferedWriter bw =null; // 버퍼를 이용한 보조 스트림
		
		try {
			String content = """
Come Back Home - 2NE1
(테스트를위한 가사 출력)
One two three
넌 나를 떠났지만
어딘가에서 너의 숨소리가 들려와

또 다시 Four five six
빨간 눈물이 내려와
나를 안던 너의 향기가 그립다

나를 위한 거라 했던 너의 말
거짓말처럼 차갑게 돌아섰던
너는 왜
너는 왜 you’re gone away

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로
Come back home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do

아무 대답 없는 니가 너무 밉지만
가끔은 너도 나를 그리워할까

너 없는 시간 속에 갇혀버린 난
앞을 볼 수가 없어 너무 두려워

아직도 못다한 많은 날들이
기다리고 있을 것만 같아
너는 어디에
어디에 too far away

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로

Come Back Home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do

이곳에 유일하게 남은 거라곤 너의 그림자
외로움보단 그리움이 날 괴롭힌다
손에 잡힐 것만 같은 너의 웃음소리
모래성처럼 힘없이 흩어진 순간들이
매일 밤 가위처럼 날 눌러
꿈속에서조차 네 이름을 또 불러
모든 걸 변하게 하는 시간 앞에도 변하지 않는 건
나는 너의 queen, you’re my ruler

Come Back Home
Can you come back home
차가운 세상 끝에 날 버리지 말고 내 곁으로

Come Back Home
Can you come back home
모든 아픔은 뒤로해
여전히 널 기다려 이렇게
Now you gotta do what you gotta do
""";
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "컴백홈_buffer.txt");
			
			// 보조 스트림 객체 생성
			bw = new BufferedWriter(fw);
			
			// 문자 기반 보조 스트림을 이용해서 출력하기
			bw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			bw.flush(); // close() 시 자동으로 수행됨
			
			System.out.println("출력 완료!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자 기반 입력 스트림 + 보조 스트림 이용해서 파일 읽어오기
	 */
	public void fileInput() {
		
		/* [try - with - resource]
		 * - 자바 7버전(2011년)에서 추가된 기능
		 * - finally에서 작성하던 clise 처리 구문을
		 * 	 자동으로 수행하도록 만드는 구문
		 */
		String path = "io_test/char/컴백홈.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			// 보조 스트림을 이용해서 파일 내용 읽어오기
			StringBuilder sb = new StringBuilder(); //읽어온 내용 누적
			String temp = null; // 임시 변수
			
			while(true) {
				temp = br.readLine(); // 한 줄씩 읽어오기
				if(temp == null) break; // 읽어온 내용이 없으면 반복 종료
				
				sb.append(temp); // 읽어온 내용을 누적(엔터 미포함)
				sb.append("\n"); // 엔터 추가
				
			}
			
			System.out.println("읽어오기 성공!");
			System.out.println("-------------------------------");
			System.out.println(sb.toString());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		// finally에서 close 하던 구문 생략 가능
		
	}
	
	// Scanner 대신 스트림을 이용한 문자열 입력 받기
	// -> Scanner가 편히하긴 한데 매우느림!!
	
	// 키보드 입력 -> 바이트(2진수) 코드 입력 -> 문자 변화
	
	public void KeyboardInput() {
		//System.in : 기본 장치(키보드)와 연결된 InputStream 반환됨
		
		// InputStreamReader : 바이트 스트림 -> 문자 스트림 변환
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("문자열 입력1 : ");
			String input1 = br.readLine(); //입력된 한 줄 읽어오기
			
			System.out.println("문자열 입력2 : ");
			String input2 = br.readLine(); //입력된 한 줄 읽어오기
			
			System.out.println("input1 : " + input1);
			System.out.println("input2 : " + input2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

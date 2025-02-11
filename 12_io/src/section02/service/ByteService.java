package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {

	/* Stream(스트림)
	 * - 데이터가 이동하는 통로 역할의 객체
	 * - 데이터의 흐름은 기본적으로 단방향
	 */
	
	/* [Byte 기반 스트림]
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위 클래스 : InputStream, OutputStream
	 * 
	 * - 입/출력 가능 데이터
	 * 	문자열, 파일(이미지, 영상, 오디오 pdf 등 모든 파일)
	 * 
	 * 	* 단, 2byte 범위 문자열이 깨질 수 있고
	 * 		좁은 통로(1byte)를 이용하다 보니 속도가 상대적으로 느림
	 * 
	 * *********************************************************
	 * Stream 객체는 Java 프로그램이 종료 되어도
	 * 외부 장치/파일/프로그램과의 연결이 유지되기 때문에
	 * 자동으로 사라지지 않는다!!!
	 * 	-> 프로그램 종료 전
	 * 		Stream 객체의 메모리를 반환하는 close() 구문 필수!
	 * *********************************************************
	 */
	
	/**
	 * 지정된 경로에
	 * 파일 생성 + 내용 출력(파일 기반 바이트 스트림 이용)
	 */
	public void fileByteOutput() {
		
		FileOutputStream fos = null;
		
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test/byte"; // 프로젝트폴더 /io_test/byte
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			
			if(folder.exists() == false) {
				folder.mkdirs(); // 폴더 생성
			}
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성
			// -> 이 때, 해당 파일이 없으면 자동으로 생성된다!!
		
			fos = new FileOutputStream(folderPath + "/" + fileName);
			// io_test/byte/바이트기반테스트.txt
			
			// txt 파일에 출력할 내용 작성
			StringBuilder builder = new StringBuilder();
			
			/* StringBuilder : String의 불변성 문제를 해결하기 위한 객체 */
			builder.append("Hello world!!\n");
			builder.append("1234567890\n");
			builder.append("!@#$%^&*\n");
			builder.append("와 완전 어려워요!\n");
			builder.append("자바 너무 재밌어요????\n");
			builder.append("와!\n");
			
			// StringBuilder 에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			/* 연결된 외부 txt파일로 content 내용을 출력 */
			
			// 방법 1) 1byte씩 끊어서 출력
//			for(int i = 0 ; i < content.length() ; i++ ) {
//				char ch = content.charAt(i); // i번째 문자 1개 반환
//				
//				// 바이트 기반 스트림 -> 1바이트 범위만 출력 가능
//				// -> 0~255(바이트 범위) 사이 글자는 정상 출력
//				// 	  이후 글자(한글 등)은 모두 깨져서 출력
//				fos.write(ch); // IOException 발생 가능성 있음
//				
//			}
			
			// 방법 2) String 을 byte로 먼저 변환한 후
			// 				 손실되는 데이터 없이 출력하기
			byte[] bytes = content.getBytes(); // String -> byte[] 형태로 얻어감
			
			fos.write(bytes); // 손실되는 데이터 없이 모든 문자열(byte) 출력
			
			System.out.println("출력완료!");
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) { // NullPointerException 방지
					fos.close(); // IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 보조 스트림 중 BufferedOutputStream을 이용해서
	 * 출력 속도 향상시키기
	 */
	public void bufferedFileByteOutput() {
		
		/* 버퍼(buffer)란?
		 * - 데이터가 모아져있는 메리상의 임시 공간
		 * == 장바구니
		 * -> 한 번에 많은 양의 데이터를 이동 시켜서
		 * 	시간 효율을 좋아지게 만듦
		 * 
		 */
		
		/* 스트림 객체 참조 변수 선언 */
		FileOutputStream fos      = null; // 기반 스트림 (단독 사용 o)
		BufferedOutputStream bos  = null; // 보조 스트림 (단독 사용 x)
		
		try {
			/* 기반 스트림 생성 */
			fos = new FileOutputStream("io_test/byte/버퍼_바이트.txt");
			// -> 파일이 없으면 생성됨
			
			/* 보조 스트림 생성 */
			// 보조 스트림 생성 시 기반 스트림과 연결
			bos = new BufferedOutputStream(fos);
			
			String content =
"""
이제야 목적지를 정했지만

가려한 날 막아서네 난 갈 길이 먼데

새빨간 얼굴로 화를 냈던

친구가 생각나네

이미 난 발걸음을 떼었지만

가려한 날 재촉하네 걷기도 힘든데

새파랗게 겁에 질려 도망간

친구가 뇌에 맴도네

건반처럼 생긴 도로 위 수많은 동그라미들 모두가

멈췄다 굴렀다 말은 잘 들어

그건 나도 문제가 아냐

붉은색 푸른색 그 사이 3초 그 짧은 시간

노란색 빛을 내는 저기 저 신호등이

내 머릿속을 텅 비워버려 내가 빠른지도

느린지도 모르겠어 그저 눈앞이 샛노랄 뿐이야

솔직히 말하자면 차라리

운전대를 못 잡던 어릴 때가 더 좋았었던 것 같아

그땐 함께 온 세상을 거닐 친구가 있었으니

건반처럼 생긴 도로 위 수많은 조명들이 날 빠르게

번갈아 가며 비추고 있지만

난 아직 초짜란 말이야

붉은색 푸른색 그 사이 3초 그 짧은 시간

노란색 빛을 내는 저기 저 신호등이

내 머릿속을 텅 비워버려 내가 빠른지도

느린지도 모르겠어 그저 눈앞이 샛노랄 뿐이야

꼬질꼬질한 사람이나 부자 곁엔 아무도 없는

삼색 조명과 이색 칠 위에 서 있어 괴롭히지 마

붉은색 푸른색 그 사이 3초 그 짧은 시간

노란색 빛을 내는 저기 저 신호등이

내 머릿속을 텅 비워버려 내가 빠른지도

느린지도 모르겠어 그저 눈앞이 샛노랄 뿐이야 
""";
			// 보조 스트림을 이용해 출력
			// -> 내용 출력 시 버퍼를 이용해서 한번에 출력!
			// -> 
			bos.write(content.getBytes());
			System.out.println("출력 완료!");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환
			try {
				if(bos != null) bos.close();
				// 보조 스트림만 close 하면
				// 연결된 기반 스트림도 같이 close 된다
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력(파일 읽어오기) 1
	 */
	public void fileByteInput() {
		FileInputStream fis = null;
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			int value = 0; // 읽어온 1byte를 저장할 임시 변수
			
			// 읽어온 내용 누적용 객체
			StringBuffer sb = new StringBuffer();
			
			while(true) { // 무한 반복
				// int fis.read()
				// - 파일로 부터 1바이트 읽어서 반환
				// - 호출 시 마다 다음 내용을 읽어오게되어있음
				// - 읽어올 내용이 없다면 -1 반환
				value = fis.read();
				if(value == -1) break; // 반복 종료
				sb.append((char)value); // 문자로 변환해서 누적
			}
			System.out.println(sb.toString());
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력2(한글 안깨지게 읽어오기)
	 */
	public void fileByteInput2() {
		FileInputStream fis = null;
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			//byte[] readAllBytes()
			// - 연결된 파일의 내용을 모두 byte로 변환하여 읽어오기
			// - byte[] 형태로 반환됨
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes);
			// byte[]을 String에 그대로 저장
			System.out.println(content);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 보조 스트림(BufferedInputStream)을 이용해서
	 * 효율적으로 파일 읽어오기
	 */
	public void fileByteInput3() {
		FileInputStream fis = null;      // 기반 스트림
		BufferedInputStream bis = null;  // 보조 스트림
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// 보조 스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 보조 스트림을 이용해서
			// 파일 내용 -> 바이트로 변환
			// -> 버퍼를 이용해 한번에 읽어옴 -> byte[]로 반환
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes);
			// byte[]을 String에 그대로 저장
			System.out.println(content);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) bis.close();
				// 보조 스트림만 close해도 연결된 기반 스트림도 close됨
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// -------------------------------------------------------------------------
	
	/** [파일 복사]
	 *	<pre>
	 *	- 복사할 파일의 경로를 입력 받아
	 *		같은 경로에 복사된 파일을 생성
	 *
	 *	- 입력 받은 경로에 파일이 존재하지 않으면
	 *		-> "파일이 존재하지 않습니다" 출력
	 *	- 존재하면
	 *		-> 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 *
	 *	[실행 화면]
	 *	파일 경로 입력 : io_test/byte/노래가사.txt
	 *	복사 완료 : io_test/byte/노래가사_copy.txt
	 *	</pre> 
	 */
	public void fileCopy() {
		// 스캐너, 파일 입출력 스트림, 보조 스트림 참조 변수 선언
		Scanner sc = null;                 // 경로 입력용
		FileInputStream fis = null;        // 입력 기반
		FileOutputStream fos = null;       // 출력 기반
		
		BufferedInputStream bis = null;    // 입력 보조
		BufferedOutputStream bos = null;   // 출력 보조
		
		try {
			sc = new Scanner(System.in);
			// 1) 파일 경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String path = sc.nextLine();
			
			// 2) 입력받은 경로의 파일과 FileinputStream 연결하기
			fis = new FileInputStream(path);
			// -> path에 파일이 없다면
			// 	  filenotfoundexception 발생! -> catch에서 처리
			
			// 3) 보조 입력용 스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 4) 연결된 파일을 byte[] 읽어오기
			byte[] bytes = bis.readAllBytes(); // === 읽어온 파일!
			
			// 5) 입력 받은 경로 파일명에 _copy 붙이기
			
			StringBuilder sb = new StringBuilder();
			sb.append(path); // 기존 경로 추가
			
			// 뒤에서부터 검색하여 처음 찾은 "." 위치(index) 반환
			int insertPoint = sb.lastIndexOf(".");
			
			// 찾은 "." 앞에 "_copy" 삽입하기
			sb.insert(insertPoint, "_copy");
			
			// 복사본의 경로
			String copyPath = sb.toString();
			
			// 6) 출력용 기반 스트림 객체 생성
			fos = new FileOutputStream(copyPath);
			
			// 7) 출력용 보조 스트림 객체 생성
			bos = new BufferedOutputStream(fos);
			
			// 8) 보조 스트림을 이용해서 출력하기
			bos.write(bytes); // 읽어온 파일(bytes) 출력하기
			
			System.out.println("복사 완료 : " + copyPath);
			
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 스트림 객체 메모리 반환
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(sc != null) sc.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

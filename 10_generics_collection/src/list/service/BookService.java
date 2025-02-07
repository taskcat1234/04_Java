package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	// 기본 생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000,"창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800,"포레스트북스"));
		bookList.add(new BookDTO("채식주의자", "한강", 15000,"창비"));
		bookList.add(new BookDTO("작별하지 않는다", "한강", 16800,"문학동네"));
		bookList.add(new BookDTO("모순", "양귀자", 13000,"쓰다"));
	}
	
	public List<BookDTO> getBookList() {
		return bookList;
	}
	
	/** 전달 받은 index 번째 bookList 요소 반환
	 * 단, 범위 초과시 null 반환
	 * @param index
	 * @return
	 */
	public BookDTO selectIndex(int index) {
		
		if(checkIndex(index) == false) return null;
		
		return bookList.get(index);
	}
	
	/* 
	 * 전달 받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정상 true, 아니면 false
	 */
	public boolean checkIndex(int index) {
		if(index < 0 || index >= bookList.size()) {
			return false;
		}
		
		return true; // 정상 범위 true
	}
	
	/** 전달 받은 book을 bookList에 추가
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가 X
	 * @param book
	 * @return 추가 0 : true, 추가 X : false
	 */
	public boolean addBook(BookDTO book) {
		
		// 책 정보 비교 방법 1) 필드 값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용

// 방법 1
//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// 방법 2
		// List가 제공하는 contains() (포함하는지 확인) 사용가능
		if(bookList.contains(book)) return false;
		
		return bookList.add(book);
		// 컬렉션은 크기 제한이 없어서 무조건 추가 성공(true 반환)
	}
	
	/** 전달 받은 index 번째 요소의 가격을 newPrice로 수정
	 * 
	 * @param index
	 * @param newPrice
	 * @return "[책제목] 가격이 [이전가격] -> [수정된 가격]으로 수정되었습니다"
	 */
	public String modifyBookPrice2(int index, int InputPrice) {
		BookDTO target = bookList.get(index); // 인덱스번째 요소 얻어오기
		int oldPrice = target.getPrice(); //이전 가격 저장
		target.setPrice(InputPrice); // 새가격으로 수정
		
		return String.format(
				"[%s] 가격이 [%d] -> [%d]으로 수정되었습니다",
				target.getTitle(), oldPrice, InputPrice);
	}
	
	/** index번째 BookDTO 제거
	 * 단, 없으면 null 반환
	 * @param index
	 */
	public BookDTO renoveBook(int index) {
		if(checkIndex(index) == false) return null;
		return bookList.remove(index);
		// bookList에서 index 번째 요소를 제거
		// == index 번째 요소를 뽑아냄
	}
	
	/** 제목이 일치하는 책 반환
	 * @param title : 찾을려는 책 제목
	 */
	public BookDTO selectTitle(String title) {
		for(BookDTO book : bookList) { // bookList에서 하나씩 꺼냄
			if(book.getTitle().equals(title)) { // 꺼낸 책의 제목과 전달 받은 책의 제목이 같을 경우
				return book;
			}
		}
		return null;
	}
	
	public BookDTO removeBookTitle(String title) {
		for(int i = 0; i < bookList.size(); i++) { // bookList에서 하나씩 꺼냄
			BookDTO book = bookList.get(i);
			if(book.getTitle().equals(title)) { // 꺼낸 책의 제목과 전달 받은 책의 제목이 같을 경우
				return bookList.remove(i);
			}
		}
		return null;
		// bookList에서 index 번째 요소를 제거
		// == index 번째 요소를 뽑아냄
	}
	
	/** 저자가 일치하는 책 모두 찾아서 출력
	 * 
	 * @param author
	 * @return
	 */
	public List<BookDTO> selectAuthor(String author) {
		List<BookDTO> books = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) { // bookList에서 하나씩 꺼냄
			if(book.getAuthor().equals(author)) { // 꺼낸 책의 제목과 전달 받은 저자의 제목이 같을 경우				
				books.add(book);
			}
		}
		return books;
	}
	
	/** 출판사가 일치하는 책 모두 출력
	 * 
	 * @param Publisher
	 * @return
	 */
	public List<BookDTO> selectPublisher(String Publisher) {
		List<BookDTO> books = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) { // bookList에서 하나씩 꺼냄
			if(book.getPublisher().equals(Publisher)) { // 꺼낸 책의 제목과 전달 받은 출판사의 제목이 같을 경우				
				books.add(book);
			}
		}
		return books;
	}
	
	/** 저자 또는 출판사 중에 1개라도 맞다면 모두 출력
	 * 
	 * @param authorPublisher
	 * @return
	 */
	public List<BookDTO> searchBook(String authorPublisher) {
		List<BookDTO> books = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) { // bookList에서 하나씩 꺼냄
			if(book.getAuthor().equals(authorPublisher) || book.getPublisher().equals(authorPublisher)) { // 꺼낸 책의 출판사 또는 저자가 1개라도 일치할 경우			
				books.add(book);
			}
		}
		return books;
	}
	
	public void bookListSorting() {
		Collections.sort(bookList);
	}
	
	
}

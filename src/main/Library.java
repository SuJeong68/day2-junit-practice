package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서관 클래스입니다.
 * 
 * @author 이수정
 */
public class Library {
    private int maxBookCount;
    private List<String> booklist;

    public Library(int maxBookCount) {
        if (maxBookCount < 0)
            throw new IllegalArgumentException("음수로는 도서관을 생성할 수 없습니다.");
        this.maxBookCount = maxBookCount;
        this.booklist = new ArrayList<>();
    }

    public void add(String bookName) {
        if (getTotalBookCount() >= maxBookCount)
            throw new MaxBookCountExceedException("도서관 최대 용량을 초과해 책을 추가할 수 없습니다.");
        if (find(bookName))
            throw new IllegalArgumentException("도서관에 같은 이름의 책이 존재합니다.");

        booklist.add(bookName);
    }

    public void delete(String bookName) {
        if (!find(bookName))
            throw new IllegalArgumentException("도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
        booklist.remove(bookName);
    }

    public int getTotalBookCount() {
        return booklist.size();
    }

    public boolean find(String bookName) {
        return booklist.contains(bookName);
    }

}

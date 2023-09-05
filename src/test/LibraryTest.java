package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Library;

/**
 * Library 클래스를 Junit5를 이용해 테스트하는 클래스입니다.
 * 
 * @author 이수정
 */
class LibraryTest {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";

    @ParameterizedTest
    @ValueSource(strings = { "어린왕자", "엄지공주", "샬롯의 거미줄" })
    void addBook(String bookName) {
        Library library = new Library(5);

        library.add(bookName);
    }

    @RepeatedTest(10)
    void negativeLibrary_throwIllegalArgumentException(RepetitionInfo info) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Library(-1 * info.getCurrentRepetition()));
        assertEquals(exception.getMessage(), NEGATIVE_LIBRARY_MESSAGE);
    }
     
    // 더 많은 어노테이션이 궁금하다면?
    // https://junit.org/junit5/docs/current/user-guide/ 를 참고해주세요.
}

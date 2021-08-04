package java_baseball.domain;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
	private Referee referee;
	private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
	
	@BeforeEach
	void setUp () {
		referee = new Referee();
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,3,정답입니다.", "7,8,9,아웃", "3,1,2, 3 볼"})
	public void compare(int num1, int num2, int num3, String expected) { // 예상값
		String actual = referee.compare(ANSWER, Arrays.asList(num1, num2, num3)); // 실제값
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("3 스트라이크 테스트")
	void 스트라이크() {
		String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));
		assertThat(result).isEqualTo("정답입니다.");
	}
	
	@Test
	@DisplayName("스트라이크 , 볼이 하나도 맞지 않는 경우")
	void 아웃() {
		String result = referee.compare(ANSWER, Arrays.asList(7, 8, 9));
		assertThat(result).isEqualTo("아웃");
	}
	
	@Test
	@DisplayName("3볼")
	void 볼() {
		String result = referee.compare(ANSWER, Arrays.asList(3, 1, 2));
		assertThat(result).isEqualTo("3 볼");
	}
}

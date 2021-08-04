package java_baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java_baseball.domain.NumberGenerator;
import java_baseball.domain.Referee;

public class Application {
	public static void main(String [] args) {
		NumberGenerator generator = new NumberGenerator();
		List<Integer> comNum = generator.createRandomNumbers();
		
		Referee referee = new Referee();
		int count = 0;
		while(count < 10) {
			try {
				String result = referee.compare(comNum, askNumbers());
				count++;
				if(count >= 10) {
					System.out.println("게임에 패배하였습니다. 정답은 " + comNum + "입니다.");
				}
				System.out.println("시도 횟수 : " + count);
				System.out.println(result);
			} catch (IllegalArgumentException e) {
				System.out.println("숫자만 입력하세요");
			} catch (Exception e) {
				System.out.println("숫자는 3자리만 입력하세요");
			}
		}
	}
	
	public static List<Integer> askNumbers() throws Exception {
		System.out.print("숫자를 입력해 주세요 : ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.length() != 3) {
			throw new Exception(); 
		}
		String [] value = input.split("");
		List<Integer> player = new ArrayList<>();
		for (String val : value) {
			player.add(Integer.parseInt(val));
		}
		return player;
	}
}

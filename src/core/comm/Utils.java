package core.comm;

import java.util.Arrays;
import java.util.List;

public class Utils {
	/**
	 * list에 value있으면 해당 idx, 없으면 넣고 해당 idx 반환
	 */
	public static int addString(List<String> list, String value) {
		int idx = list.indexOf(value);
		if(idx < 0) {
			idx = list.size();
			list.add(value);
		}
		return idx;
	}
	
	/**
	 * list에 integers있으면 해당 idx, 없으면 넣고 해당 idx 반환
	 */
	public static int addIntegers(List<Integer[]> list, Integer[] integers) {
		for(int i = 0; i < list.size(); i++) {
			if(Arrays.equals(list.get(i), integers)) {
				return i;
			}
		}
		
		list.add(integers);
		return list.size() - 1;
	}
	
	/**
	 * <pre>
	 * n >= 0 숫자를 52진수(알파뱃 대소문자)로 변경
	 * toAlphaString(0)  = "A"
	 * toAlphaString(1)  = "B"
	 * toAlphaString(26) = "a"
	 * toAlphaString(51) = "z"
	 * toAlphaString(52) = "AA"
	 * toAlphaString(53) = "AB"
	 * toAlphaString(Integer.MAX_VALUE)  = "EgjqlX"
	 * </pre>
	 */
	public static String toAlphaString(int n) {
		int s = 0;
		if(n < 52) s = 1; else if(n < 2756) s = 2; else if(n < 143364) s = 3; else if(n < 7454980) s = 4; else if(n < 387659012) s = 5; else s = 6;
		char[] buf = new char[s--];
		
		for(int i = s; i >= 0;) {
			int curr = n % 52 + 65;
			if(curr > 90) curr += 6;
			buf[i--] = (char) curr;
			n = n / 52 - 1;
		}
		
		return String.valueOf(buf);
	}
}

public class CountTwinPrimes {
	
	public static void main (String[]args) {
		
		int n1 = 10;
		System.out.println(solution(n1));
		int n2 = 20;
		System.out.println(solution(n2));
		
	}

	private static String solution(int n) {
		String answer = "";
		int start = 3;
		while(start <= n) {
			int firstNum = start-1;
			int secondNum = start+1;
			
			int countOne = 0;
			int countTwo = 0;

			for(int i = 1; i <= firstNum; i++) {
				if(firstNum % i == 0) countOne++;
			}

			for(int j = 1; j <= secondNum; j++) {
				if(secondNum % j == 0) countTwo++;
			}

			if(countOne == 2 && countTwo == 2) {
				answer += "(" + firstNum + ", " + secondNum + ")";
			}
			start++;
		}
		return answer;
	}
}
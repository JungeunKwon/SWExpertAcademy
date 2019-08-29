/*
 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.

예를 들어

“3+4+5*6+7”

라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.

"34+56*+7+"

변환된 식을 계산하면 44를 얻을 수 있다.

문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.

[입력]

각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 길이가 주어진다. 그 다음 줄에 바로 테스트 케이스가 주어진다.

총 10개의 테스트 케이스가 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 답을 출력한다.


 */
import java.util.Scanner;
import java.util.Stack;

public class Sol_1223 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
		
		for(int a=1;a<=10;a++) {
			int t=sc.nextInt();
			String msg = sc.next();
			String result = doOperate(msg);
			System.out.println(result);
			int finalresult = doCal(result);
			System.out.println("#"+a+" "+ finalresult);
		}
	}

	private static int doCal(String result) {
		char [] arr = result.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int finalresult = 0 ;
		for(int i =0; i <result.length() ; i++)
		{
			char temp = arr[i];
			if(temp <= '9' && temp >='0')
			{
				stack.push(temp - '0');
			}else
			{
				int second = stack.pop();
				int first = stack.pop();
				stack.push(Cal(first,second,temp));
			}
		}
		finalresult = stack.pop();
		return finalresult;
	}
	private static int Cal(int first, int second, char c)
	{
		int result = 0;
		switch(c)
		{
		case '*' :  
			result = first * second;
			break;
		case '+' :
			result = first + second;
			break;
		}
		return result;
	}
	private static String doOperate(String msg) {
		char [] arr= msg.toCharArray();
		Stack<Character> stack = new Stack<>();
		String result ="";
		for(int i = 0;  i < msg.length(); i++)
		{
			char temp = arr[i];
			if(temp <= '9' && temp >= '0')
				result += temp;
			else
			{
				if(stack.isEmpty())
					stack.push(temp);
				else 
				{
					while((!stack.isEmpty()) && (getPriority(stack.peek())>= getPriority(temp)))
					{
						result += stack.pop();
					}
					stack.push(temp);
				}
			}
		}
		while(!stack.empty())
		{
			result += stack.pop();
		}
		return result;
	}
	public static int getPriority(char c)
	{
		int result = 0;
		switch(c)
		{
		case '*' : result = 2; break;
		case '+' : result = 1; break;
		}
		return result;
	}
}

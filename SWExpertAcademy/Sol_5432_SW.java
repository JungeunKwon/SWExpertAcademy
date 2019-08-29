import java.util.Scanner;
/* No.3260
 * ()(((()())(())()))(())
     1               1
      1           2   1
        13 3  13  
   '('이거 받았을 때 다음번이 ')' 이거면 현재 높이 막대기 갯수 더해준다.
   '('이거 받았을 때 다음번이 '(' 이거면 현재 높이를 한칸 올려준다.
    ')'이거 받았을 때 앞이 ')'이거면 무시한다.
    ')'이거 받았을 때 앞이')' 이게 아니면 현재 높이를 한칸 줄여준다.
 */
public class Sol_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = sc.next();
			char[] raiser = input.toCharArray();
			int height = 0; int sum = 0;
			for(int i = 0 ; i < input.length(); i++)
			{
				char tmp = raiser[i];
				switch(tmp)
				{
					case '(' :
					{
						if(i != input.length() -1 && raiser[i+1] == ')')
						{
							sum = sum + height;
						}
						else
						{
							height ++;
							sum ++;
						}
						break;
					}
					case ')' :
					{
						if(i != 0 && raiser[i-1] == '(')
						{
							continue;
						}
						else
						{
							height --;
						}
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}

	}

}

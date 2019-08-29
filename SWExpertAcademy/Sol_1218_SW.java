import java.util.Scanner;
import java.util.Stack;

public class Sol_1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T=sc.nextInt();
			String st =  sc.next();
			int size = st.length();
			Stack<Character> stack = new Stack<Character>();
			char [] arr = st.toCharArray();
			int i = 0;
			int count = 0;
            for( i = 0 ; i < size; i ++)
	        {
				if(arr[i] == '('||arr[i] == '['||arr[i] == '{'||arr[i] == '<') {
					stack.push(arr[i]);
				}
				else if(!stack.isEmpty())
				{
					if(arr[i] == ')')
					{
						char tmp = stack.pop();	
						if(tmp != '(')
							count ++;
					}else if(arr[i] == ']')
					{
						char tmp =  stack.pop();
						if(tmp != '[' )
							count ++;
					}else if(arr[i] == '}')
					{
						char tmp =  stack.pop();
						if(tmp != '{')
							count ++;
					}else if(arr[i] == '>')
					{
						char tmp = stack.pop();
						if(tmp != '<')
							count ++;					
					}			
				}else if(stack.isEmpty())
					count++;
	        }
			if(count  > 0)
			{
				System.out.println("#"+test_case + " 0");
			}else
			{
				System.out.println("#"+test_case + " 1");
			}
		
		}
	}
}

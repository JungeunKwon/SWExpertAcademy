import java.util.Scanner;
import java.util.Stack;

public class Sol_7272 {
	static char[] non_gumunglist = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
	static char[] gumunglist = {'A','D','O','P','Q','R'};
	static String dif = "DIFF";
	static String same = "SAME";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String first = sc.next();
			String second = sc.next();
			if(first.length() != second.length())
			{
				System.out.println("#" + test_case + " " +dif);
			}
			else
			{
				int i = 0;
				for( i = 0 ; i < first.length(); i++)
				{
					char firstc = first.charAt(i), secondc = second.charAt(i);
					boolean firstb = isgumung(firstc), secondb = isgumung(secondc);
					if((firstc == 'B' && secondc != 'B') || (firstc != 'B' && secondc == 'B'))
					{
						System.out.println("#" + test_case + " " +dif);
						break;
					}
					else if((firstb && !secondb )||(!firstb && secondb))
					{
						System.out.println("#" + test_case + " " +dif);
						break;
					}
				}
				if(i == first.length())
				{
					System.out.println("#" + test_case + " " +same);
				}
			}
		}
	}
	static public boolean isgumung(char c)
	{
		int count= 0 ; 
		for(int i = 0 ; i <gumunglist.length; i++)
		{
			if(gumunglist[i] == c)
			{
				count++;
				break;
			}	
		}
		return count > 0 ? true : false;
	}

}

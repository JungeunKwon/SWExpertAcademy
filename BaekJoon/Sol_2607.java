import java.util.Scanner;

public class Sol_2607 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		String firstword = sc.next();
		String arr[] = new String[num - 1];
		int total_count = 0;
		for(int i = 0; i < num -1 ; i ++ )
		{
			arr[i] = sc.next();
		}
		for(int i = 0; i < num - 1; i ++)
		{
			String tempword = firstword;
			char[] temp = arr[i].toCharArray();
			int count = 0;
			int ncount = 0;
			String store = null;
            if(arr[i].length() > firstword.length() + 1) { continue; }
             if(arr[i].length() < firstword.length() - 1) { continue; }
			for(int j = 0; j < temp.length; j++)
			{
				
				if(!tempword.contains(Character.toString(temp[j])))
				{	
					if(store != null)
					{
						if(store.contains(Character.toString(temp[j])))
						{
							continue;
						}
					}
					ncount ++;					
				}else
				{
					store += temp[j];
					tempword = tempword.replaceFirst(Character.toString(temp[j]), "");		
					count ++;
				}
			}
			if(count>= firstword.length() && ncount < 2 && ncount >= 1)
			{
				total_count ++;
			}
			else if(count == firstword.length() - 1 && ncount < 2 && ncount >= 1)
			{
				total_count ++;
			}
			else if(count == firstword.length() + 1 && ncount < 2 && ncount >= 1)
			{
				total_count ++;
			}
		}
		System.out.println(total_count);
	}
}
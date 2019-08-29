import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Sol_1230 {

	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		
		for(int a=1;a<=10;a++) {
			int length =sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i =0 ; i < length; i++)
			{
				list.add(sc.nextInt());
			}
			int N = sc.nextInt();
			for(int i = 0 ; i < N; i++)
			{
				char op = sc.next().toCharArray()[0];
			
				if(op == 'D')
				{
					int position = sc.nextInt();
					int num = sc.nextInt();
					for(int j = 0 ; j<num; j++)
					{
						list.remove(position);
					}
				}else if(op == 'I')
				{
					int position = sc.nextInt();
					int num = sc.nextInt();
					for(int j = position; j<position + num; j++)
					{
						list.add(j, sc.nextInt());
					}
				}else
				{
					int num = sc.nextInt();
					//int num = sc.nextInt();
					for(int j =0 ; j < num; j ++)
					{
						list.add(sc.nextInt());
					}
				}
				
			}
			
			System.out.print("#" +  a + " ");
			for(int i = 0 ; i <10; i++)
			{
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}

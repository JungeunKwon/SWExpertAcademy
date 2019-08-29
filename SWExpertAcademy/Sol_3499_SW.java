import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sol_3499 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		StringTokenizer st; 
		ArrayList<String> firstlist;
		ArrayList<String> secondlist;
		for(int a=1;a<=t;a++) {
			int N = Integer.parseInt(br.readLine());
			int range ;
			if( N % 2 == 0)
			{
				range =(N / 2);
			}else
			{
				range =(N / 2) + 1;
			}
	
			st = new StringTokenizer(br.readLine());
			firstlist = new ArrayList<>();
			secondlist = new ArrayList<>();
			int i = 0;
			while(st.hasMoreTokens())
			{
				if(i < range)
				{
					firstlist.add(st.nextToken());
				}else
				{
					secondlist.add(st.nextToken());
				}
				i++;
			}
			System.out.println("#"+(a)+" ");
			for(i = 0 ; i <= range; i ++)
			{
				if(firstlist.size() > i)
				{
					System.out.print(firstlist.get(i) + " ");
				}
				if(secondlist.size() > i)
				{
					System.out.print(secondlist.get(i) + " ");
				}
			}			
		}
	}
}

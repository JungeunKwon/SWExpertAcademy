import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_2606 {
	public static void main(String[] args) {
        num = 0;
		Scanner sc=new Scanner(System.in);
		int com_num = sc.nextInt();
		int conn_num = sc.nextInt();
		int comarr[][] = new int[com_num + 1][com_num + 1];
		for(int k = 0; k < conn_num; k++)
		{
			int i = sc.nextInt();
			int j = sc.nextInt();
			comarr[i][j] = 1;
			comarr[j][i] = 1;
	
		}
		boolean visited[] = new boolean[com_num + 1];
		bfs(comarr,1,visited);
		System.out.println(num);
	}
	static int num = 0;
	private static void bfs(int[][] comarr,int start, boolean[] visited) {
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.offer(start);
		 while(!q.isEmpty())
		 {
			 int temp = q.poll();
			 visited[temp] = true;
			 for(int i = 0; i <  comarr.length; i++)
			 {
				 if(!visited[i] && comarr[temp][i] == 1)
				 {
					 visited[i] = true;
					 q.offer(i);
					 num++;
					 
				 }
			 }
		 }	 
	}
}
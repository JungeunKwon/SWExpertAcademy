import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_1697 {
	static int min;
	static int count;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		//int arr[] = new int [K];
		min = Integer.MAX_VALUE;
		visited = new boolean[100001];
		count = 0;
		bfs(N, K);
	
		
		System.out.println(min);
	}
	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visited[n] = true;
		while(!q.isEmpty())
		{
			int size = q.size();
			if(count > min)
				break;
			for(int i = 0; i < size; i++)
			{
				int temp = q.poll();
				visited[temp] = true;
				if(temp == k)
				{
					if(min > count)
						min = count;
					break;
				}
				
				if(temp * 2 <= 100000)
				{
					if(!visited[temp * 2])
						{q.offer(temp * 2);
						visited[temp * 2] = true;
						}
				}
				if(temp + 1 <= 100000)
				{
					if(!visited[temp + 1])
					{q.offer(temp + 1);
					visited[temp + 1] = true;
					}
				}
				if(temp - 1 >= 0)
				{
					if(!visited[temp - 1])
					{q.offer(temp - 1);
					visited[temp - 1] = true;
					}
				}
			}
			count ++;
			
		}
		q.clear();
	}
}
/*
	private static void dfs(int n, int k, int count) {

		if(count > min)
			return;
		if(n == k)
		{
			if(count == 0)
			{
				min = 1;
			}
			else if(min > count)
			{
				min = count;
			}
			
			return;
		}
		if(n<=0)
			return;
		
		count ++;
		if(n*2 <= k + 1)
		{
			dfs(n*2, k, count);
		}
		else
		{
			if((n + 1)*2 <k || n + 1 <= k)
			{
				dfs(n+1, k,  count);
			}
			dfs(n-1, k, count);
		}
		
	
		
	}

}
*/
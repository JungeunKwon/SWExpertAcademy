/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_1260 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		int arr[][] = new int[N + 1][N + 1];
		for(int k =0; k < M; k ++)
		{
			int i = sc.nextInt();
			int j = sc.nextInt();
			arr[i][j] = 1;
			arr[j][i] = 1;
		}
		boolean bfsvisited[] = new boolean[N + 1];
		boolean dfsvisited[] = new boolean[N + 1];
		dfs(arr, V, dfsvisited );
		System.out.println();
		bfs(arr, V, bfsvisited);
	}

	private static void dfs(int[][] arr, int start, boolean[] visited) {
		System.out.print(start + " ");
		visited[start] = true;
		for(int i = 0 ; i < visited.length; i++)
		{
			if(!visited[i] && arr[start][i] == 1)
			{
				dfs(arr, i, visited);
			}
		}
	}

	private static void bfs(int[][] arr, int start, boolean[] visited){
		
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(start);
		while(!q.isEmpty())
		{
			int idx = q.poll();
			System.out.print(idx + " ");
			visited[idx] = true;
			for(int i = 1; i < visited.length ; i ++)
			{
				if(!visited[i] && arr[idx][i] == 1)
				{
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

}

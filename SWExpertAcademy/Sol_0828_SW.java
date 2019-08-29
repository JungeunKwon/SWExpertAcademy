package study_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_0828_SW {
	static ArrayList<Node>[] vertexList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			int N = Integer.parseInt(br.readLine());
			double[][] arr = new double[N][N];
			StringTokenizer st;
			StringTokenizer st2;
			ArrayList<Info> list = new ArrayList<>();
			vertexList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				vertexList[i] = new ArrayList<Node>();
			}
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				list.add(new Info(x, y));
			}
			//첨에 각 좌표들 받기
			double E = Double.parseDouble(br.readLine()); //소수점으로 들어오니 더블
			for (int i = 0; i < N; i++) {
				Info temp = list.get(i);
				for (int j = i; j < N; j++) {
					if (i == j)
						continue;
					if (arr[i][j] != 0)
						continue;
					Info temp2 = list.get(j);
					double w = Math.sqrt(Math.pow(temp.x - temp2.x, 2) + Math.pow(temp.y - temp2.y, 2));
					//double w = Math.sqrt((x*x) + (y*y)); 
					arr[i][j] = w;
					arr[j][i] = w;
				}
			}//포워딩 테이블 만들기			
			/*밑에는 쉅시간에 한거*/
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					if (i == j)
						continue;
					double weight = arr[i][j];
					Node av = new Node(j, weight);
					Node av2 = new Node(i, weight);
					vertexList[i].add(av);
					vertexList[j].add(av2);
				}
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean v[] = new boolean[N];
			int begin = 0;
			v[begin] = true;
			Iterator<Node> it = vertexList[begin].iterator();
			while (it.hasNext()) {
				pq.offer(it.next());
			}
			Node temp;
			double result = 0;
			long count = 0;
			while (!pq.isEmpty()) {
				temp = pq.poll();

				int idx = temp.vertex;
				if (v[idx])
					continue;
				result = result + (E * Math.pow(temp.weight,2));
				v[idx] = true;
				count++;
				if (count == N -1) {
					break;
				}
				Iterator<Node> it2 = vertexList[idx].iterator();
				while (it2.hasNext()) {
					pq.offer(it2.next());
				}
			}
			long result2 = (long)Math.round(result);
			System.out.println("#" + a + " " + (long)result2);

		}

	}

	static class Node implements Comparable<Node> {
		int vertex;
		double weight;

		public Node(int vertex, double weight) {
			// TODO Auto-generated constructor stub
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight > o.weight ? 1 : -1;
		}
	}

	public static class Info {
		int x;
		int y;

		Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

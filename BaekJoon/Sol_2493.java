
/*
KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다. 
실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고, 
각 탑의 꼭대기에 레이저 송신기를 설치하였다. 
모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사하고, 
탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다. 
하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다. 

예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고, 
모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자. 
그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고, 
높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 
높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다. 
높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.

탑들의 개수 N과 탑들의 높이가 주어질 때, 
각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라. 

입력
첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다. 
둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다. 
탑들의 높이는 1 이상 100,000,000 이하의 정수이다.

출력
첫째 줄에 주어진 탑들의 순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 하나의 빈칸을 사이에 두고 출력한다. 
만약 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Sol_2493 {

	static Stack<top_info> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num=Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		

		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++)
		{
			arr[i]= Integer.parseInt(st.nextToken());
		}
		cal(arr);
			
		//arr = cal(arr);
		/*for(int i = 0 ; i < num; i++)
		{
			System.out.print(temp[i] + " ");
		}*/

	}
	private static void cal(int[] arr) {
		 stack = new Stack<>();
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			top_info tmp = new top_info();
			int height = arr[i];
			int index = i + 1;
			while(!(stack.isEmpty()) && stack.peek().height <= height )
			{
				stack.pop();
			}
			if(!stack.isEmpty())
			{
				System.out.print(stack.peek().index + " ");
				tmp.height = height;
				tmp.index = index;
				stack.push(tmp);
			}
			else if(stack.isEmpty())
			{	
				tmp.height = height;
				tmp.index = index;
				stack.push(tmp);
				System.out.print(0 + " ");
			}
			
		}

	}
	static class top_info{
		int height;
		int index;
		
	}
	
	/*private static int[] cal(int[] arr) {
		int[] temp = new int[arr.length];
		
		for(int i = arr.length -1 ; i > 0; i--)
		{
			int j = 0;
			for(j = i - 1; j >=0 ; j --)
			{
				if(arr[i] <= arr[j])
				{
					temp[i] = j + 1;
					break;
				}
			}
			if(j < 0)
				temp[i] = 0;
		}
		return temp;

	}
*/
}



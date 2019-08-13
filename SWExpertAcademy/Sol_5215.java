/*평소 햄버거를 좋아하던 민기는 최근 부쩍 늘어난 살 때문에 걱정이 많다.

그렇다고 햄버거를 포기할 수 없었던 민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다. 
 

민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.

하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다. 

민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.

민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,

민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.

(단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)

 

[입력] 
 

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 

각 테스트 케이스의 첫 번째 줄에는 재료의 수, 제한 칼로리를 나타내는 N, L(1 ≤ N ≤ 20, 1 ≤ L ≤ 104)가 공백으로 구분되어 주어진다.
 

다음 N개의 줄에는 재료에 대한 민기의 맛에 대한 점수와 칼로리를 나타내는 Ti, Ki(1 ≤ Ti ≤ 103, 1 ≤ Ki ≤ 103)가 공백으로 구분되어 주어진다. 
 

[출력]

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 주어진 제한 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거의 점수를 출력한다.*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sol_5215 {
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int source_num = sc.nextInt();
			int max_kcal = sc.nextInt();
			int score_array[] = new int[source_num];
			int kcal_array[] = new int[source_num];
			ArrayList<Integer> score_list = new ArrayList<Integer>();
			ArrayList<Source_info> list = new ArrayList<Source_info>();
			for(int i = 0; i <source_num; i++)
			{
				score_array[i] = sc.nextInt();
				kcal_array[i] = sc.nextInt();
			
					Source_info si = new Source_info();
					si.score = score_array[i];
					si.kcal = kcal_array[i];
					si.visit = 'N';
					list.add(si);
				
			}
			int i = 0;
			while(true)
			{
				if(i >= list.size())
					break;				
				check_kcal(list,score_list ,i, 0, 0, max_kcal);
				for(int j = 0; j<list.size(); j++)
				{
					list.get(j).visit = 'N';
				}
				i++;
			}
			int max = 0;
			System.out.println(trace.toString());
			for(i =0; i<score_list.size(); i++)
			{
				if(score_list.get(i) > max)
					max = score_list.get(i);
			}
			System.out.printf("#%d %d",test_case, max);
			
		}
		
	}
	public static class Source_info
	{
		public int score;
		public int kcal;
		public char visit;
	}
	public static void check_kcal(ArrayList<Source_info> list, ArrayList<Integer> cal_score, int num, int totalscore, int totalkcal, int max_kcal)
	{
		Source_info si = list.get(num);
		int sum_score = totalscore;
		int sum_kcal = totalkcal;
		sum_score += si.score;
		sum_kcal += si.kcal;
		trace.add(num);
		if(sum_kcal > max_kcal)
		{
			si.visit = 'Y';
			list.set(num, si);
			cal_score.add(totalscore);
			return;
		}else if(sum_kcal == max_kcal)
		{
			si.visit = 'Y';
			list.set(num, si);
			cal_score.add(sum_score);
			return;
		}
		else
		{	
			
			int i = num + 1;
			while(true)
			{			
				if(i < list.size())
				{
					Source_info next = list.get(i);
					
					if(next.visit == 'N')
					{
						check_kcal(list,cal_score,i,sum_score, sum_kcal, max_kcal);
						for(int j = i; j<list.size(); j++)
						{
							if(j != i)
							{list.get(j).visit = 'N';}
						}
					}
				}else
				{
					si.visit = 'Y';
					list.set(num, si);
					cal_score.add(sum_score);
					break;
				}
				i++;
			}
			return;
		}
		
	}



}

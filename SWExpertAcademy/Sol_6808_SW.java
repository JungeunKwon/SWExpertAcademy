/*
 * 규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.

한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.

한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.

높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,

낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.

이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.

두 사람의 총점이 같으면 무승부이다.

이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.

규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라

규영이의 승패가 정해질 것이다.

이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.

각 정수는 1이상 18이하이며, 같은 정수는 없다.

규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수를

공백 하나로 구분하여 출력한다.
 */
import java.util.Scanner;

public class Sol_6808 {
	public static int [] card;
	public static int wincount;
	public static int losecount;
	public static int [] Aarr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int a=1;a<=T;a++) {
			card = new int[19];
			wincount = 0; 
			losecount = 0;
			Aarr = new int[9];
			int [] Barr = new int[9];
			for(int i = 0 ; i < 9; i++)
			{
				Aarr[i] = sc.nextInt();
				card[Aarr[i]] = 1;
			}
			int j=0;
			for(int i = 1 ; i<card.length ; i++)
			{
				if(card[i] != 1)
				{
					Barr[j] = i;
					j++;
				}
			}
			perm(Barr, 0);
			System.out.print("#" +  a + " " + wincount + " " + losecount);
			System.out.println();
		}
	}
	private static void perm(int[] barr, int depth) {
		if(depth == barr.length)
		{
			int result = cal_game(Aarr,barr);
			if(result== 0)
			{
				wincount++;
			}else if(result == 1)
			{
				losecount++;
			}
			return;
		}
		for(int i = depth; i < barr.length; i++)
		{
			swap(barr, depth, i);
			perm(barr,depth +1);
			swap(barr,depth,i);
		}
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int cal_game(int[] Aarr, int [] Barr)
	{
		int  result = 0;
		int atotal = 0 ,btotal=0;
		for(int i = 0 ; i < Aarr.length; i++)
		{
			if(Aarr[i] > Barr[i]) {
				atotal += Aarr[i] + Barr[i];
			}else
			{
				btotal += Aarr[i] + Barr[i];
			}
		}
		if(atotal > btotal)
			result = 0;
		else if(atotal<btotal)
			result = 1;
		else
			result = 2;
		return result;
	}
}

import java.util.Scanner;

public class WS06_20190724 {
	static int[][] board;
	final static int dy[]= {0,0,-1};
	final static int dx[]= {1,-1,0};
						//오른쪽 왼쪾 위 밑  
	final static int Ladder = 1, End = 2;

	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=10;
		
		for(int a=1;a<=t;a++) {
			N = sc.nextInt();
			board = new int[100][100];
			int desti =0 ,destj = 0;		
			for(int i = 0 ; i < 100; i++)
			{
				for(int j = 0 ; j < 100; j++)
				{
					board[i][j] = sc.nextInt();
					if(board[i][j] == End)
					{
						desti = i;
						destj = j;
					}
				}
			}
			findload(desti,destj, 2);
		}
	}
	public static void findload(int i, int j, int dir)
	{
		int tx = 0 , ty= 0 ;
		if(i <= 0)
		{
			System.out.println("#" + N + " " +j);
			return;
		}
		
		int l = 0;
		for(l = 0 ; l < 3; l++)
		{
			ty = i + dy[l];
			tx = j + dx[l];
			if(ty < 0 || tx < 0 || ty >= 100 || tx >= 100)
				continue;
			if(board[ty][tx] == Ladder)
			{
				if(dir == 1)
					if (l == 0)
						continue;
				if(dir == 0)
					if (l == 1)
						continue;
				break;
			}
			
			
		}
		
		
		findload(ty,tx,l);
		
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1873_SW {
	public static int H;
	public static int W;
	public static char[] op;
	public static int num;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,1,-1};//>,<,v,^
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer  st;
		for(int a = 1; a <= T; a++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] arr = new char[H][W];
			String line = "";
			Info start = null;
			for(int i = 0 ; i <H ; i ++)
			{
				st = new StringTokenizer(br.readLine());
				line = st.nextToken();
				for(int j = 0; j < W; j++)
				{
					arr[i][j] = line.charAt(j);
					if(arr[i][j] == '>')
					{
						start = new Info(i, j, 0);
						arr[i][j] = '.';
					}
					if(arr[i][j] == '<')
					{
						start = new Info(i, j, 1);
						arr[i][j] = '.';
					}
					if(arr[i][j] == 'v')
					{
						start = new Info(i, j, 2);
						arr[i][j] = '.';
					}
					if(arr[i][j] == '^')
					{
						start = new Info(i, j, 3);
						arr[i][j] = '.';
					}
					
					
				}
			}
			num = Integer.parseInt(br.readLine());
			op = new char[num];
			line = br.readLine();
			for(int i = 0; i < num; i++)
			{
				op[i] = line.charAt(i);
			}
			play(arr, start);
			System.out.print("#" + a+ " ");
			for(int i = 0; i < H; i++)
			{
				for(int j = 0; j < W; j++)
				{
					if(i == start.i)
					{
						if(j == start.j)
						{
							switch(start.dir)
							{
							case 0:
								System.out.print('>');
								break;
							case 1:
								System.out.print('<');
								break;
							case 2:
								System.out.print('v');
								break;
							case 3:
								System.out.print('^');
								break;
							}
							continue;
						}
					}
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
	private static void play(char[][] arr, Info start) {
		int tx =0, ty =0;
		for(int i = 0; i < num; i ++)
		{
			switch(op[i])
			{
			case 'S' :
				tx = start.j + dx[start.dir];
				ty = start.i + dy[start.dir];
				while(ty >= 0 && tx >= 0 && tx < W && ty <H)
				{
					if(arr[ty][tx] == '*')
					{
						arr[ty][tx] = '.';
						break;
					}
					if(arr[ty][tx] == '#') break;
					tx = tx + dx[start.dir];
					ty = ty + dy[start.dir];
				}
				break;
			case 'U' :
				start.dir = 3;
				tx = start.j + dx[3];
				ty = start.i + dy[3];
				if(ty >= 0 && tx >= 0 && tx < W && ty < H && arr[ty][tx] == '.')
				{
					start.i = ty;
					start.j = tx;
				}
				break;
			case 'D' :
				start.dir = 2;
				tx = start.j + dx[2];
				ty = start.i + dy[2];
				if(ty >= 0 && tx >= 0 && tx < W && ty < H && arr[ty][tx] == '.')
				{
					start.i = ty;
					start.j = tx;
				}
				break;
			case 'L' :
				start.dir = 1;
				tx = start.j + dx[1];
				ty = start.i + dy[1];
				if(ty >= 0 && tx >= 0 && tx < W && ty < H  && arr[ty][tx] == '.')
				{
					start.i = ty;
					start.j = tx;
				}
				break;
			case 'R' :
				start.dir = 0;
				tx = start.j + dx[0];
				ty = start.i + dy[0];
				if(ty >= 0 && tx >= 0 && tx < W && ty < H && arr[ty][tx] == '.')
				{
					start.i = ty;
					start.j = tx;
				}
				break;
			}
		}
	}
	public static class Info{
		int i;
		int j;
		int dir;
		Info(int i, int j, int dir)
		{
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
}

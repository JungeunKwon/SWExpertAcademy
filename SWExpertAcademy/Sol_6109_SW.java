import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_6109_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());
			int arr[][] =new int[N][N];
			String command = st.nextToken();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0; i < N ; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			switch(command)
			{
			case "right" :
				for(int i = 0; i< N ; i++)
				{
					list.clear();
					for(int j = N -1 ; j >= 0; j --)
					{
						if(arr[i][j] == 0)continue;
						if(j != 0 && arr[i][j - 1] == 0)
						{
							arr[i][j-1] = arr[i][j];
							continue;
						}
						if(j != 0 && arr[i][j] == arr[i][j - 1])
						{
							list.addLast(arr[i][j] * 2);
							j--;
						}else
							list.addLast(arr[i][j]);
					}
					for(int j = N -1 ; j >= 0; j --)
					{
						if(!list.isEmpty())
						{
							arr[i][j] = list.getFirst();
							list.removeFirst();
						}else
							arr[i][j] = 0;
					}
				}
				
				break;
			case "left" :
				for(int i = 0; i< N ; i++)
				{
					list.clear();
					for(int j = 0 ; j < N ; j++)
					{
						if(arr[i][j] == 0)continue;
						if(j != N - 1 &&arr[i][j + 1] == 0)
						{
							arr[i][j+1] = arr[i][j];
							continue;
						}
						if(j != N - 1 && arr[i][j] == arr[i][j +1])
						{
							list.addLast(arr[i][j]*2);
							j++;
						}else
							list.addLast(arr[i][j]);
					}
					for(int j = 0 ; j < N ; j++)
					{
						if(!list.isEmpty())
						{
							arr[i][j] = list.getFirst();
							list.removeFirst();
						}else
							arr[i][j] = 0;
					}
				}
				break;
			case "up" :
				for(int j = 0; j < N ; j++)
				{
					list.clear();
					for(int i = 0; i < N; i++)
					{	
						if(arr[i][j] == 0)continue;
						if(i != N -1 &&arr[i + 1][j] == 0)
						{
							arr[i+1][j] = arr[i][j];
							continue;
						}
						if(i != N -1 && arr[i][j] == arr[i+1][j])
						{
							list.addLast(arr[i][j] * 2);
							i++;
						}else
						{
							list.addLast(arr[i][j]);
						}
					}
					for(int i = 0; i < N ; i ++)
					{
						if(!list.isEmpty())
						{
							arr[i][j] = list.getFirst();
							list.removeFirst();
						}else
							arr[i][j] = 0;
					}
				}
				break;
			case "down" :
				for(int j = 0; j < N ; j++)
				{
					list.clear();
					for(int i = N - 1; i >= 0; i--)
					{	
						if(arr[i][j] == 0)continue;
						if(i != 0 && arr[i - 1][j] == 0)
						{
							arr[i-1][j] = arr[i][j];
							continue;
						}
						if(i != 0 && arr[i][j] == arr[i-1][j])
						{
							list.addLast(arr[i][j] * 2);
							i--;
						}else
						{
							list.addLast(arr[i][j]);
						}
					}
					for(int i = N - 1; i >= 0 ; i --)
					{
						if(!list.isEmpty())
						{
							arr[i][j] = list.getFirst();
							list.removeFirst();
						}else
							arr[i][j] = 0;
					}
				}
				break;
			}
			System.out.println("#" + a);
			for(int i = 0; i < N ; i++)
			{
				for(int j = 0; j < N ; j ++)
				{
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}

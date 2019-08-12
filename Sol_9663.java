import java.util.Scanner;

public class Sol_9663 {
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		count = 0;
		nQueen(arr,0);
		System.out.println(count);
	}
	private static void nQueen(int[] arr, int depth) {
		if(depth == arr.length)
		{
			count ++;
			return;
		}
		for(int i = 0 ; i < arr.length; i++)
		{
			arr[depth] = i;
			if(promising(arr,depth))
			{
				nQueen(arr, depth + 1);
			}
		}	
	}
	private static boolean promising(int[] arr, int depth) {
		boolean flag = true;
		for(int i = 0 ; i < depth ; i++)
		{
			if(arr[i] == arr[depth])
			{
				flag = false;
				break;
			}
			if(Math.abs(arr[depth]-arr[i]) == (depth - i))
			{
				flag = false;
				break;
			}
		}
		return flag;
    }
}
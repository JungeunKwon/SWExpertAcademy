import java.util.Scanner;

public class Sol_4796_BJ {

	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int a = 1; a<=T ; a++)
	        {
	            int num = sc.nextInt();
	            int arr[] = new int[num];
	            for(int i = 0; i  < num; i++)
	            {
	                arr[i] = sc.nextInt();
	            }
	            int ins = 0;
	            int count = 0;
	            boolean flag = false;
	            for(int i  = 1; i <  num; i++)
	            {
	                if(arr[i-1] < arr[i])
	                {
	                    if(flag)
	                    {
	                        ins = 0;
	                        flag = false;
	                    }
	                    ins ++;
	                }else
	                {
	                    count += ins;
	                    flag = true;
	                }
	            }
	            System.out.println("#" + a + " " + count);
	        }
	    }
	}
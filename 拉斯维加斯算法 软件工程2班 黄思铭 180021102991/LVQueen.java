import java.util.*;
public class LVQueen
{
    static Random rnd;//�����������
    static int n;//�ʺ����
    static int[] x;//������
    
    private static boolean place(int k)
    {
        for(int j = 1; j< k; j++)
        {
            if(Math.abs(k - j) == Math.abs(x[k] - x[j]) || x[j] == x[k])
                return false;
        }
        return true;
    }
    private  static boolean queensLV()
    {
        rnd = new Random();
        int k = 1;
        int count = 1;
        while((k <= n) &&(count > 0))
        {
            count  = 0;
            int j = 0;
            for(int i = 1; i <= n; i++)
            {
                x[k] = i;
                if(place(k))
                {
                    if(rnd.random(++count) == 0)
                        {
                            j = i;
                            System.out.println("j = " +j +" count = "+count );
                            //break;//��break�����һ���ҵ����ʵ���place(k)���㣬��ô��ʱrandom��1��==0����������������break���Ͱѻʺ���������λ�á�������ַ��ûʺ�ķ��������У��´�ѭ������ִ��ͬ���ģ���һֱѭ�����������Ҳ�����������ʣ�µ����лʺ���ò��˵Ŀ���������
                            //û��break����һֱ��̽forѭ��������x[k]���������ѡ��ǰ���Է��õ�λ����forѭ�����һ��������С���ô�������n-1���ʺ���ò��˵Ŀ����Լ�С��
                        }
                }
            }
            if(count > 0) 
            {
                x[k++] = j;
                System.out.println("k = " + k+" x[k-1] = " + x[k-1]);
            }
        }
                    
        return  (count> 0);
    }
    
    public static  void nQueen()
    {
        x = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            x[i]= 0;
        }
        
        while(!queensLV());
        System.out.println("-----�ⷨ--------");
        for(int i = 1; i <= n; i++)
        {
            System.out.println("("+i + " , " +x[i]+")" );
        }       
    }
    
    public static void main(String[] args)
    {
        rnd = new Random();
        n = 8;
        nQueen();
    }
}


import java.util.*;
public class Q1 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();

			int[] ans=new int[2*n+1];
			pair[] p = new pair[n];
			for(int i=0;i<n;i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				p[i] = new pair(a,b);
			
			}
		
			int c = 0;
			int prev=0;
			for(int i=1;i<=n;i++)
			{
				ans[2*i-1]+=prev+Math.abs(p[c].a-p[c++].b);
				if(i!=n)
				prev = ans[2*i-1]+(Math.abs(p[c-1].b-p[c].a));
			}
			
			for(int i=1;i<n;i++)
			{
				ans[2*i]=solve(p,i+1,p[i-1].b,p[i].b,ans[2*i-1]+Math.abs(p[i].a-p[i].b));
				
			}
			int min = ans[2];
			for(int i=1;i<n;i++)
			{
				if(ans[2*i]<min)
					min=ans[2*i];
				//System.out.println(ans[2*i]+" "+i);
			}
			System.out.println(min);
		}
	}
	public static int solve(pair[] p,int j,int pos1,int pos2,int ans)
	{
		for(int i=j;i<p.length;i++)
		{
			if(Math.abs(p[i].a-pos1)<Math.abs(p[i].a-pos2))
			{
				ans+=Math.abs(p[i].a-pos1)+Math.abs(p[i].a-p[i].b);
				pos1 = p[i].b;
			}
			else
			{
				ans+=Math.abs(p[i].a-pos2)+Math.abs(p[i].a-p[i].b);
				pos2 = p[i].b;
			}
		}
		return ans;
	}
}
	
class pair
{
	int a;
	int b;
	pair(int a,int b)
	{
		this.a = a;
		this.b = b;
	}
}
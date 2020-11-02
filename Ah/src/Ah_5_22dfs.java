import java.util.Scanner;

/*-----��ȱ���----���·��----�ڽӾ���---
 	1.����ģ��
 * 			void dfs(int start)
 * 			{
 * 				��Ǹõ�
 * 				������е�����귵��(return)
 * 				�������е�
 * 				for(int i = 1; i <= n; i++)
 * 				{
 * 					�ж�(if)�Ƿ����Ҫ��;
 * 						������һ��  dfs(step+1);
 *  			}
 *  			����(return)
 *  		}
 * */
public class Ah_5_22dfs {
	static int N = 0, M = 0;				//�㣬��		���������õ㣬������������������
	static int[][]	a = new int[51][51];	//����ͼ����߼�
	static int[] book = new int[51];		//��Ϊֻ�漰������У���һά����
	static int Inf = Integer.MAX_VALUE;
	static int min = Integer.MAX_VALUE;
	int sum = 0;
	//������ȱ���
	public void dfs(int start){
		//�����ǰ�߹����Ѿ������Ѿ��ҵ���min,��û��Ҫ�ڱ�����ȥ
		if (sum > min)
			return;
		//����ýڵ�ΪĿ��ڵ㣬���²�����
		if (start == 5) {
			if ( sum < min)
				min = sum;
			return;
		}
		
		//��Ǹõ��Ѿ�����
		book[start] = 1;
		//ö�����нڵ�
		for(int i = 1; i <= N; i++){
			//�����·����δ������
			if (a[start][i] != Inf && book[i] == 0) {
				sum += a[start][i];				//���ϵ�ǰȨֵ
				dfs(i);							//��ȱ���
				sum -= a[start][i];				//������һ�α���Ȩֵ
				book[i] = 0;					//���ϸ��ڵ㳷�����
			}
		}
		//������нڵ�����꣬�򷵻���һ�ڵ�
		return;
	}

	public static void main(String[] args) {
		
		System.out.println("����ͼ�Ķ�����������:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();	//��
		M = scanner.nextInt();	//��
		//ͼ��ʼ��
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if (i != j)
					a[i][j] = Inf;
				
		
		for(int i = 1; i <= M; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int dis = scanner.nextInt();
			a[x][y] = dis;
		}
		Ah_5_22dfs ah = new Ah_5_22dfs();
		ah.dfs(1);

		System.out.println("���·��Ϊ: " + min);

	}

}

import java.util.Scanner;

/*----ͼ�ı���--������ȱ���----
 * 1. ������ȱ��������ȴ�һ��δ�߹��Ķ�����Ϊ��㣬���Ÿõ�ȥ���Է�������δ���ʵĵ�...
 * 				 ���Ըõ���Ϊ�µ���㣬����������������...
 *  
 * 3.����ģ��
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
public class Ah_5_1dfs {
	static int N = 0, M = 0;				//�㣬��		���������õ㣬������������������
	static int[][]	a = new int[51][51];	//����ͼ����߼�
	static int[] book = new int[51];		//��Ϊֻ�漰������У���һά����
	static int sum = 0;
	public void dfs(int start){
		sum++;
		book[start] = 1;
		System.out.print(start + " ");
		if (sum == N) {						//���ж��������
			return;
		}
		
		for(int i = 1; i <= N; i++){
			//���������·����δ������
			if (a[start][i] == 1 && book[i] == 0) {
				dfs(i);						//�����һ����
			}
		}
		return;								//�õ������㶼�����˾ͷ�����һ����
	}

	public static void main(String[] args) {
		System.out.println("����ͼ�Ķ�����������:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		for(int i = 1; i <= M; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			a[x][y] = 1;
			a[y][x] = 1;
		}
		Ah_5_1dfs ah = new Ah_5_1dfs();
		ah.dfs(1);

	}

}

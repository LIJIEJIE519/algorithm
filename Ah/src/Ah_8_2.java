import java.util.Scanner;

/*-----Prim--��С������--��Dij-----
 * 1. �����һ���������ʼ��������������book[]�������Щ���Ѿ�����������
 * 	     ��dis[]����¼����������������ľ��룬��dis[]��ѡ��������������Ķ��㣨temp�������뵽��������
 * 	     ����tempΪ֮��㣬������������ÿһ��������������ľ���(��dis[k]>e[temp][k])...
 * 
 * 
 * 
 * */
public class Ah_8_2 {
	private static int N;						//����
	private static int M;						//����
	
	public int[][] edge = new int[N+1][N+1];	//����Ϣ����
	public int[] dis = new int[N+1];			//��������
	public int[] book = new int[N+1];			//�������
	
	//Prim�㷨
	public void prim(int start){
		int count = 1,temp = 0,sum = 0;
		book[start] = 1;
		
		while(count < N){
			int min = 99999999;
			//���µ�
			for(int i = 1; i <= N; i++)
				//δ������ҵ�����������С��
				if (book[i] == 0 && dis[i] < min) {
					min = dis[i];
					temp = i;
				}
			//��Ϊ�м���
			book[temp] = 1;
			count++;
			sum += dis[temp];
			//�Ը��м����Ϊ�н�
			for(int k = 1; k <= N; k++)
				if (book[k] == 0 && dis[k] > edge[temp][k])
					dis[k] = edge[temp][k];
		}
		System.out.println("��С������Ϊ: " + sum);
	}

	public static void main(String[] args) {
		System.out.println("����㼰����:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		Ah_8_2 ah = new Ah_8_2();
		
		//��ʼ��
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if (i != j) {
					ah.edge[i][j] = 99999999;
				}
		//������
		for(int i = 1; i <= M; i++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			ah.edge[a][b] = c;
			ah.edge[b][a] = c;
		}

		//��dis[]��ʼ��
		for(int i = 1; i <= N; i++)
			ah.dis[i] = ah.edge[1][i];
		ah.prim(1);
		
	}

}

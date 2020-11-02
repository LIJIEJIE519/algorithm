import java.util.LinkedList;
import java.util.Scanner;

/*------ͼ�ı���--������ȱ���-----
 * 1.������һ��δ���ʵĶ���Ϊ���(������)�������������бߵĶ���(����)...���Ըö���Ϊ���...
 * 
 * 2. ����ģ��
 * 			void bfs(int start)
 * 			{	
 * 				���(�Ѿ�����)�õ�;
 * 				���;
 * 				while(���в�Ϊ��)
 * 				{
 * 					�����µ���ʼ��;
 * 					�����нڵ����(for){
 * 						�����������(�б���δ���){
 * 							���;	
 * 							����Ѿ�����;
 * 						}
 * 						������нڵ�����꼴�˳�(break);
 * 					}
 * 					�Ƴ�ͷ�ڵ�;
 * 				}
 * 			}
 * 
 * */
public class Ah_5_2bfs {
	static int N = 0, M = 0;				//�㣬��		���������õ㣬������������������
	static int[][]	a = new int[51][51];	//����ͼ����߼�
	static int[] book = new int[51];		//��Ϊֻ�漰������У���һά����
	static int sum = 0;
	
	//��ȷ��ʵ����
	LinkedList<Integer> list = new LinkedList<>();
	
	//������ȱ���
	public void bfs(int start){
		sum++;
		list.add(start);					//���
		book[start] = 1;					//��Ǹõ��Ѿ�����

		while(!list.isEmpty()){				//ֱ������Ϊ��
			start = list.getFirst();		//�ı���ʼ����
			for(int i = 1; i <= N; i++){	//�����нڵ����
				//����б���δ����
				if (a[start][i] == 1 && book[i] == 0) {
					sum++;
					list.add(i);
					book[i] = 1;
				}
				//������нڵ��Ѿ�������
				if (sum == N)
					break;
			}
			System.out.print(list.getFirst() + " ");
			//��Ҫ���Ƴ�ͷ�ڵ㣬�ı��µ���ʼ�ڵ�
			list.remove();
		}
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
		Ah_5_2bfs ah = new Ah_5_2bfs();
		ah.bfs(1);

	}

}

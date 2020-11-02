import java.util.LinkedList;
import java.util.Scanner;

/*-----��ȱ���ͼ--����ת������-----
 * 1. ���������Ȩֵ��ͬ������
 * 2. �漰��ĳ�㵽ĳ����̴���,�ù�����(ͬ�㲽����ͬ)
 * 
 * */
public class Ah_5_3bfs {
	static int N = 0, M = 0;				//�㣬��		���������õ㣬������������������
	static int[][]	a = new int[51][51];	//����ͼ����߼�
	static int[] book = new int[51];		//��Ϊֻ�漰������У���һά����
	//�¶������
	class Dis{
		int x = 0;			//���б��
		int step = 0;		//ת������,����֮��
	}
	
	Dis d = new Dis();
	LinkedList<Dis> list = new LinkedList<>();
	public void bfs(int start){
		int flag = 0;		//����Ƿ񵽴�Ŀ��
		book[start] = 1;	//����Ѿ�����
		d.x = start;
		d.step =0;			//��ʼ�ڵ����Ϊ0
		list.add(d);
		
		while(!list.isEmpty()){
			//�����µ����
			start = list.getFirst().x;
			d = new Dis();
			//ö�ٱ������нڵ�
			for(int i = 1; i <= N; i++){
				//�����·����δ������
				if (a[start][i] == 1 && book[i] == 0) {
					d.x = i;
					//�ò㲽��������һ�㲽����1
					d.step = list.getFirst().step + 1;
					list.add(d);
					//�������Ŀ�����ñ������˳�
					if (i==5){
						flag = 1;
						break;
					}
					book[i] = 1;
				}
			}
			
			if (flag == 1) {
				System.out.println("����ת��Ϊ: " + list.getLast().step);
				break;
			}
			//����Ҫ���Ƴ�ͷ�����ܼ���������չ
			list.remove();
		}
	}

	public static void main(String[] args) {
		System.out.println("����ͼ�Ķ�����������:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();	//��
		M = scanner.nextInt();	//��
		//����ͼ��ʼ��
		for(int i = 1; i <= M; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			a[x][y] = 1;
			a[y][x] = 1;
		}
		Ah_5_3bfs ah = new Ah_5_3bfs();
		ah.bfs(1);

	}

}

import java.util.LinkedList;

/*---ö�� + ������� ----ը����----
 * 1. ը���ܵ���ĵط������ը���ĵ�����
 * 2. ��ö�ٷ������ÿ���ո����ը����ը���ĵ��������ù��������������ܴﵽ�ĵط�
 * 3. ��һ�������������ܴﵽ�ĵط�����ӳ�������������...,book[][] ����Ƿ��Ѿ����
 * 
 * 4.һ��һ�����չ����չʱÿ����һ�����е�ͽ��˵��������У�Ȼ���Ƴ�ͷ��㣬���µ�ͷ����ֿ�ʼ�������...
 * 
 * */
public class Ah_4_4 {
	static int N = 13;
	static int M = 13;
	class Dis{
		int x;
		int y;
	}
	//��#��Ϊǽ����H��Ϊ�ո񣬡�G��Ϊ����
	static char[][] a = {{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
			  			 {'#','G','G','H','G','G','G','#','G','G','G','H','#'},
			  			 {'#','#','#','H','#','G','#','G','#','G','#','G','#'},
			  			 {'#','H','H','H','H','H','H','H','#','H','H','G','#'},
			  			 {'#','G','#','H','#','#','#','H','#','G','#','G','#'},
			  			 {'#','G','G','H','G','G','G','H','#','H','G','G','#'},
			  			 {'#','G','#','H','#','G','#','H','#','H','#','H','#'},
			  			 {'#','#','G','H','H','H','G','H','H','H','H','H','#'},
			  			 {'#','G','#','H','#','G','#','#','#','H','#','G','#'},
			  			 {'#','H','H','H','G','#','G','G','G','H','G','G','#'},
			  			 {'#','G','#','H','#','G','#','G','#','H','#','G','#'},
			  			 {'#','G','G','H','G','G','G','#','G','H','G','G','#'},
			  			 {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
			  			};
	
	//���ظõ��ը�����˵���Ŀ��ö�ٷ�
	public int getNum(int i, int j){
		int sum=0,x,y;
		
		//����ͳ��
		x = i;
		y = j;
		while(a[x][y] != '#'){
			if (a[x][y] == 'G') 
				sum++;
			x--;
		}
		//����ͳ��
		x = i;
		y = j;
		while(a[x][y] != '#'){
			if (a[x][y] == 'G') 
				sum++;
			x++;
		}
		//����ͳ��
		x = i;
		y = j;
		while(a[x][y] != '#'){
			if (a[x][y] == 'G') 
				sum++;
			y--;
		}
		//����ͳ��
		x = i;
		y = j;
		while(a[x][y] != '#'){
			if (a[x][y] == 'G') 
				sum++;
			y++;
		}
		return sum;
	}
	
	//���������
	public void bfs(int startx, int starty){
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};			//�������-��������
		int[][] book = new int[N][M];						//����Ƿ����
		int max = 0,sum,X = 0,Y = 0;
		
		Dis d = new Dis();						//�µ��������
		d.x = startx;
		d.y = starty;
		LinkedList<Dis> list = new LinkedList<>();
		list.add(d);
		book[startx][starty] = 1;				//������
		
		//ֱ������Ϊ��
		while(!list.isEmpty()){				
			//���ͷ�����ը���ĵ�����
			sum = getNum(list.getFirst().x, list.getFirst().y);
			//����
			if (sum > max) {
				max = sum;
				X = list.getFirst().x;
				Y = list.getFirst().y;
			}
			//ö���ĸ�����
			for(int k = 0; k <= 3; k++){
				//�������ƶ�
				int x = list.getFirst().x + dir[k][0];
				int y = list.getFirst().y + dir[k][1];
				
				//�ж��Ƿ����
				if (x > N-1 || x < 1 || y > M-1 || y < 1) {
					continue;
				}
				
				//Ϊ�ո���δ���
				if (a[x][y] == 'H' && book[x][y] == 0) {
					d = new Dis();
					d.x = x;
					d.y = y;
					list.add(d);
					book[x][y] = 1;
					
				}
			}
			//ǧ�������ǣ��Ƴ�ͷ������������չ
			list.removeFirst();
		}
		
		System.out.println("����Ϊ: " + X + " " + Y);
		System.out.println("������Ϊ: " + max);
	}

	public static void main(String[] args) {
		Ah_4_4 ah = new Ah_4_4();
		ah.bfs(3, 3);		

	}

}

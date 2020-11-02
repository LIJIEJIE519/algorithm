import java.util.Scanner;

/*-----����--�����������------���ƺ�����ʽ--
 * 1. ������������ؼ������¸���ô������һ���뵱����ͬ��
 * 2. ����ģ��
 * 			void dfs(int step)
 * 			{
 * 				�жϱ߽�--return
 * 				����ÿһ�ֿ���  
 * 				for(int i = 1; i <= n; i++)
 * 				{
 * 					������һ��  dfs(step+1);
 *  			}
 *  			����
 *  		}
 * 
 * 
 * 3. ����Ϊȫ���У� 
 * 	     ����Ϊ���������е����������a[],book[]����Ƿ���룬��ȷ��룬��ȫ��������������ó�ǰһ��...
 * 
 * 
 * */

public class Ah_4_1 {
	int[] a = new int[10];			//װ���ĺ���
	int[] book = new int[10];		//��Ƿ���=0��ʾ�������֣�=1��ʾ���Ʒ������
	static int n;
	static int sum = 0;
	
	public void dfs(int step){
		
		//��n+1������ǰ���޿������ʾǰn�������Ѿ��źã������һ������
		if (step == n+1) {
			sum++;
			/*for(int i = 1; i <= n; i++)
				System.out.print(a[i]);
			//һ��Ҫ������֮ǰ��һ�����ݹ���������
			System.out.println();*/
			return;
		}
		//ö�ٳ�n�ֿ���
		for(int i = 1; i <= n; i++){
			if (book[i] == 0) {		//��ʾ���ƻ�����
				a[step] = i;
				book[i] = 1;		//���Ʒ������
				
				dfs(step + 1);		//�ݹ������һ������
				book[i] = 0;		//�ѷ���Ŀ����ջأ����ܽ�����һ��
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("����n(1~9):");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		Ah_4_1 ah = new Ah_4_1();
		ah.dfs(1);
		
		System.out.println("��������: " + sum);

	}

}

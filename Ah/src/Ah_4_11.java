/*--�����������---
 * ������磺173+286=459
 * */
public class Ah_4_11 {
	int[] a = new int[10];
	int[] book = new int[10];
	static int sum = 0;
	
	public void dfs(int step){
		//���һ������
		if (step == 10) {
			if (a[1]*100 + a[2]*10 + a[3] + a[4]*100 + a[5]*10 + a[6] == a[7]*100 + a[8]*10 + a[9]) {
				sum++;
				for(int i = 1; i <= 3; i++){
					System.out.print(a[i]);
				}
				System.out.print('+');
				for(int i = 4; i <= 6; i++){
					System.out.print(a[i]);
				}
				System.out.print('=');
				for(int i = 7; i <= 9; i++){
					System.out.print(a[i]);
				}
				System.out.println();
			}
		}
		
		for(int i = 1; i <=9; i++){
			if (book[i] == 0) {
				a[step] = i;			//���������
				book[i] = 1;			//����û�иÿ���
				dfs(step+1);			//������һ������
				book[i] = 0;			//�ó���һ�ſ���
			}
		}
	}

	public static void main(String[] args) {
		Ah_4_11 ah = new Ah_4_11();
		ah.dfs(1);
		System.out.println("������ϣ� " + sum/2);

	}

}

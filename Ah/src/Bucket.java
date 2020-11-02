import java.util.Random;
/*-----------Ͱ����-----------
 * 1.Ͱ���� �������򵥵������ж��ά�ȣ���Ҫ�����������,
 * 2.Ͱ�����ʱ�临�Ӷ���O(M+N)��������������Ҳ����򵥵�����
 * 3.��Ͱ��װ��
 * 4.�˷��˿ռ�
 * 5.������С��
 * 
 * 6.ȥ��
 * */

class Gap{
	//�ҳ������������������Ҫ�ص������
	public int method(int[] num){
		int max = num[1]-num[0];
		for (int i = 1; i < num.length-1; i++) {
			max = Math.max(max, num[i+1] - num[i]);
		}
		return max;
	}
}
public class Bucket {
	public static int[] bucket(int[] num){
		
		if(num == null || num.length < 2){
	        return num;
	    }
		
		int t = 0, n = num.length;
		int[] bucket = new int[1001];
		
		//��ʼ��Ͱ������ÿ��������Ϊ0
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}
		
		//���ԭ��������������ӦͰ(����)�ĸ���+1
		for (int i = 0; i < n; i++){
			int j = num[i];
			bucket[j]++;
			//bucket[j]=1;		ȥ��
		}
		
		//�ö�ӦͰ�ĸ���>=1ִ����Ӧ����
		for (int i = 0; i < bucket.length; i++)
			for(int j = 1; j <= bucket[i]; j++){				
				num[t++] = i;
			}
		
		return num;
	}
	

	public static void main(String[] args) {
		//�����������
		int N = 10;
		//int[] array = {6,1,2,7,9,3,4,5,10,8};
		int[] array = new int[N];
		Random rand = new Random();
		for(int i = 0; i < N; i++){
			array[i] = rand.nextInt(1001);
		}
		
		System.out.print("ԭ����Ϊ:  ");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.print("Ͱ�����Ϊ: ");
		
		array = bucket(array);  
		for (int i : array) {
			System.out.print(i + " ");
		}

		System.out.println();
		Gap gap = new Gap();
		System.out.println("�����Ϊ: " + gap.method(array));
	}

}

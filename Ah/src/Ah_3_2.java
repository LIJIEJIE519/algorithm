import java.util.Scanner;

/*-----ö���㷨--����㷨----
 * 1. ����m(<=24)�������ƴ��  a+b=c �ĵ�ʽ; 
 * 2. +=Ϊ4��; ���ȫ������; a+b=c--b+a=c Ϊ2��; 1����
 * 3. 0~1111֮��ö�پ���(����~~~��
 * 
 * 4.��ٷ�����a�������� + b�������� + c�������� = m-4
 * 
 * */
public class Ah_3_2 {
	//����һ��������Ļ�������Ŀ
	public static int count(int x){
		//������¼0~9ÿ����������Ļ����
		int a[] = {6,2,5,5,4,5,6,3,7,6};
		int num = 0;
		
		while(x/10 != 0){				//x��ֻһλ��
			num += a[x%10];				//��ȡx��ĩβ����
			x = x/10;					//ȥ��x��ĩβ���֣���x = 123,���Ϊx = 12
		}
		
		num += a[x];					//������һ��Ϊ1λ���Ļ����
		return num;		
	}

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		//int m = s.nextInt();			//�����

		
		int m = 18;
		int c,sum = 0;
		for(int a = 0; a <= 1111; a++)
			for(int b = 0; b <= 1111; b++){
				c = a + b;
				//��a�������� + b�������� + c�������� = m-4
				if (count(a) + count(b) + count(c) == m - 4 ) {
					sum++;
					System.out.println(a + "+" + b + "=" + c);
				}
			}
		System.out.println("�ܹ��У� " + sum);
	}

}

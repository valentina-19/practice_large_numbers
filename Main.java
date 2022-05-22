package large_numbers;

import java.math.BigInteger;
import java.util.Random;

public class Main {
	
	// ������� ���������� ������������ ������ - ���������� ������, �-� ����� ���� ������ keyLength-������
	public static BigInteger getKeySpace (int keyLength) {
		// ��������� ������ �� 1 �� ����� �����, �������������� � �������� ��������� ������������ ���� � ������������ ������ 
		String val = "";
		for (int i = 1; i <= keyLength; i++) { 
		 	val += "1"; 
		}
		BigInteger maxKey = new BigInteger (val, 2); // ������������ ����� � ������������ ������ 
		BigInteger one = new BigInteger ("1"); //������������� 1 � BigInteger ��� ���������� ������������ ������ �� ������� maxKey + 1 
		return maxKey.add(one); // ���������� ������������ ������		
	}
	
	// ������� ���������� ����� � ������������ ��� ������� ����� ����������
	public static long getBrutforceTime (BigInteger key) {
		// ���������� ����� ������ �������
		long startTime = System.currentTimeMillis();
		// ������ ��������� �������� ��� ������� �����
		BigInteger val = new BigInteger("0");
		// �������  BigInteger �� ��������� 1 ��� ���������� ����� ��� ��������
		BigInteger one = new BigInteger("1"); 
		// ���� � �������, ����� ��������� �������� ����� �������� ��������� �����
		while(key.compareTo(val) != 0) {
			
			// ����������� �������� ������������ ����� �� 1
			val = val.add(one);
		}
		
		// ���������� ����������� ����� � ������������
		return System.currentTimeMillis() - startTime;		
	} 
	

	public static void main(String[] args) {

		for (int i = 8; i <= 4096; i *= 2) {
			// ������� ���������� ��������� ������, ������� ����� ������ 8-, 16-, 32-, 64-, 128-, 256-, 512-, 1024-, 2048-, 4096-������ �������������������
			System.out.println ("��� " + i + "-������ ������������������ ������������ ������ " + getKeySpace(i) + ".");
			
			// ���������� ��������� �������� ����� � ��������� �� 0x00�0 �� 0xFF�F � ����������� �� ����� �����
			BigInteger randomKey = new BigInteger (i, new Random());
			System.out.println ("������������ ��������� ���� " + randomKey + ".");
			
			// �������� ������� ��� ��������� �������� �� ��������� ��� ���������� ����� �
			// ������� ���������� ������� � �������������, ������� ���� ��������� �� ���������� �����
			System.out.println ("������ ����� ���������� ����� " + getBrutforceTime(randomKey) + " ��.");
			
			// ����������� �������������������
			System.out.println ("***");
		}
	}

}

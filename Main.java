package large_numbers;

import java.math.BigInteger;
import java.util.Random;

public class Main {
	
	// функци€ возвращает пространство ключей - количество ключей, к-е может быть задано keyLength-битами
	public static BigInteger getKeySpace (int keyLength) {
		// формируем строку из 1 по длине ключа, представл€ющую в двоичном счислении максимальный ключ в пространстве ключей 
		String val = "";
		for (int i = 1; i <= keyLength; i++) { 
		 	val += "1"; 
		}
		BigInteger maxKey = new BigInteger (val, 2); // максимальное число в пространстве ключей 
		BigInteger one = new BigInteger ("1"); //преобразовуем 1 в BigInteger дл€ нахождени€ пространства ключей по формуле maxKey + 1 
		return maxKey.add(one); // возвращаем пространство ключей		
	}
	
	// функци€ возвращает врем€ в милисекундах дл€ подбора ключа брутфорсом
	public static long getBrutforceTime (BigInteger key) {
		// запоминаем врем€ начала подбора
		long startTime = System.currentTimeMillis();
		// задаем начальные значени€ дл€ подбора ключа
		BigInteger val = new BigInteger("0");
		// создаем  BigInteger со значением 1 дл€ увеличени€ ключа при переборе
		BigInteger one = new BigInteger("1"); 
		// цикл с выходом, когда найденное значение равно входному параметру ключа
		while(key.compareTo(val) != 0) {
			
			// увеличиваем значение подбираемого ключа на 1
			val = val.add(one);
		}
		
		// возвращаем затрачееное врем€ в милисекундах
		return System.currentTimeMillis() - startTime;		
	} 
	

	public static void main(String[] args) {

		for (int i = 8; i <= 4096; i *= 2) {
			// выводим количество вариантов ключей, которые можно задать 8-, 16-, 32-, 64-, 128-, 256-, 512-, 1024-, 2048-, 4096-битной последовательностью
			System.out.println ("ѕри " + i + "-битной последовательности пространство ключей " + getKeySpace(i) + ".");
			
			// генерируем случайное значение ключа в диапазоне от 0x00Е0 до 0xFFЕF в зависимости от длины ключа
			BigInteger randomKey = new BigInteger (i, new Random());
			System.out.println ("—генерирован случайный ключ " + randomKey + ".");
			
			// вызываем функцию дл€ брутфорса значений из диапазона дл€ нахождени€ ключа и
			// выводим количество времени в миллисекундах, которое было затрачено на нахождение ключа
			System.out.println ("ѕодбор ключа брутфорсом зан€л " + getBrutforceTime(randomKey) + " мс.");
			
			// разделитель последовательностей
			System.out.println ("***");
		}
	}

}

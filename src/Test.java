
import java.util.*;

public class Test {

	private static Kart [][] kartlar= new Kart[4][4];  // array objesi olu�turduk
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		kartlar[0][0]= new Kart('E');
		kartlar[0][1]= new Kart('A');
		kartlar[0][2]= new Kart('B');
		kartlar[0][3]= new Kart('F');
		kartlar[1][0]= new Kart('G');
		kartlar[1][1]= new Kart('A');
		kartlar[1][2]= new Kart('D');
		kartlar[1][3]= new Kart('H');
		kartlar[2][0]= new Kart('F');
		kartlar[2][1]= new Kart('C');
		kartlar[2][2]= new Kart('D');
		kartlar[2][3]= new Kart('H');
		kartlar[3][0]= new Kart('E');
		kartlar[3][1]= new Kart('G');
		kartlar[3][2]= new Kart('B');
		kartlar[3][3]= new Kart('C');
		
		//oyun_tahtasi();
		
		while(oyunBittiMi()== false) {
			oyun_tahtasi();
			Tahmin();
		}
	}

	public static void Tahmin() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Birinci tahmin (i ve j de�erlerini bir bo�luk b�rakarak giriniz...) : ");
		int i1= scanner.nextInt();
		int j1= scanner.nextInt();
		
		kartlar[i1][j1].setTahmin(true);
		oyun_tahtasi();
		
		System.out.println("�kinci tahmin (i ve j de�erlerini bir bo�luk b�rakarak giriniz...) : ");
		int i2= scanner.nextInt();
		int j2= scanner.nextInt();
		
		if(kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()) {
			kartlar[i2][j2].setTahmin(true);
			System.out.println("Tebrikler bildiniz.");
		}
		
		else {
			kartlar[i1][j1].setTahmin(false);
		}
	}
	
	public static void oyun_tahtasi() {
		
		for( int i=0;i<4;i++) {
			System.out.println("________________________");
			for(int j=0;j<4;j++) {
				//System.out.println("|  | ");
				
				if(kartlar[i][j].isTahmin()) {
					System.out.print("| "+kartlar[i][j].getDeger()+" |");
				}
				else {
					System.out.print("|  | ");
				}
			}
			System.out.println(" ");
			
		}
		System.out.println("________________________");
	}
	
	public static boolean oyunBittiMi() {
		
		for( int i=0;i<4;i++) {
			
			for(int j=0;j<4;j++) {
				
				
				if(kartlar[i][j].isTahmin()== false) {
					return false;
				}
				
			}						
		}
		
		return true;
	}
}

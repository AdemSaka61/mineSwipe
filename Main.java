import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row, col;
        System.out.println("Mayın tarlası oyununa hoşgeldiniz.");
        System.out.println("Lütfen oyun boyutlarını giriniz !");
        System.out.print("Satır sayısını giriniz : ");
        row = scan.nextInt();
        System.out.print("Sütun sayısını giriniz : ");
        col = scan.nextInt();
        MineSwiper mayin = new MineSwiper(row,col);
        mayin.run();
    }
}

import java.util.Random;
import java.util.Scanner;

public class MineSwiper {
    int row, col, size, colnumber, rownumber, success = 0;
    int[][] map;
    int[][] board;
    boolean game = true;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MineSwiper(int row, int col) {
        this.row = row;
        this.col = col;
        this.map = new int[row][col];
        this.board = new int[row][col];
        this.size = row * col;
    }

    public void run() {
        prepareGame();
        print(map);

        System.out.println("Oyun başladı!");
        while (game) {
            print(board);
            System.out.print("Satır : ");
            rownumber = input.nextInt();
            System.out.print("Sütun : ");
            colnumber = input.nextInt();
            if(rownumber < 0 || rownumber >= row){
                System.out.print("Geçersiz koordinat!");
                continue;
            }
            if(colnumber < 0 || colnumber >= row){
                System.out.print("Geçersiz koordinat!");
                continue;
            }
            if (map[rownumber][colnumber] != -1) {
                checkMine(rownumber, colnumber);
                success++;
                if(success == (size- (size/4))){
                    System.out.print("Oyunu kazandınız!");
                    break;
                }
            } else {
                game = false;
                System.out.println("Game over!");
            }
        }

    }

    public void checkMine(int r, int c) {
        if (map[r][c] == 0){
            if ((c < col -1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < row -1) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }
            if (board[r][c] == 0){
                board[r][c] = -2;
            }
        }

    }

    public void prepareGame() {
        int randRow, randCol, count = 0;
        while (count < (size / 4)) {
            randRow = rand.nextInt(row);
            randCol = rand.nextInt(col);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}


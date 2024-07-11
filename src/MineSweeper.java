import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    String[][] minesweeper;
    String[][] sweeper;

    public MineSweeper(int rowNumber, int colNumber) {
        if (rowNumber > 1 && colNumber > 1) {
            this.rowNumber = rowNumber;
            this.colNumber = colNumber;
            this.minesweeper = new String[rowNumber][colNumber];
            this.sweeper = new String[rowNumber][colNumber];

        } else {
            System.out.println("Birden büyük bir değer giriniz...");
        }
    }

    public void run(){
        Scanner scanner=new Scanner(System.in);
        boolean isItMine=false;
        System.out.println("Mayınların Konumu");
        putMine();
        System.out.println("Mayın Tarlasına Hoşgeldiniz...");
        putSweeper(sweeper);
        while (!isItMine){
            System.out.print("Satır Giriniz:");
            int rowValue=scanner.nextInt();
            System.out.print("Sütun Giriniz:");
            int colValue=scanner.nextInt();
            if (rowValue>rowNumber && colValue>colNumber){
                System.out.println("Geçerli bir değer giriniz...");
                continue;
            }else {
            if(minesweeper[rowValue][colValue].equals("* ")){
                System.out.println("Game over!!!");
                isItMine=true;
            }else {
               sweeper[rowValue][colValue]= String.valueOf(findNumber(rowValue,colValue,minesweeper))+" ";
               printMine(sweeper);
            }
            }
        }


    }

    public int getNumberMine() {
        return (this.colNumber * this.rowNumber) / 4;
    }

    public void putMine() {
        putSweeper(minesweeper);
        Random random = new Random();
        int mineNumber = getNumberMine();
        while (mineNumber > 0) {
            int row = random.nextInt(rowNumber);
            int col = random.nextInt(colNumber);
            if (minesweeper[row][col].equals("- ")) {
                minesweeper[row][col] = "* ";
                mineNumber--;
            }
        }
        printMine(minesweeper);
    }

    public String[][] putSweeper(String[][] arr2) {

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arr2[i][j] = "- ";
            }
        }
        return arr2;
    }

    public void printMine(String[][] arr) {
        for (String[] a : arr) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

    public int findNumber(int row, int col, String[][] arr) {
        int number = 0;
        if (row == 0) {
            if (col == 0) {
                if (arr[row][col + 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col + 1].equals("* ")) {
                    number++;
                }
            } else if (col == colNumber - 1) {
                if (arr[row][col - 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col - 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col].equals("* ")) {
                    number++;
                }
            } else {
                if (arr[row][col - 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col - 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col].equals("* ")) {
                    number++;
                }
                if (arr[row][col + 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col + 1].equals("* ")) {
                    number++;
                }
            }
        } else if (row==rowNumber-1){
            if (col==0){
                if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row][col+1].equals("* ")){
                    number++;
                }if (arr[row-1][col+1].equals("* ")){
                    number++;
                }
            }else if (col==colNumber-1){
                if (arr[row][col - 1].equals("* ")) {
                    number++;
                }if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row-1][col-1].equals("* ")){
                    number++;
                }
            }else {
                if (arr[row][col - 1].equals("* ")) {
                    number++;
                }if (arr[row-1][col-1].equals("* ")){
                    number++;
                }if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row-1][col+1].equals("* ")){
                    number++;
                }if (arr[row][col+1].equals("* ")){
                    number++;
                }
            }
        }else {
            if (col==0){
                if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row-1][col+1].equals("* ")){
                    number++;
                }if (arr[row][col+1].equals("* ")){
                    number++;
                }if (arr[row + 1][col + 1].equals("* ")) {
                    number++;
                }if (arr[row + 1][col].equals("* ")) {
                    number++;
                }
            } else if (col==colNumber-1){
                if (arr[row][col - 1].equals("* ")) {
                    number++;
                }if (arr[row-1][col-1].equals("* ")){
                    number++;
                }if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row + 1][col - 1].equals("* ")) {
                    number++;
                }
                if (arr[row + 1][col].equals("* ")) {
                    number++;
                }
            }else {
                if (arr[row-1][col].equals("* ")){
                    number++;
                }if (arr[row-1][col+1].equals("* ")){
                    number++;
                }if (arr[row][col+1].equals("* ")){
                    number++;
                }if (arr[row + 1][col + 1].equals("* ")) {
                    number++;
                }if (arr[row + 1][col].equals("* ")) {
                    number++;
                }if (arr[row + 1][col - 1].equals("* ")) {
                    number++;
                }if (arr[row][col - 1].equals("* ")) {
                    number++;
                }if (arr[row-1][col-1].equals("* ")){
                    number++;
                }
            }
        }
        return number;
    }
}


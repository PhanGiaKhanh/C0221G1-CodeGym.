package L2_VongLapTrongJava.BaiTap;

import java.util.Scanner;

public class PrintFigure {
    public static void main(String[] args) {
        byte choice;
        byte height;
        byte width;
        String result;
        do {
            result = "";
            Scanner input = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle(The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)");
            System.out.println("3. Print the isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Byte.parseByte(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter height : ");
                    height = Byte.parseByte(input.nextLine());
                    System.out.print("Enter width : ");
                    width = Byte.parseByte(input.nextLine());
                    result = printRectangle(height, width);
                    break;
                case 2:
                    System.out.print("Enter height : ");
                    height = Byte.parseByte(input.nextLine());
                    result = squareTriangle(height);
                    break;
                case 3:
                    System.out.print("Enter height : ");
                    height = Byte.parseByte(input.nextLine());
                    result = isoscelesTriangle(height);
                    break;
            }
            System.out.println(result);
        }while (choice < 4 && choice > 0);
    }

    static String isoscelesTriangle(int x){
        String result = "";
        for (int i = 0; i < x; i++) {
            for (int j = x-1; j > i; j--) {
                result += ' ';
            }
            for (int j = 0; j < (i*2 +1); j++){
                result += '*';
            }
            result += "\n";
        }
        return result;
    }
    static String squareTriangle(int x) {
        String bottomLeft = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                bottomLeft += " *";
            }
            bottomLeft += "\n";
        }
        String topLeft = "";
        for (int i = 0; i < x; i++) {
            for (int j = x - i; j > 0; j--) {
                topLeft += " *";
            }
            topLeft += "\n";
        }
        String bottomRight = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j < x - i - 1) {
                    bottomRight += "  ";
                } else {
                    bottomRight += " *";
                }
            }
            bottomRight += "\n";
        }

        String topRight = "";
        for (int i = 0; i < x; i++) {
            for (int j = 5; j > 0; j--) {
                if (j <= x - i) {
                    topRight += "* ";
                } else {
                    topRight += "  ";
                }
            }
            topRight += "\n";
        }
        return bottomLeft +"\n"+ bottomRight +"\n"+ topLeft +"\n"+ topRight;
    }

    static String printRectangle(int x, int y) {
        String rectangle = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                rectangle += " *";
            }
            rectangle += "\n";
        }
        return rectangle;
    }
}

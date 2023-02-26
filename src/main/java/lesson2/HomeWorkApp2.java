package lesson2;

public class HomeWorkApp2 {
    public static void main (String[] args){
        System.out.println(checkSum(8, 4));
        checkSingStr(-4);
        System.out.println(checkSingBool(-55));
        printString("ddddd", 4);
        System.out.println(leapYearCheck(2000));
    }

    public static boolean checkSum (int a, int b) {
        int sum = a + b;
        boolean c;
        if (sum >= 10 && sum <=20){
            c =  true;
        } else{
            c = false;
        }
        return c;
    };

    public static void checkSingStr(int a) {
        if (a >= 0){
            System.out.println("Положительное");
        }
        else{
            System.out.println("Отрицательное");
        }
    };

    public static boolean checkSingBool(int a) {
        boolean b;
        if (a < 0){
            b = true;
        } else {
            b = false;
        }
        return b;
    };

    public static void printString(String a, int b){
        while (b != 0) {
            System.out.println(a);
            b -= 1;
        }
    };

    public static boolean leapYearCheck(int year) {
        boolean leapYear = false;
        if (year % 400 == 0){
            leapYear = true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            leapYear = true;
        }
        return leapYear;
    };
};

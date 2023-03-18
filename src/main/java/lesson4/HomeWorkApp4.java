package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {
    /*Пользовательские настройки игры*/
    public static int SIZE;
    public static int COUNT_SYMBOLS;

    /*Системные настройки игры*/
    public static final char DOT_EMPTY = '•';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_COMPUTER = 'O';
    public static char[][] MAP;

    public static final Scanner in = new Scanner(System.in);
    public static final Random random = new Random();

    public static void main(String[] args) {
        initMAP();
        initCountSymbols();
        System.out.println("Игра запущена!");
        printMap();

        while (checkEmptyDots()) {
            humanMove();
            printMap();

            if (checkWin(DOT_HUMAN)) {
                gameOver("чел");
            }
            if (checkEmptyDots()){
                computerMove();
                printMap();

                if (checkWin(DOT_COMPUTER)) {
                    gameOver("комп");
                }
            }
        }

        //конец игры
        gameOver("ничья");
}

    public static void initMAP() {
        System.out.print("Укажите ширину поля: ");
        SIZE = in.nextInt();
        if (SIZE < 3) {
            System.out.println("Поле такого размера не может быть создано!");
            System.out.println("Введите значение от 3 и более");
            initMAP();
        }
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void initCountSymbols() {
        System.out.print("Укажите длину цепочки для победы: ");
        COUNT_SYMBOLS = in.nextInt();
        if (COUNT_SYMBOLS < 3) {
            System.out.println("С такими параметрами игра не состоится...");
            System.out.println("Подойдет любое значение, начиная с 3");
        }

    }

    public static void printMap() {
        System.out.print("  ");
        printHeaderMap();
        System.out.println();
        printBodyMap();
    }

    public static void printHeaderMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
    }

    public static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanMove() {
        System.out.println("Ваш ход!");
        int rowNumb = insertCoordinate("строки");
        if (rowNumb == -1) {
            gameOver("ничья");
        }

        int colNumb = insertCoordinate("колонки");
        if (colNumb == -1) {
            gameOver("ничья");
        } else if (checkDotsForMove(rowNumb, colNumb)) {
            MAP[rowNumb][colNumb] = DOT_HUMAN;
        } else {
            System.out.println("Ячейка уже занята, выберите другую клетку для хода.");
            humanMove();
        }
    }

    private static void gameOver(String winner) {
        switch (winner) {
            case "чел" -> System.out.println("Поздравляю, Вы победили!");
            case "комп" -> System.out.println("Машина взяла верх..");
            case "ничья" -> System.out.println("Игра окончена!");
        }
        System.exit((1));
    }

    public static int insertCoordinate(String direction) {
        System.out.print("Введите координату " + direction + ": ");
        int coordinate = in.nextInt() - 1;

        while (coordinate < 0 || coordinate >= SIZE) {
            System.out.println("Такой координаты на поле нет! Допустимы значения от 0 до " + SIZE);
            int tryAgain = 3;
            while (coordinate < 0 && tryAgain > 0 || coordinate >= SIZE && tryAgain > 0) {
                switch (tryAgain) {
                    case 3 -> {
                        System.out.println("Попробуйте еще раз:");
                        coordinate = in.nextInt() - 1;
                    }
                    case 2 -> {
                        System.out.println("Соберитесь: ");
                        coordinate = in.nextInt() - 1;
                    }
                    case 1 -> {
                        System.out.println("Это последний шанс: ");
                        coordinate = in.nextInt() - 1;
                    }
                }
                tryAgain -= 1;
            }
            if (tryAgain == 0) {
                System.out.println("Вы не самый интересный соперник. Я ухожу =(");
                return -1;
            }
        }
        return coordinate;
    }

    public static void computerMove() {
        int rowNumb = random.nextInt(SIZE);
        int colNumb = random.nextInt(SIZE);
        if (checkDotsForMove(rowNumb, colNumb)) {
            System.out.println("Ход компьютера!");
            MAP[rowNumb][colNumb] = DOT_COMPUTER;
        } else computerMove();
    }

    public static boolean checkEmptyDots() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDotsForMove(int rowNumb, int colNumb) {
        if (MAP[rowNumb][colNumb] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean checkWin(int dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == dot) {
                    int a = 1;
                    // проверка победы по горизонтали
                    try {
                        int b = j;
                        if (a == COUNT_SYMBOLS) {
                            return true;
                        }
                        while (MAP[i][b] == MAP[i][b + 1]) {
                            a += 1;
                            b += 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if (a == COUNT_SYMBOLS){
                            return true;
                        }
                        a = 1;
                        continue;
                    }
                    // проверка победы по диагонали вправо
                    try {
                        int c = i;
                        int b = j;
                        while (MAP[c][b] == MAP[c + 1][b + 1]) {
                            a += 1;
                            c += 1;
                            b += 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        if (a == COUNT_SYMBOLS){
                            return true;
                        }
                        a = 1;
                        continue;
                    }

                    // проверка победы по диагонали влево
                    try {
                        int c = i;
                        int b = j;
                        while (MAP[c][b] == MAP[c + 1][b - 1]) {
                            a += 1;
                            c += 1;
                            b -= 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        if (a == COUNT_SYMBOLS){
                            return true;
                        }
                        a = 1;
                        continue;
                    }

                    // проверка победы по вертикали
                    try {
                        int c = i;
                        if (a == COUNT_SYMBOLS) {
                            return true;
                        }
                        while (MAP[i][j] == MAP[c + 1][j]) {
                            a += 1;
                            c += 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if (a == COUNT_SYMBOLS) {
                            return true;
                        }
                        a = 1;
                        continue;
                    }
                    }
                }
            }
        return false;
    }
}

//    public static void checkSymbolsStringsVertical(int i, int j) {
//    }



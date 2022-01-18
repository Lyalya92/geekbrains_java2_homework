package ru.geekbrains.homeworks.lesson2;

public class HomeworkLesson2 {
    public static void main(String[] args) {

        String [][] array1 = {
                {"1", "2", "3", "0"},
                {"5", "10", "8", "11"},
                {"6", "12", "3", "8"},
                {"7", "1", "12", "0"}
        };

        String [][] array2 = {
                {"1", "2", "3", "0"},
                {"5", "10", "g", "11"},
                {"6", "12", "3", "8"},
                {"7", "1", "12", "0"}
        };

        String [][] array3 = {
                {"1", "2", "3", "0"},
                {"5", "10", "11"},
                {"6", "12", "3", "8"},
                {"7", "1", "12", "0"}
        };

        // Корректный массив:
        System.out.println("Array 1:");
        try {
            System.out.println("Sum = " + arraySum(array1));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Массив, в котором не все данные можно преобразовать в int
        System.out.println("Array 2:");
        try {
            System.out.println("Sum = " + arraySum(array2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Массив с неправильным размером:
        System.out.println("Array 3:");
        try {
            System.out.println("Sum = " + arraySum(array3));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int arraySum (String [][] arr) {
    int result = 0;

      // Проверка размерности массива
      if (arr.length!=4) throw new MyArraySizeException("Invalid array length");
        for (int i = 0; i < 4; i++) {
            if (arr[i].length!=4) throw new MyArraySizeException("Invalid array length");
        }

      // Суммируем элементы
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                }
                catch (RuntimeException e) {
                    String message = "Invalid data type at [" + (i+1) + "][" + (j+1) + "]";
                    throw new MyArrayDataException(message);
                }
            }
        }
      return result;
    }
}

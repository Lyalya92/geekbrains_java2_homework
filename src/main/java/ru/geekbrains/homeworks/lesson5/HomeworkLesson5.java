package ru.geekbrains.homeworks.lesson5;

import java.util.Arrays;

public class HomeworkLesson5 {
    private static final int sizeArray = 10000000;
    private static float [] arr = new float[sizeArray];
    private static float [] arrNew = new float[sizeArray];

    public static void main(String[] args) throws InterruptedException{
        changeArrayOneTread();
        System.arraycopy(arr, 0, arrNew, 0, sizeArray);
        changeArrayTwoTread();
        System.out.println(Arrays.equals(arr, arrNew));
    }

    // Работа с массивом в одном потоке:
    public static void changeArrayOneTread() {
        for (int i = 0; i < sizeArray; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        changeArray(0,sizeArray);
        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime-startTime);
    }

    // Работа с массивом в двух потоках:
    public static void changeArrayTwoTread() throws InterruptedException{
        for (int i = 0; i < sizeArray; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> changeArray(0,sizeArray/2));
        Thread t2 = new Thread(() -> changeArray(sizeArray/2,sizeArray));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime-startTime);
    }


    private static void changeArray (int startPoint, int endPoint) {
        for (int i = startPoint; i < endPoint; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

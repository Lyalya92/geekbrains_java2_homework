package ru.geekbrains.homeworks.lesson1;

public class Human implements ObstacleRunning {
    private static int maxRunLength = 1200;
    private static int maxJumpHeight = 3;

    @Override
    public boolean run (RunningTrack track) {
        if (track.getLength() <= maxRunLength) {
            System.out.printf("Участник: Человек. Длина дорожки %dm: успешно\n", track.getLength());
            return true;
        }
        System.out.printf("Участник: Человек. Длина дорожки %dm: провалено\n", track.getLength());
        return false;
    }

    @Override
    public boolean jump (Wall wall) {
        if (wall.getHeight() <= maxJumpHeight) {
            System.out.printf("Участник: Человек. Высота стены %dm: успешно\n", wall.getHeight());
            return true;
        }
        System.out.printf("Участник: Человек. Высота стены %dm: провалено\n", wall.getHeight());
        return false;
    }

    public static int getMaxRunLength() {
        return maxRunLength;
    }

    public static int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}

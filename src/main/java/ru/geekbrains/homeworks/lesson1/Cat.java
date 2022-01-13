package ru.geekbrains.homeworks.lesson1;

public class Cat implements ObstacleRunning {
    private static int maxRunLength = 700;
    private static int maxJumpHeight = 5;

    @Override
    public boolean run (RunningTrack track) {
        if (track.getLength() <= maxRunLength) {
            System.out.printf("Участник: Кот. Длина дорожки %d: успешно\n", track.getLength());
            return true;
        }
        System.out.printf("Участник: Кот. Длина дорожки %dm: провалено\n", track.getLength());
        return false;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxJumpHeight) {
            System.out.printf("Участник: Кот. Высота стены %dm: успешно\n", wall.getHeight());
            return true;
        }
        System.out.printf("Участник: Кот. Высота стены %dm: провалено\n", wall.getHeight());
        return false;
    }

    public static int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public static int getMaxRunLength() {
        return maxRunLength;
    }
}

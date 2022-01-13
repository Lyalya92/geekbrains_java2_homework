package ru.geekbrains.homeworks.lesson1;

public class Robot implements ObstacleRunning {
    private static int maxRunLength = 900;
    private static int maxJumpHeight = 0;

    @Override
    public boolean run (RunningTrack track) {
        if (track.getLength() <= maxRunLength) {
            System.out.printf("Участник: Робот. Длина дорожки %d: успешно\n", track.getLength());
            return true;
        }
        System.out.printf("Участник: Робот. Длина дорожки %dm: провалено\n", track.getLength());
        return false;
    }

    @Override
    public boolean jump (Wall wall) {
        if (wall.getHeight() <= maxJumpHeight) {
            System.out.printf("Участник: Робот. Высота стены %dm: успешно\n", wall.getHeight());
            return true;
        }
        System.out.printf("Участник: Робот. Высота стены %dm: провалено\n", wall.getHeight());
        return false;
    }

    public static int getMaxRunLength() {
        return maxRunLength;
    }

    public static int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}

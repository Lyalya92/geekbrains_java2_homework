package ru.geekbrains.homeworks.lesson1;

public class HomeworkLesson1 {
    public static void main(String[] args){

        // создаем массивы препятствий:
        RunningTrack [] tracks= {
                new RunningTrack(200),
                new RunningTrack(500),
                new RunningTrack(900)
        };
        Wall [] walls = {
                new Wall(1),
                new Wall(2),
                new Wall(3)
        };

        // создаем массив участников:
        ObstacleRunning [] participants = {
                new Robot(),
                new Cat(),
                new Human()
        };

        // Каждый участник пытается пройти полосу препятствий,
        // которая состоит из чередующихся беговых дорожек и стен
        for (ObstacleRunning participant : participants) {
            boolean success = true;
            for (int i = 0; i < 3; i++) {
               if (!participant.run(tracks[i])) {
                   success = false;
                   break;
               }
                if (!participant.jump(walls[i])) {
                    success = false;
                    break;
                }
            }
            if (!success) System.out.println("Участник покидает соревнования");
            else System.out.println("Все препятствия преодолены!");
            System.out.println();
        }

    }

}

class AnimalThread extends Thread {
    private String name;
    private int priority;
    private int distance;

    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.distance = 0;
    }

    public void run() {
        while (distance < 100) {
            try {
                Thread.sleep(100); // Имитация движения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Увеличение пройденного расстояния
            distance += 10;

            // Вывод информации о пройденном расстоянии
            System.out.println(name + " преодолел " + distance + " метров");
        }

        System.out.println(name + " финишировал!");
    }

    public void setPriority(int priority) {
        this.priority = priority;
        super.setPriority(priority);
    }
}

public class RabbitAndTurtle {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY);

        rabbit.start();
        turtle.start();

        // Имитация динамического изменения приоритетов
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rabbit.setPriority(Thread.MIN_PRIORITY);
        turtle.setPriority(Thread.MAX_PRIORITY);
    }
}
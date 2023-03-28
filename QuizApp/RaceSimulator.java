import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.*;
import java.util.Scanner;
class RunnerThread extends Thread {
    private String name;
    private int distanceCovered = 0;
    private int raceLength = 1000;
    static AtomicBoolean stop = new AtomicBoolean(false);
    public RunnerThread(String name) {
        this.name = name;
    }

    public void run() {
        Random random = new Random();
        while (!stop.get()) {
            try {
                sleep(1000); // Wait for 1 second

                int distance = random.nextInt(6) + 5; // Generate a random distance between 5 to 10
                distanceCovered += distance;
                if(distanceCovered>=raceLength){
                    stop.set(true);
                }
                System.out.println(name + " has covered " + distanceCovered + " meters.");
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
        stop.set(true);
    }

    public String myGetName() {
        return name;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }
}

public class RaceSimulator {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of runners: ");
        int numRunners = sc.nextInt();
        List<RunnerThread> runners = new ArrayList<RunnerThread>();
        for (int i = 1; i <= numRunners; i++) {
            runners.add(new RunnerThread("Runner " + i));
        }
        for (RunnerThread runner : runners) {
            runner.start();
        }
        for (RunnerThread runner : runners) {
            runner.join();
        }

        runners.sort((r1, r2) -> r2.getDistanceCovered() - r1.getDistanceCovered()); // Sort by distance covered

        System.out.println("\nTop 3 runners:");
        for (int i = 0; i < 3; i++) {
            if (i < runners.size()) {
                System.out.println((i + 1) + ". " + runners.get(i).myGetName() + " - " + runners.get(i).getDistanceCovered() + " meters");
            }
        }
    }
}

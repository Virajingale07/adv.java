import java.util.Random;

class MyThread extends Thread {
    private int sleepTime;
    private static Random random = new Random();

    // Constructor to hardcode the thread name
    public MyThread(String name) {
        super(name); // Setting thread name
        // Random integer between 0 and 4999
        this.sleepTime = random.nextInt(5000);
        System.out.println("STATE [NEW]: Thread " + getName() + " created.");
    }

    @Override
    public void run() {
        try {
            System.out.println("STATE [RUNNABLE]: " + getName() + " is running.");
            System.out.println(getName() + " will sleep for: " + sleepTime + " ms.");
            
            // STATE: Timed Waiting (Sleep)
            Thread.sleep(sleepTime);
            
            System.out.println("STATE [RUNNABLE]: " + getName() + " woke up.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
        // STATE: Terminated (Dead)
        System.out.println("STATE [DEAD]: Thread " + getName() + " has finished execution.");
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) {
        // Creating threads (The "New" State)
        MyThread t1 = new MyThread("Alpha");
        MyThread t2 = new MyThread("Beta");
        MyThread t3 = new MyThread("Gamma");

        // Starting threads (Moving to "Runnable" State)
        t1.start();
        t2.start();
        t3.start();
    }
}
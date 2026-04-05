public class ThreadDetails extends Thread {
    
    public ThreadDetails(String name) {
        super(name); // Set the thread name via the constructor
    }

    @Override
    public void run() {
        // Accessing the current thread's information
        System.out.println("Child Thread Name: " + getName());
        System.out.println("Child Thread Priority: " + getPriority());
    }

    public static void main(String[] args) {
        // 1. Displaying Main Thread details
        Thread mainThread = Thread.currentThread();
        System.out.println("Main Thread Name: " + mainThread.getName());
        System.out.println("Main Thread Priority: " + mainThread.getPriority());

        System.out.println("-------------------------------");

        // 2. Creating and setting a custom thread
        ThreadDetails t1 = new ThreadDetails("Custom-Worker-Thread");
        
        // Setting a custom priority (MAX_PRIORITY = 10)
        t1.setPriority(Thread.MAX_PRIORITY);
        
        // Start the thread
        t1.start();
    }
}
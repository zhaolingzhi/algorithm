package multiThread;

public class ThreadDemo01 implements Runnable{
    private int tickets = 1000;


    @Override
    public void run() {
        while (true){
            sellTickets();
            if (tickets <= 0){
                break;
            }
        }
    }

    public synchronized void sellTickets(){
        if (tickets > 0){
            System.out.println(Thread.currentThread().getName() + " " + tickets);
            tickets --;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo01 thread = new ThreadDemo01();
        Thread t1 = new Thread(thread, "t1 windows");
        Thread t2 = new Thread(thread, "t2 windows");
        t1.start();
        t2.start();
        System.out.println("exit");
    }
}

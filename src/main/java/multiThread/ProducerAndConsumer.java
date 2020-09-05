package multiThread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.*;
@Data
class CarData{
    private int id;
}

class CarStock {
    private static int count;
    private BlockingQueue<CarData> queue;

    public CarStock(BlockingQueue<CarData> queue) {
        this.queue = queue;
    }

    public synchronized void productCar() {
        try {
            CarData carData = new CarData();
            boolean success = queue.offer(carData, 2, TimeUnit.SECONDS);
            if (success){
                int id = ++count;
                carData.setId(id);
                System.out.println(Thread.currentThread().getName() + " Produce car, ID: " + id + ", Storage: " + queue.size());
                Thread.sleep(1000);
                notifyAll();
            }else {
                System.out.println(Thread.currentThread().getName() + " Produce failed");
            }
            if (queue.size() >= 100){
                System.out.println(Thread.currentThread().getName() + " Warehouse is full");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consumeCar() {
        try {
            CarData carData = queue.poll(2, TimeUnit.MILLISECONDS);
            if (carData != null){
                System.out.println(Thread.currentThread().getName() + " Get car: ID: " + carData.getId() + ", Storage: " + queue.size());
                Thread.sleep(1000);
                notifyAll();
            }else {
                System.out.println(Thread.currentThread().getName() + " Get car failed");
            }
            if (queue.size() == 0){
                System.out.println(Thread.currentThread().getName() + " Warehouse is empty");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class CarProducer implements Runnable {
    private CarStock carStock;
    private volatile boolean isRunning = true;

    public CarProducer(CarStock carStock) {
        this.carStock = carStock;
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        wait();
        System.out.println("Producer wait");
        while (isRunning){
            carStock.productCar();
            Thread.sleep(100);
        }
    }

    public void stop(){
        isRunning = false;
    }
}

class CarConsumer implements Runnable {
    private CarStock carStock;

    public CarConsumer(CarStock carStock) {
        this.carStock = carStock;
    }

    @SneakyThrows
    @Override
    public void run() {
        wait();
        System.out.println("Consumer wait");
        while (true){
            carStock.consumeCar();
            Thread.sleep(100);
        }
    }
}

public class ProducerAndConsumer {
    public void waitFunc(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "这是字符串";
        char[] sSeq = s.toCharArray();
        for(char c : sSeq){
            System.out.println((int)c);
        }


        ProducerAndConsumer p = new ProducerAndConsumer();
        p.waitFunc();
        BlockingQueue<CarData> queue = new LinkedBlockingQueue<>(1000);
        CarStock carStock = new CarStock(queue);
        ThreadFactory consumerThreadFactory = new ThreadFactoryBuilder().setNameFormat("Consumer Thread-%d").build();
        ThreadFactory producerThreadFactory = new ThreadFactoryBuilder().setNameFormat("Producer Thread-%d").build();
        ExecutorService consumerPool = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), consumerThreadFactory);
        ExecutorService producerPool = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), producerThreadFactory);
        consumerPool.submit(new CarConsumer(carStock));
        consumerPool.submit(new CarConsumer(carStock));
        producerPool.submit(new CarProducer(carStock));
        producerPool.submit(new CarProducer(carStock));
        consumerPool.shutdown();
        producerPool.shutdown();
//        consumerPool.awaitTermination(5, TimeUnit.SECONDS);
//        productorPool.awaitTermination(5, TimeUnit.SECONDS);
//        System.out.println("exit");
    }
}

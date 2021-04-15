package Model;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private final BlockingQueue<Task> tasks;
    private final AtomicInteger waitingPeriod = new AtomicInteger(0);
    private int waitingTask = 0;
    private final int numberServer;
    private boolean open = true;
    private int totalService = 0;
    public Server(int numberServer, int maxTaskPerServer)
    {
        this.numberServer = numberServer;
        this.tasks = new ArrayBlockingQueue<Task>(maxTaskPerServer);
        waitingPeriod.set(0);
    }
    public void addTask(Task newTask)
    {
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getProcessingTime());
        waitingTask = waitingTask+1;
        totalService  += totalService + newTask.getProcessingTime();
    }
    public void run() {
        while (true) {
           while(tasks.peek()!= null)
            {
                Task t = tasks.peek();
                int processing = t.getProcessingTime();
               try {
                   if(processing >= 0) {
                       Thread.sleep(1000);
                   }
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                processing--;
                t.setProcessingTime(processing);
               if(processing == 0){
                   tasks.remove(t);
                   waitingTask = waitingTask-1;
               }
               else{ waitingPeriod.set(waitingPeriod.intValue()-1);}
            }
            setClose(true);
        }
    }
    public void setClose(boolean close)
    {
        this.open = !close;
    }
    public int getWaintingTasks()
    {
        return waitingTask;
    }
    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }
    public int getService()
    {
        return totalService;
    }
    public int getNumber() {
        return numberServer;
    }
    public String toString()
    {
        String result = "\n Queue "+ getNumber()+ ": ";
        if(getWaitingPeriod().equals(0)|| tasks.peek() == null )
        {
            result += "closed";
        }
        else
        {
            result += tasks.toString();
        }
        return result;
    }

}


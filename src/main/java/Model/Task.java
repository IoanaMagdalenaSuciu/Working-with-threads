package Model;

public class Task implements Comparable<Task>{
    private int arrivalTime;
    private int processingTime;
    private int clientID;

    public Task(int id, int arrivalTime, int serviceTime){
        clientID = id;
        this.arrivalTime = arrivalTime;
        this.processingTime= serviceTime;
    }
    public int getArrivalTime() { return arrivalTime; }
    public int getProcessingTime()
    {
        return processingTime;
    }
    public void setProcessingTime(int p)
    {
        processingTime = p;
    }
    public String toString() { return "( "+clientID+", "+arrivalTime+", "+processingTime+" )"; }
    public int compareTo(Task t) {
        return arrivalTime-t.getArrivalTime();
    }
}


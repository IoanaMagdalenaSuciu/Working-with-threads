package Model;
import Controller.Controller;
import View.View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SimulationManager  implements Runnable {
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int minArrivalTime;
    public int maxArrivalTime;
    public int numberOfServers;
    public int numberOfClients;
    private final Scheduler scheduler;
    public List<Task> generatedTasks;
    public File myFile;
    public FileWriter writer;
    private final View view;
    public SimulationManager (int clients, int servers, int timer,int minArr, int maxArr,int minPro,int maxPro, View view) {
        this.numberOfClients = clients;
        this.numberOfServers = servers;
        this.timeLimit = timer;
        this.minArrivalTime = minArr;
        this.maxArrivalTime = maxArr;
        this.minProcessingTime = minPro;
        this.maxProcessingTime = maxPro;
        this.view = view;
        scheduler = new Scheduler(numberOfServers, numberOfClients);
        generateNRandomTask();
        createFile();
    }
    public int generateRandomArrivingTime() {
        return ((int)(Math.random()*(maxArrivalTime-minArrivalTime+1))+minArrivalTime) ;
    }
    public int generateRandomProsessigTime() {

        return ((int)(Math.random()*(maxProcessingTime-minProcessingTime+1))+minProcessingTime);
    }
    public void generateNRandomTask() {
        generatedTasks = new ArrayList<>(numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            Task t = new Task(i, generateRandomArrivingTime(), generateRandomProsessigTime());
            generatedTasks.add(t);
        }
        Collections.sort(generatedTasks);
    }
    public void createFile()
    {
        myFile = new File("result.txt");
       try {
           myFile.createNewFile();
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public void run() {
        int maxProcessingClients = 0, peekHour = 0, currentTime = 0;
        float avreageWait = 0, avreageService = 0;
        try { writer = new FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        while (currentTime < timeLimit ) {
            while (!generatedTasks.isEmpty() && generatedTasks.get(0).getArrivalTime() == currentTime) {
                scheduler.dispatchTask(generatedTasks.get(0));
                generatedTasks.remove(generatedTasks.get(0)); }
            for(Server s: scheduler.getServers()) {
                if(maxProcessingClients < s.getWaintingTasks()) {
                    maxProcessingClients = s.getWaintingTasks();
                    peekHour = currentTime;}
                avreageWait = avreageWait + s.getWaitingPeriod().intValue();
                avreageService = avreageService + s.getService(); }
            String result = toString(currentTime);
            try { if (writer != null) { writer.write(result); }
            } catch (IOException e) { e.printStackTrace(); }
            System.out.println(result);
            view.result.setText(result);
            currentTime = currentTime + 1;
            try { Thread.sleep(1000); } catch (Exception e) { } }
        avreageWait = (avreageWait/scheduler.getServers().size())/currentTime;
        avreageService = (avreageService/scheduler.getServers().size())/currentTime;
        try { if (writer != null) {
                writer.write("\nPeek Hour: "+peekHour+"\nAvreage wait: "+avreageWait+"\nAvreage service: "+avreageService);
                writer.close();}
        } catch (IOException e) {e.printStackTrace();} }
        public void setStrategy(SelectionPolicy policy)
    {
        scheduler.changeStrategy(policy);
    }
    public String toString(int currentTime)
    {
        String result ="\nTime: "+currentTime+"\n";
        result = result+"Waiting clients: ";
        for (Task t:generatedTasks) {
            result = result+t.toString();
        }
        result = result+scheduler.toString();
        return result;
    }
    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }
}
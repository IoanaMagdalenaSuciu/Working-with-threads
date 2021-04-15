package Model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Server> servers;

    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer){
        this.servers = new ArrayList<Server>(maxNoServers);
        ArrayList<Thread> threads = new ArrayList<Thread>(maxNoServers);
        for (int i = 0; i < maxNoServers; i++) {
            servers.add(new Server(i, maxTasksPerServer));
            threads.add(new Thread(servers.get(i)));
            threads.get(i).start();
        }
    }
    public  void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreyeStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }
    public void dispatchTask(Task t){
        strategy.addTask(servers,t);
    }
    public List<Server> getServers()
    {
        return servers;
    }
    public String toString()
    {
        String result = "";
        for(Server s: servers)
            result += s.toString();
        return result;
    }

    }


package Model;

import java.util.List;

public class ConcreyeStrategyQueue implements Strategy {
    public void addTask(List<Server> servers, Task t)
    {
        int minQueue = 1000;
        int saveIndex = 0;
        for(Server s: servers)
        {
            if(s.getWaintingTasks()<minQueue){
                minQueue = s.getWaintingTasks();
                saveIndex = s.getNumber();
            }
        }
        for(Server s: servers){
            if(s.getNumber() == saveIndex) {
                s.setClose(false);
                s.addTask(t);
            }
        }
    }
}

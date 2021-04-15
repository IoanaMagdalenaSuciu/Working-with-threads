package Model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyTime implements Strategy {
    public void addTask(List<Server> servers, Task t){
        AtomicInteger minTime = new AtomicInteger(100000);
        int saveIndex = 0;
        for(Server s: servers)
        {
            if(s.getWaitingPeriod().get()<minTime.get()){
               minTime = s.getWaitingPeriod();
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

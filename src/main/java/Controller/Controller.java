package Controller;

import View.View;
import Model.SelectionPolicy;
import Model.SimulationManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller  {
    private final View view;
    private SelectionPolicy strategy;
    public Controller()
    {
        this.view = new View();
        view.getStart(new Listener());
        view.getStrategyQueue(new queueListener());
        view.getStrategyTime(new timerListener());
    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            SimulationManager manager = new SimulationManager(view.getClients(), view.getServers(), view.simTimer(), view.getMinArr(), view.getMaxArr(), view.getMinProcessing(), view.getMaxProcessing(), view);
                manager.setStrategy(strategy);
                Thread t = new Thread(manager);
                t.start();


            }
        }

    class queueListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        strategy = SelectionPolicy.SHORTEST_QUEUE;
        }
    }
    class timerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
       strategy = SelectionPolicy.SHORTEST_TIME;
        }
    }


}

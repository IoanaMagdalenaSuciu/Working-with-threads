package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JTextField clients = new JTextField();
    JTextField servers = new JTextField();
    JTextField minArrival = new JTextField();
    JTextField maxArrival = new JTextField();
    JTextField minProcessing = new JTextField();
    JTextField maxProcessing = new JTextField();
    JTextField sim = new JTextField();
    JLabel titlu = new JLabel("QUEUES SIMULATOR");
    JLabel clientsLabel = new JLabel("Number of tasks: ");
    JLabel serverLabel = new JLabel("Number of servers: ");
    JLabel minArrLabel = new JLabel("Minimum Arrival Time: ");
    JLabel maxArrLabel = new JLabel("Maximum Arrival Time: ");
    JLabel minProLabel = new JLabel("Minimum Processing Time: ");
    JLabel maxProLabel = new JLabel("Max Processing Time: ");
    JLabel simLabel = new JLabel("The Simulation Time");
    JButton StrategyTime = new JButton("Strategy Time");
    JButton StrategyQueue = new JButton("Strategy Queue");
    JButton start = new JButton("Start");
    JButton clear = new JButton("Clear");
    public JTextArea result = new JTextArea();
    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Simulator");
        this.setResizable(true);
        this.setSize(900, 550);
        this.setVisible(true);
        this.setLayout(null);
        //    this.setLayout(null);

        panel1.setBounds(0,0,900,60);
        panel2.setBounds(350,60,550,340);
        panel5.setBounds(0,60,350,340);
        panel4.setBounds(0,400,900,250);

        panel1.setBackground(new Color(330000));
        panel2.setBackground(new Color(330000));
        panel4.setBackground(new Color(330000));
        panel5.setBackground(new Color(330000));



        titlu.setForeground(new Color(0xf9c806));
        titlu.setFont(new Font("Curban", Font.BOLD, 30));
        titlu.setOpaque(true);
        titlu.setHorizontalAlignment((JLabel.CENTER));
        titlu.setBackground(new Color(330000));
        titlu.setVerticalTextPosition(JLabel.TOP);
        panel1.add(titlu);

        panel5.setLayout(null);
        clientsLabel.setForeground(new Color(0xc2bcbc));
        serverLabel.setForeground(new Color(0xc2bcbc));
        minArrLabel.setForeground(new Color(0xc2bcbc));
        maxArrLabel.setForeground(new Color(0xc2bcbc));
        minProLabel.setForeground(new Color(0xc2bcbc));
        maxProLabel.setForeground(new Color(0xc2bcbc));
        simLabel.setForeground(new Color(0xc2bcbc));

        clientsLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        serverLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        minArrLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        maxArrLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        minProLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        maxProLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        simLabel.setFont(new Font("Courier", Font.ITALIC, 20));
        // clientsLabel.setBounds(0,0,0,0);
        //  serverLabel.setBounds(0,0,50,50);
        clientsLabel.setHorizontalAlignment(JLabel.LEFT);
        serverLabel.setHorizontalAlignment(JLabel.LEFT);
        minArrLabel.setHorizontalAlignment(JLabel.LEFT);
        maxArrLabel.setHorizontalAlignment(JLabel.LEFT);
        minProcessing.setHorizontalAlignment(JLabel.LEFT);
        maxProcessing.setHorizontalAlignment(JLabel.LEFT);
        simLabel.setHorizontalAlignment(JLabel.LEFT);

        clients.setBackground(new Color(0xff9f80));
        servers.setBackground(new Color(0xff9f80));
        minArrival.setBackground(new Color(0xff9f80));
        maxArrival.setBackground(new Color(0xff9f80));
        minProcessing.setBackground(new Color(0xff9f80));
        maxProcessing.setBackground(new Color(0xff9f80));
        sim.setBackground(new Color(0xff9f80));
        clientsLabel.setBounds(10,0,300,80);
        serverLabel.setBounds(10,30,300,80);
        minArrLabel.setBounds(10,60,300,80);
        maxArrLabel.setBounds(10,90,300,80);
        minProLabel.setBounds(10,120,300,80);
        maxProLabel.setBounds(10,150,300,80);
        simLabel.setBounds(10,180,300,80);
        clients.setBounds(260,25,50, 27);
        servers.setBounds(260,55,50, 27);
        minArrival.setBounds(260,85,50, 27);
        maxArrival.setBounds(260,115,50, 27);
        minProcessing.setBounds(260,145,50, 27);
        maxProcessing.setBounds(260,175,50, 27);
        sim.setBounds(260,205,50, 27);

        clients.setFont(new Font("Comic Sans", Font.BOLD, 25));
        servers.setFont(new Font("Comic Sans", Font.BOLD, 25));
        minArrival.setFont(new Font("Comic Sans", Font.BOLD, 25));
        maxArrival.setFont(new Font("Comic Sans", Font.BOLD, 25));
        minProcessing.setFont(new Font("Comic Sans", Font.BOLD, 25));
        maxProcessing.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sim.setFont(new Font("Comic Sans", Font.BOLD, 25));



        panel5.add(clientsLabel);
        panel5.add(clients);
        panel5.add(serverLabel);
        panel5.add(servers);
        panel5.add(minArrLabel);
        panel5.add(minArrival);
        panel5.add(maxArrival);
        panel5.add(maxArrLabel);
        panel5.add(maxArrival);
        panel5.add(minProLabel);
        panel5.add(minProcessing);
        panel5.add(maxProLabel);
        panel5.add(maxProcessing);
        panel5.add(simLabel);
        panel5.add(sim);

        panel2.setLayout(null);
        start.setFont(new Font("Comic Sans", Font.BOLD, 25));
        start.setBackground(new Color(0xff9f80));
        start.setBounds(100,50,250,50);
        start.setForeground(new Color(330000));
        result.setBackground(new Color(330000));
        result.setBounds(0, 110, 500, 300);
        result.setForeground(new Color(0xf9c806));
        result.setFont(new Font("Courier", Font.ITALIC | Font.BOLD, 15));
        result.setEditable(false);
        panel2.add(result);
        panel2.add(start);


        panel4.setLayout(null);
        StrategyQueue.setBounds(170,5,200,50);
        StrategyTime.setBounds(390,5,200,50);
        StrategyQueue.setFont(new Font("Comic Sans", Font.BOLD, 20));
        StrategyQueue.setBackground(new Color(0xff3333));
        StrategyTime.setHorizontalAlignment(JButton.CENTER);
        StrategyQueue.setForeground(new Color(330000));
        panel4.add(StrategyQueue);
        StrategyTime.setFont(new Font("Comic Sans", Font.BOLD, 20));
        StrategyTime.setHorizontalAlignment(JButton.CENTER);
        StrategyTime.setBackground(new Color(0xff3333));
        StrategyTime.setForeground(new Color(330000));
        panel4.add(StrategyTime);

        this.add(panel1);
        this.add(panel2);
        this.add(panel4);
        this.add(panel5);
    }
    public int getClients() { return Integer.parseInt(clients.getText()); }
    public int getServers(){
        return Integer.parseInt(servers.getText());
    }
    public int getMinArr(){ return Integer.parseInt(minArrival.getText()); }
    public int getMaxArr(){ return Integer.parseInt(maxArrival.getText()); }
    public int getMinProcessing(){
        return Integer.parseInt(minProcessing.getText());
    }
    public int getMaxProcessing(){ return Integer.parseInt(maxProcessing.getText()); }
    public int simTimer(){ return Integer.parseInt(sim.getText()); }
    public void getStart(ActionListener listener) { start.addActionListener(listener); }
    public void getStrategyTime(ActionListener listener)
    {
        StrategyTime.addActionListener(listener);
    }
    public void  getStrategyQueue(ActionListener listener)
    {
        StrategyQueue.addActionListener(listener);
    }


}

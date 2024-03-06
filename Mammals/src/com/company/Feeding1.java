package com.company;

import java.util.List;

public class Feeding1 extends Thread{
    private final Bufor bufor;
    private List<Mammal> list;
    private Mammal m;

    public Feeding1(List<Mammal> list, Bufor bufor){
            this.bufor = bufor;
            this.list = list;
            m=list.get(0);
    }
    private int day = 0;
    @Override
    public void run() {
        while (day < 365){
            day+=1;
            double weight=m.getBody_wt();
            weight*=1+(Math.random()*1.5+0.5)/100;
            m.setBody_wt(weight);
            this.bufor.put(weight);
            System.out.println("Animal No. 1 was fed, day: " + day);
        }
    }
}

package com.company;

import java.util.List;

public class Burning1 extends Thread{

    private final Bufor bufor;
    private List<Mammal> list;
    private Mammal m;
    private int day = 0;
    public Burning1(Bufor bufor,List<Mammal> list){
        this.bufor = bufor;
        this.list=list;
        m=list.get(0);
    }

    @Override
    public void run() {
        while(day<365) {
            day+=1;
            double weight = bufor.get();
            weight*= 1 - (1.4 / 100);
            m.setBody_wt(weight);
            System.out.println("Animal No. 1 burnt calories, the weight is: " + weight+"kg");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(day==365) System.out.println("Weight of the animal No. 1 was: "+list.get(0).getBody_wt()+"kg, " +
                    "after one year it's: "+weight+"kg. The difference is: "+(weight-list.get(0).getBody_wt())+"kg");
        }
        }
    }

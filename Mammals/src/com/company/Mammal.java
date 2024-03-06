package com.company;

public class Mammal implements Comparable<Mammal> {

    private double body_wt;
    private double brain_wt;
    private double not_dreaming;
    private double dreaming;
    private double total_sleep;
    private double life_span;
    private double gestation;
    private int predation;
    private int exposure;
    private int danger;

    public Mammal(double body_wt, double brain_wt, double not_dreaming, double dreaming, double total_sleep, double life_span, double gestation, int predation, int exposure, int danger) {
        this.predation = predation;
        this.exposure = exposure;
        this.danger = danger;
        this.body_wt = body_wt;
        this.brain_wt = brain_wt;
        this.not_dreaming = not_dreaming;
        this.dreaming = dreaming;
        this.total_sleep = total_sleep;
        this.life_span = life_span;
        this.gestation = gestation;
    }

    public double getBody_wt() {
        return body_wt;
    }

    public void setBody_wt(double body_wt) {
        this.body_wt = body_wt;
    }

    public double getBrain_wt() {
        return brain_wt;
    }

    public double getNot_dreaming() {
        return not_dreaming;
    }

    public double getDreaming() {
        return dreaming;
    }

    public double getTotal_sleep() {
        return total_sleep;
    }

    public double getLife_span() {
        return life_span;
    }

    public double getGestation() {
        return gestation;
    }

    public int getPredation() {
        return predation;
    }

    public int getExposure() {
        return exposure;
    }

    public int getDanger() {
        return danger;
    }

    public String getBody_wt2() {
        if (body_wt == 0.0) return "unknown";
        else return body_wt + "";
    }
    public String getBrain_wt2() {
        if (brain_wt == 0.0) return "unknown";
        else return brain_wt + "";
    }

    public String getNot_dreaming2() {
        if (not_dreaming == 0.0) return "unknown";
        else return not_dreaming + "";
    }

    public String getDreaming2() {
        if (dreaming == 0.0) return "unknown";
        else return dreaming + "";
    }

    public String getTotal_sleep2() {
        if (total_sleep == 0.0) return "unknown";
        else return total_sleep + "";
    }

    public String getLife_span2() {
        if (life_span == 0.0) return "unknown";
        else return life_span + "";
    }

    public String getGestation2() {
        if (gestation == 0.0) return "unknown";
        else return gestation + "";
    }


    @Override
    public String toString() {
        return "Mammals{" +
                "body_wt=" + getBody_wt2() +
                ", brain_wt=" + getBrain_wt2() +
                ", not_dreaming=" + getNot_dreaming2() +
                ", dreaming=" + getDreaming2() +
                ", total_sleep=" + getTotal_sleep2() +
                ", life_span=" + getLife_span2() +
                ", gestation=" + getGestation2() +
                ", predation=" + predation +
                ", exposure=" + exposure +
                ", danger=" + danger +
                '}';
    }

    @Override
    public int compareTo(Mammal o) {
        if (this.body_wt > o.body_wt) {
            return 1;
        } else {
            return -1;
        }
    }

    public int comTo(Mammal o) {
        if (this.dreaming / this.total_sleep > o.dreaming / o.total_sleep) {
            return -1;
        } else {
            return 1;
        }
    }
    public int comTo2(Mammal o) {
        if (this.body_wt > o.body_wt) {
            return -1;
        } else {
            return 1;
        }
    }

    public double dreamingPercentage() {
        double percentage = (this.getDreaming()/this.getTotal_sleep())*100;
        return Math.round(percentage*100.0)/100.0;
    }
}


package com.example.demo.model;

import java.util.Date;

public class Clock {
    private int clock_id;
    private int habit_id;

//    1签到，2补签，3请假
    private int state;
    private Date date;

    public int getClock_id() {
        return clock_id;
    }

    public void setClock_id(int clock_id) {
        this.clock_id = clock_id;
    }

    public int getHabit_id() {
        return habit_id;
    }

    public void setHabit_id(int habit_id) {
        this.habit_id = habit_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package com.example.waractivitycontroller.model.persistence.object;

import android.support.annotation.NonNull;

/**
 * @author Oliver
 */
public class Player {

    private long id;
    private String name;
    private int level;
    private int year;
    private int month;
    private int day;

    public Player(long id, @NonNull String name, int level, int year, int month, int day){
        this.id = id;
        this.name = name;
        this.level = level;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Player(@NonNull String name, int level, int year, int month, int day){
        this.name = name;
        this.level = level;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //<editor-fold desc="Getter & Setter" defaultState="collapsed">

    @SuppressWarnings("unused")
    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(long id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public int getLevel() {
        return level;
    }

    @SuppressWarnings("unused")
    public void setLevel(int level) {
        this.level = level;
    }

    @SuppressWarnings("unused")
    public int getYear() {
        return year;
    }

    @SuppressWarnings("unused")
    public void setYear(int year) {
        this.year = year;
    }

    @SuppressWarnings("unused")
    public int getMonth() {
        return month;
    }

    @SuppressWarnings("unused")
    public void setMonth(int month) {
        this.month = month;
    }

    @SuppressWarnings("unused")
    public int getDay() {
        return day;
    }

    @SuppressWarnings("unused")
    public void setDay(int day) {
        this.day = day;
    }

    public String getMonthAsString() {
        switch (month){
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "Jan";
        }
    }

    //</editor-fold>
}

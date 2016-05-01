package com.example.must.mobilehomework.model;

import java.util.ArrayList;
import java.util.List;

public class DateSelection {
    private List<String> monthList;
    private List<String> dayList;

    public DateSelection(){
        monthList = new ArrayList<>();
        monthList.add("Ocak");
        monthList.add("Şubat");
        monthList.add("Mart");
        monthList.add("Nisan");
        monthList.add("Mayıs");
        monthList.add("Haziran");
        monthList.add("Temmuz");
        monthList.add("Ağustos");
        monthList.add("Eylül");
        monthList.add("Ekim");
        monthList.add("Kasım");
        monthList.add("Aralık");

        dayList = new ArrayList<>();
        for(int i=1; i<31; i++){
            dayList.add(""+i);
        }
    }

    public List<String> getMonthList(){
        return monthList;
    }

    public List<String> getDayList(){
        return dayList;
    }
}

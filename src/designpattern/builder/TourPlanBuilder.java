package designpattern.builder;

import java.time.LocalDate;

public interface TourPlanBuilder {
    TourPlanBuilder title(String title);

    TourPlanBuilder nightsAndDays(int nights, int days);

    TourPlanBuilder startDate(LocalDate localDate);

    TourPlanBuilder whereToStay(String whereToSay);

    TourPlanBuilder addPlan(int day, String plan);

    TourPlan getPlan();
}

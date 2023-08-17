package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Project {
    private String name;
    private String clientName;
    private String type;
    private Calendar startDate;
    private Calendar endDate;
    private double budget;

    public Project(String name, String clientName, String type, String startDateStr, String endDateStr, double budget) {
        this.name = name;
        this.clientName = clientName;
        this.type = type;
        this.startDate = parseDate(startDateStr);
        this.endDate = parseDate(endDateStr);
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public String getClientName() {
        return clientName;
    }

    public String getType() {
        return type;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }

    private Calendar parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear fecha.");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public boolean isFinishedBeforeDate(Calendar date) {
        return endDate.before(date);
    }

    public boolean isStartingAfterDate(Calendar date) {
        return startDate.after(date);
    }

    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String startDateStr = formatter.format(startDate.getTime());

        String endDateStr = formatter.format(endDate.getTime());

        return String.format("%s - %s - %s - %s - %s - %.2f", name, clientName, type, startDateStr, endDateStr, budget);
    }
}

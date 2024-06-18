package org.example.Switchstatement;

public class Selectday {
    public static void main(String[] args) {

        Day day = Day.FRIDAY;
        System.out.println(
                switch (day) {
                    case MONDAY, FRIDAY, SUNDAY -> 6;
                    case TUESDAY -> 7;
                    case THURSDAY, SATURDAY -> 8;
                    case WEDNESDAY -> 9;
                    default -> throw new IllegalStateException("Invalid day: " + day);
                }
        );
    }
}


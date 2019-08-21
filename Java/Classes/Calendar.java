package Classes;

public class Calendar extends Seasoning {

    private final int START_YEAR = 1900;
    private final Day START_DAY = Day.Monday;

    public int day;
    public int year;
    public Month month;
    public Day dayName;

    private Calendar() {
        this.year = 1900;
        this.month = Month.January;

        this.day = 1;
        this.dayName = Day.Monday;
    }

    public static Calendar from(int year, Month month, int day) {
        return new Calendar().moveTo(year, month, day);
    }

    /**
     * Move to the correct date
     * @param year Year integer
     * @param month Month enum
     * @param day Day integer
     * @return itself
     */
    private Calendar moveTo(int year, Month month, int day) {
        // Jump years
        int diff_years = year - START_YEAR;
        for (int i=0; i<diff_years; i++)
            nextYear();

        // Jump months
        // TODO: Jump
        this.month = month;

        // Jump days
        for (int i=1; i<day; i++) {
            nextDay();
        }

        return this;
    }

    /**
     * Move to the next day
     * @return itself
     */
    public Calendar nextDay() {
        if (day >= month.getDays()) {
            if (day == month.getDays() && month == Month.February && isLeapYear())
                day++;
            else {
                day = 1;
                month = month.next();

                // Check if next year
                if (month == Month.January) {
                    year++;
                }
            }
        } else {
            day++;
        }

        dayName = dayName.next();
        return this;
    }

    /**
     * Move to the next month
     * @return itself
     */
    public Calendar nextMonth() {
        int daysToSkip = month.getDays();

        // Check for leap years
        if (month == Month.February && isLeapYear())
            daysToSkip++;

        for(int i=0; i<daysToSkip; i++) {
            nextDay();
        }
        return this;
    }

    /**
     * Move to the next month
     * @return itself
     */
    public Calendar nextYear() {
        for(int i=0; i<12; i++) {
            nextMonth();
        }
        return this;
    }

    /**
     * A leap year is a year which is a year which is divisable by 4
     *  unless it is also evenly divisable by 100 (unless it is divisable by 400).
     */
    public boolean isLeapYear() {
        if (year % 4 != 0)
            return false;

        if (year % 100 == 0 && year % 400 != 0)
            return false;

        return true;
    }
}

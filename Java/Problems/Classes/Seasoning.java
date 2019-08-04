package Problems.Classes;

public class Seasoning {
    public enum Day {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday;

        private static Day[] vals = values();
        public Day next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    public enum Month {
        January(31),
        February(28),
        March(31),
        April(30),
        May(31),
        June(30),
        July(31),
        August(31),
        September(30),
        October(31),
        November(30),
        December(31);

        private final int days;
        private Month(int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

        private static Month[] vals = values();
        public Month next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }
}

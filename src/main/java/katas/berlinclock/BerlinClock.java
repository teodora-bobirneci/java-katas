package katas.berlinclock;

class BerlinClock {
    private static final int RED_ROW_1_LENGTH = 4;

    private int hours;
    private int minutes;
    private int seconds;

    BerlinClock(String time) {
        if (time == null)
            throw new IllegalArgumentException("The time cannot be null.");
        String[] timeArray = time.split(":");
        this.hours = Integer.parseInt(timeArray[0]);
        this.minutes = Integer.parseInt(timeArray[1]);
        this.seconds = Integer.parseInt(timeArray[2]);
    }

    String topLight() {
        return seconds % 2 == 0 ? "Y" : "O";
    }

    String firstRedLightRow() {
        StringBuilder redRow1 = new StringBuilder();
        int noOfRedLightsOnRow1 = hours / 5;
        for (int i = 0; i < noOfRedLightsOnRow1; i++) {
            redRow1.append("R");
        }
        pad(redRow1, "O", RED_ROW_1_LENGTH);
        return redRow1.toString();
    }

    String secondRedLightRow() {
        StringBuilder redRow1 = new StringBuilder();
        int noOfRedLightsOnRow1 = hours % 5;
        for (int i = 0; i < noOfRedLightsOnRow1; i++) {
            redRow1.append("R");
        }
        pad(redRow1, "O", RED_ROW_1_LENGTH);
        return redRow1.toString();
    }

    private void pad(StringBuilder s, String with, int desiredLength) {
        if (s.length() >= desiredLength) {
            return;
        }
        for (int i = s.length(); i < desiredLength; i++) {
            s.append(with);
        }
    }

    @Override
    public String toString() {
        return seconds + "/n";
    }
}

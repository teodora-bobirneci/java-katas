package katas.berlinclock;

class BerlinClock {
    private static final int RED_ROW_LENGTH = 4;
    private static final int RED_YELOW_ROW_LENGTH = 11;

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
        pad(redRow1, "O", RED_ROW_LENGTH);
        return redRow1.toString();
    }

    String secondRedLightRow() {
        StringBuilder redRow1 = new StringBuilder();
        int noOfRedLightsOnRow1 = hours % 5;
        for (int i = 0; i < noOfRedLightsOnRow1; i++) {
            redRow1.append("R");
        }
        pad(redRow1, "O", RED_ROW_LENGTH);
        return redRow1.toString();
    }

    String yellowRedLightRow() {
        StringBuilder s = new StringBuilder();
        pad(s, "O", RED_YELOW_ROW_LENGTH);
        int noOfRedLightsOn = minutes / 15;
        int noOfYellowLightsOn = minutes / 5 - noOfRedLightsOn;

        for (int i = 0; i < noOfYellowLightsOn+noOfRedLightsOn; i++) {
            if ((i+1) % 3 == 0) {
                s.replace(i, i + 1, "R");
            } else {
                s.replace(i, i + 1, "Y");
            }
        }

        return s.toString();
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
        return topLight() + "\n" + firstRedLightRow() + "/n" + secondRedLightRow() + "\n" + yellowRedLightRow() + "\n";
    }
}

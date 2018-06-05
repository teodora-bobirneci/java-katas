package katas.berlinclock;


import static katas.berlinclock.Light.OFF;
import static katas.berlinclock.Light.RED_LIGHT;
import static katas.berlinclock.Light.YELLOW_LIGHT;


class BerlinClock
{
	private static final String TIME_DELIMITER = ":";

	private static final int RED_ROW_LENGTH = 4;
	private static final int RED_YELOW_ROW_LENGTH = 11;
	private static final int YELLOW_ROW_LENGTH = 4;

	private int hours;
	private int minutes;
	private int seconds;

	BerlinClock(String time) {
		if (time == null)
			throw new IllegalArgumentException("The time cannot be null.");
		String[] timeArray = time.split(TIME_DELIMITER);
		this.hours = Integer.parseInt(timeArray[0]);
		this.minutes = Integer.parseInt(timeArray[1]);
		this.seconds = Integer.parseInt(timeArray[2]);
	}

	String topLight() {
		return seconds % 2 == 0 ? YELLOW_LIGHT.code() : OFF.code();
	}

	String firstRedLightRow() {
		StringBuilder redRow1 = new StringBuilder();
		int noOfRedLightsOnRow1 = hours / 5;
		for (int i = 0; i < noOfRedLightsOnRow1; i++)
		{
			redRow1.append(RED_LIGHT.code());
		}
		pad(redRow1, OFF.code(), RED_ROW_LENGTH);
		return redRow1.toString();
	}

	String secondRedLightRow() {
		StringBuilder redRow1 = new StringBuilder();
		int noOfRedLightsOnRow1 = hours % 5;
		for (int i = 0; i < noOfRedLightsOnRow1; i++) {
			redRow1.append(RED_LIGHT.code());
		}
		pad(redRow1, OFF.code(), RED_ROW_LENGTH);
		return redRow1.toString();
	}

	String yellowRedLightRow() {
		StringBuilder s = new StringBuilder();
		pad(s, OFF.code(), RED_YELOW_ROW_LENGTH);
		int noOfRedLightsOn = minutes / 15;
		int noOfYellowLightsOn = minutes / 5 - noOfRedLightsOn;

		for (int i = 0; i < noOfYellowLightsOn + noOfRedLightsOn; i++) {
			if ((i + 1) % 3 == 0) {
				s.replace(i, i + 1, RED_LIGHT.code());
			}
			else {
				s.replace(i, i + 1, YELLOW_LIGHT.code());
			}
		}
		return s.toString();
	}

	String bottomYellowRow() {
		StringBuilder bottomYellowRow = new StringBuilder();
		pad(bottomYellowRow, OFF.code(), YELLOW_ROW_LENGTH);

		int noOfYellowLightsOn = minutes % 5;
		for (int i = 0; i < noOfYellowLightsOn; i++) {
			bottomYellowRow.replace(i, i + 1, YELLOW_LIGHT.code());
		}

		return bottomYellowRow.toString();
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
		return topLight() + "\n" + firstRedLightRow() + "/n" + secondRedLightRow() + "\n" + yellowRedLightRow() + "\n"
				+ bottomYellowRow() + "\n";
	}
}

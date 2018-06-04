package katas.berlinclock;

class BerlinClock
{
	private final String[] digitalTime;

	BerlinClock(String time)
	{
		this.digitalTime = time.split(":");
	}


	String topLight()
	{
		return Integer.parseInt(digitalTime[2]) % 2 == 0 ? "Y" : "O";
	}
}

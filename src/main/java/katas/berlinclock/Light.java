package katas.berlinclock;

public enum Light
{
	YELLOW_LIGHT("Y"),
	RED_LIGHT("R"),
	OFF("O");

	private final String code;

	Light(String code) {
		this.code = code;
	}

	String code(){
		return code;
	}
}


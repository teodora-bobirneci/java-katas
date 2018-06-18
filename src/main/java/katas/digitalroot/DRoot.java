package katas.digitalroot;

class DRoot
{

	static int digital_root(int n)
	{
		if (n < 10)
			return n;
		return digital_root(sumOfDigits(n));
	}

	private static int sumOfDigits(final int n)
	{
		int s = 0;
		int num = n;

		while (num > 0)
		{
			s += num % 10;
			num = num / 10;
		}

		return s;
	}

}

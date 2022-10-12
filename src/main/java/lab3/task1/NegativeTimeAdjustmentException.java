package lab3.task1;

public class NegativeTimeAdjustmentException extends Exception {
	private String message;
	private int timespanValue;
	
	public NegativeTimeAdjustmentException(int timespanValue, String message)
	{
		this.timespanValue = timespanValue;
		this.message = message;
	}
	public NegativeTimeAdjustmentException(int timespanValue)
	{
		this(timespanValue, "Failed to adjust clock by negative timespan");
	}
	
	@Override
	public String toString()
	{
		return String.format("NegativeTimeAdjustmentException: \n\tmessage: %s\n\ttimespanValue", message, timespanValue);
	}
	
	public String getMessage()
	{
		return message;
	}
	public int getTimespan()
	{
		return timespanValue;
	}
}

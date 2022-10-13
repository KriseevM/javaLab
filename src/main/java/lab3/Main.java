package lab3;

import java.util.Random;
import lab3.task1.AnalogClock;
import lab3.task1.AnalogClockWithSeconds;
import lab3.task1.ClockStore;
import lab3.task1.IClock;
import lab3.task1.NegativeTimeAdjustmentException;
import lab3.task1.Unit;
import lab3.task1.UnsupportedUnitTypeException;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();

		IClock clock1 = new AnalogClock(rnd.nextInt(), rnd.nextInt(), 20.0, "brand 2");
		IClock clock2 = new AnalogClockWithSeconds(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), 99.0, "brand 2");
		IClock clock3 = new AnalogClock(rnd.nextInt(), rnd.nextInt(), 20.0, "brand 1");
		IClock clock4 = new AnalogClockWithSeconds(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), 50.0, "brand 2");
		System.out.println(clock1);
		System.out.println(clock2);
		System.out.println(clock3);
		System.out.println(clock4);
		ClockStore store = new ClockStore();
		store.add(clock1);
		store.add(clock2);
		store.add(clock3);
		store.add(clock4);
		for (String s : store.getSortedBrandNamesArray()) {
			System.out.println(s);
		}
		System.out.println(store.getMostCommonBrandName());
		System.out.println(store.getMostExpensiveClock());

	}

	public static void testClockWithSeconds(IClock clock)
			throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException {
		testClock(clock);
		System.out.println("Adjusting time by 15 seconds...");
		clock.addTime(Unit.SECOND, 15);
		System.out.println(clock);
		System.out.println("Adjusting time by 45 seconds...");
		clock.addTime(Unit.SECOND, 45);
		System.out.println(clock);
		System.out.println("Adjusting time by 95 seconds...");
		clock.addTime(Unit.SECOND, 95);
		System.out.println(clock);
		System.out.println("Adjusting time by 3900 seconds...");
		clock.addTime(Unit.SECOND, 3900);
		System.out.println(clock);
	}

	public static void testClock(IClock clock) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException {
		System.out.println("\n ----- Starting clock test ----- \n");
		System.out.println(clock);
		System.out.println("Adjusting time by 1h and 10 minutes...");
		clock.addTime(Unit.HOUR, 1);
		clock.addTime(Unit.MINUTE, 10);
		System.out.println(clock);
		System.out.println("Adjusting time by 10h and 50 minutes...");
		clock.addTime(Unit.HOUR, 10);
		clock.addTime(Unit.MINUTE, 50);
		System.out.println(clock);
		System.out.println("Adjusting time by 600 minutes");
		clock.addTime(Unit.MINUTE, 600);
		System.out.println(clock);
		System.out.println("Adjusting time by 25 hours");
		clock.addTime(Unit.HOUR, 25);
		System.out.println(clock);
	}

}

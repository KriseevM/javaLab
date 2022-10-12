package lab3.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class ClockStore {
	private ArrayList<IClock> clocks;
	private TreeMap<String, Integer> brandNames;

	public ClockStore() {
		clocks = new ArrayList<>();
		brandNames = new TreeMap<>();
	}

	public void AddTimeOnAllClocks(Unit unit, int time) throws NegativeTimeAdjustmentException {
		for (IClock clock : clocks) {
			try {
				clock.addTime(unit, time);
			} catch (UnsupportedUnitTypeException e) {
			}
		}
	}

	public String[] getSortedBrandNamesArray() {
		return brandNames.keySet().toArray(new String[0]);
	}

	public void add(IClock clock) {
		clocks.add(clock);
		if (brandNames.containsKey(clock.getBrandName())) {
			brandNames.compute(clock.getBrandName(), (k, v) -> v + 1);
		} else {
			brandNames.put(clock.getBrandName(), 1);
		}
	}

	public void remove(IClock clock) {
		clocks.remove(clock);
		brandNames.compute(clock.getBrandName(), (k, v) -> v - 1);
	}

	public String getMostCommonBrandName() {
		Integer maxCount = 0;
		String maxBrandName = "";
		for (String key : brandNames.keySet()) {
			Integer count = brandNames.get(key);
			if (count > maxCount) {
				maxCount = count;
				maxBrandName = key;
			}
		}
		return maxBrandName;
	}

	public IClock getMostExpensiveClock() {
		return Collections.max(clocks, new Comparator<IClock>() {

			@Override
			public int compare(IClock o1, IClock o2) {
				return Double.compare(o1.getPrice(), o2.getPrice());
			}

		});
	}
}

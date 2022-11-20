package lab3.task1.logic;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class ClockStore {
	public ArrayList<IClock> getClocks() {
		return clocks;
	}

	private ArrayList<IClock> clocks;
	private TreeMap<String, Integer> brandNames;

	public ClockStore() {
		clocks = new ArrayList<>();
		brandNames = new TreeMap<>();
	}
	public void addTimeOnAllClocks(Unit unit, int time) throws NegativeTimeAdjustmentException {
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
		if(brandNames.get(clock.getBrandName()) == 0)
			brandNames.remove(clock.getBrandName());
	}

	public String getMostCommonBrandName() {
		/*
		 * Integer maxCount = 0; String maxBrandName = ""; for (String key :
		 * brandNames.keySet()) { Integer count = brandNames.get(key); if (count >
		 * maxCount) { maxCount = count; maxBrandName = key; } } return maxBrandName;
		 */
		if(clocks.isEmpty()) return "None";
		return brandNames.entrySet().stream().max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).get()
				.getKey();
	}

	public IClock getMostExpensiveClock() {
		if(clocks.isEmpty()) return null;
		return Collections.max(clocks, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
	}
}

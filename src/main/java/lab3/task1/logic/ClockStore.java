package lab3.task1.logic;


import com.google.gson.annotations.Expose;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lab3.task1.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ClockStore implements Serializable {
	public List<IClock> getClocks() {
		return clocks;
	}
	private ArrayList<IClock> clocks;
	private TreeMap<String, Integer> brandNames;

	public ClockStore()
	{
		this(false);
	}
	public ClockStore(Boolean loadFromDb) {
		this.clocks = new ArrayList<>();
		brandNames = new TreeMap<>();
		System.out.println("clock store ctor");
		if(loadFromDb) {
			try (Session s = HibernateSessionFactory.getSessionFactory().openSession()) {
				Query<Clock> q;
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Clock> cr = cb.createQuery(Clock.class);
				Root<Clock> root = cr.from(Clock.class);
				cr.select(root);
				q = s.createQuery(cr);
				List<Clock> loaded = q.getResultList();
				for (IClock clock : loaded) {
					addToList(clock);
				}
			}
		}
	}
	public void addTimeOnAllClocks(Unit unit, int time) throws NegativeTimeAdjustmentException {
		for (IClock clock : clocks) {
			try {
				clock.addTime(unit, time);
			} catch (UnsupportedUnitTypeException ignored) {
			}
		}
	}

	public String[] getSortedBrandNamesArray() {
		return brandNames.keySet().toArray(new String[0]);
	}

	public void add(IClock clock) {
		if(clocks.contains(clock)) return;
		addToList(clock);
		try (Session s = HibernateSessionFactory.getSessionFactory().openSession()) {
			Transaction t = s.beginTransaction();
			s.persist(clock);
			t.commit();
		}
	}

	private void addToList(IClock clock) {
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
		try (Session s = HibernateSessionFactory.getSessionFactory().openSession()) {
			Transaction t = s.beginTransaction();
			s.remove(clock);
			t.commit();
		}
	}
	public void clear()
	{
		try (Session s = HibernateSessionFactory.getSessionFactory().openSession()) {
			Transaction t = s.beginTransaction();
			for(IClock c : clocks)
			{
				s.remove(c);
			}
			t.commit();
		}
		clocks.clear();
		brandNames.clear();
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

package lab3.task1.logic;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;

import java.io.ObjectStreamField;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="clocks")
public abstract class Clock implements IClock {

	@Serial
	private static final ObjectStreamField[] serialPersistentFields = {
			new ObjectStreamField("brandName", String.class),
			new ObjectStreamField("price", double.class)
	};

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected int ID;
	@Column(name = "brandName")
	@Expose
	protected String brandName;
	@Column(name = "price")
	@Expose
	protected double price;

	public Clock(double price, String name)
	{
		this.price = price;
		this.brandName = name;
	}

	public Clock() {
		this.price = 0.0;
		this.brandName = "";
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getBrandName() {
		return this.brandName;
	}

	@Override
	public void setBrandName(String name) {
		this.brandName = name.trim();
	}

	@Override
	public void setPrice(Double price)
	{
		this.price = price;
	}
}

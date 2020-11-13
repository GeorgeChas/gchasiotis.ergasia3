package my_package;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class productv2 {
	
	@Id
	private String barcode;
	private String sname;
	private String color;
	private String pdescription;
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	
	@Override
	public String toString() {
		return "productv2 [barcode=" + barcode + ", sname=" + sname + ", color=" + color + ", pdescription="
				+ pdescription + "]";
	}
	
}

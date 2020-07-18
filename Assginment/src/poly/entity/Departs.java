package poly.entity;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Departs {
	@Id
	@GeneratedValue
	private int Id;
	private String Name;
	@OneToMany(mappedBy = "depart",fetch = FetchType.EAGER)
    private Collection<Staffs> staffs;

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}




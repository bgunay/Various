package pl.jvsystem.beans.meanbean;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * MyBean
 */
public class MyBean implements Serializable {

	private static final long serialVersionUID = 6170536066049208199L;

	private long id;
	private String name;

	public MyBean() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		//if (o == null || getClass() != o.getClass()) return false;
		if (!(o instanceof MyBean)) return false;

		MyBean that = (MyBean) o;

		return Objects.equal(this.id, that.id) &&
				Objects.equal(this.name, that.name);
	}



	@Override
	public String toString() {
		return "MyBean [id=" + id + ", name=" + name + "]";
	}

}

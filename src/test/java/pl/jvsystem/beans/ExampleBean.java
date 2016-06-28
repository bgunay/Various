package pl.jvsystem.beans;

import com.google.common.base.Objects;

import java.io.Serializable;

public class ExampleBean implements Serializable {
	private static final long serialVersionUID = 6170536066049208199L;

	private long id;
	private String name;

	public ExampleBean() {
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
		if (!(o instanceof ExampleBean)) return false;

		ExampleBean that = (ExampleBean) o;

		return Objects.equal(this.id, that.id) &&
				Objects.equal(this.name, that.name);
	}



	@Override
	public String toString() {
		return "ExampleBean [id=" + id + ", name=" + name + "]";
	}

}

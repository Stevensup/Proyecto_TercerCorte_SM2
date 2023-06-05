package co.edu.unbosque.model;

public interface OperacionesDAO {
	public void add(Object o);

	public boolean update(int index, Object o);

	public boolean delete(String doc);

	public String showAll();
}
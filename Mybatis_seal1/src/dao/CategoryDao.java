package dao;

import java.util.List;

import bean.Category;


public interface CategoryDao {
	public boolean addCategory(Category category);
	public List<Category> query();
	public List qureyLeibie();
	public Category queryById(int id) ;
		

}

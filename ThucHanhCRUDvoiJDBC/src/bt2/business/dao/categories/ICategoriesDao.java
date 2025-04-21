package bt2.business.dao.categories;

import bt2.business.IGenericDao;
import bt2.entity.Categories;

import java.util.List;

public interface ICategoriesDao extends IGenericDao<Categories, Integer> {
    List<Categories> findAllSortedByName();
    List<Categories> searchByName(String keyword);
    void updateStatus(Integer id, boolean status);
    boolean hasProducts(Integer categoryId);
    List<Object[]> countByStatus();
}
package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImp implements ProductRepositoryCustom{

    @Autowired
    private EntityManager em;


    @Override
    public List<Product> RetrieveProductsByCategory(@Param("category")  String category) {

        String sql = "SELECT p FROM Product p INNER JOIN Category c On p.categoryid.id = c.id WHERE c.name =  :category";
        final TypedQuery<Product> query = em.createQuery(sql, Product.class);
        query.setParameter("category", category);
        return  query.getResultList();
    }
}

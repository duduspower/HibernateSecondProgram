import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import javax.persistence.UniqueConstraint;
import java.util.List;

public class CategoryDAO extends DAO{

    public Category get(String title) throws AdException{
        try{
            begin();
            Query q = getSession().createQuery("from Category where title = :title");
            q.setString("title", title);
            Category category = (Category) q.uniqueResult();
            commit();
            return category;
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not obtain the named category " + title, e);
        }
    }

    public List list() throws AdException{
        try{
            begin();
            Query q = getSession().createQuery("from Category");
            List list = q.list();
            commit();
            return list();
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not list the categories", e);
        }
    }

    public Category create(String title) throws AdException{
        try {
            begin();
            Category category = new Category(title);
            getSession().save(category);
            commit();
            return null;
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not create new category",e);
        }
    }

    public void save(Category category) throws AdException{
        try{
            begin();
            getSession().save(category);
            commit();
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not save category ", e);
        }
    }

    public void delete(Category category) throws AdException{
        try {
            begin();
            getSession().delete(category);
            commit();
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not delete category", e);
        }
    }
}

import org.hibernate.HibernateException;

public class AdvertDAO extends DAO{

    public Advert create(String title, String message, User user) throws AdException{
        try{
            begin();
            Advert advert = new Advert(title,message,user);
            getSession().save(advert);
            commit();
            return advert;
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not create advert");
        }
    }

    public void delete(Advert advert)throws AdException{
        try{
            begin();
            getSession().delete(advert);
            commit();
        }catch (HibernateException e){
            rollback();
            throw new AdException("Could not delete advert", e);
        }
    }
}

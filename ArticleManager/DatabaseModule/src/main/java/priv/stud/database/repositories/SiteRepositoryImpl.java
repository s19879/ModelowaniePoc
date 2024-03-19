package priv.stud.database.repositories;

import org.hibernate.Transaction;
import priv.stud.database.entities.Site;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SiteRepositoryImpl extends AbstractRepository<Site,Long>
        implements SiteRepository{

    public SiteRepositoryImpl(){
        super(Site.class);
    }

    @Override
    public List<Site> findByName(String name) {
        Transaction transaction = session.beginTransaction();
        try{
            CriteriaQuery<Site> criteriaQuery = session.getCriteriaBuilder().createQuery(Site.class);
        } catch(Exception e){

        }
        return null;
    }
    public Site findByUrl(String url){
        return null;
    }



}

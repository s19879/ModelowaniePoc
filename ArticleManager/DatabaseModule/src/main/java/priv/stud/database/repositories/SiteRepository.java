package priv.stud.database.repositories;



import priv.stud.database.entities.Site;

import java.util.List;

public interface SiteRepository extends CrudRepository<Site, Long>{
    public Site findByUrl(String url);
    public List<Site> findByName(String name);
}

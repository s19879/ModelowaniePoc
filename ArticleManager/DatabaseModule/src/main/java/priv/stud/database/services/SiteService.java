package priv.stud.database.services;



import priv.stud.database.repositories.SiteRepository;
import priv.stud.database.repositories.SiteRepositoryImpl;
import priv.stud.database.entities.Site;

import javax.validation.constraints.NotNull;

public class SiteService {
    private final SiteRepository siteRepository;

    public SiteService(){
        siteRepository = new SiteRepositoryImpl();
    }

    public boolean createSite(@NotNull String name, @NotNull String url, boolean cookiesAccepted){
        Site site = new Site(name, url, cookiesAccepted);
        return siteRepository.save(site);
    }
}

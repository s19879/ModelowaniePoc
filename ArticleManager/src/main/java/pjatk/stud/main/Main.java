package pjatk.stud.main;


import priv.stud.database.services.SiteService;

public class Main {
    public static void main(String[] args){
        SiteService service = new SiteService();
        System.out.println(service.createSite("Onet", "https://onet.pl", false));

    }
}

package priv.stud.database;

import priv.stud.database.services.SiteService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SiteService service = new SiteService();
        System.out.println(service.createSite("Onet", "https://onet.pl", false));
    }
}
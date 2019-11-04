package com.monnet.webservice;

public class Application {
    public static void main(String [ ] args)
    {
        WebService service = new WebService();
        String comparisonString = service.compareVersions("1.2", "2.3");
        System.out.println(comparisonString);
    }
}
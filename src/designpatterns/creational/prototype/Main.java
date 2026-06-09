package designpatterns.creational.prototype;

public class Main {

    public static void main(String[] args) {

        /*
        Problem: Creating a complex object from scratch is expensive — hitting a database, running validations, setting 30 default fields. When you need many similar objects, you pay that cost every time.
        Solution: Keep a fully-built "master" object (the prototype) and clone() it. The clone starts as an exact copy; you only tweak what's different.
         */

        DocumentRegistery registery = new DocumentRegistery();

        System.out.println("=== User 1: Creating NDA for Infosys ===");
        long t1 = System.currentTimeMillis();
        ContractDocument ndaForInfosys = (ContractDocument) registery.getDocument("CONTRACT");
        ndaForInfosys.setTitle("NDA — Infosys Ltd.");
        ndaForInfosys.setHeaderText("STRICTLY CONFIDENTIAL");
        ndaForInfosys.setStandardClauses("6. Non-compete for 2 years post-termination.");
        System.out.printf("Created in %d ms: %s%n%n", System.currentTimeMillis() - t1, ndaForInfosys);

        System.out.println("\n=== User 2: Resume for Priya Sharma ===");
        long t2 = System.currentTimeMillis();
        ResumeDocument priyaResume = (ResumeDocument) registery.getDocument("RESUME");
        priyaResume.setCandidateName("Priya Sharma");
        priyaResume.setSections("Publications");
        System.out.printf("Created in %d ms: %s%n", System.currentTimeMillis() - t2, priyaResume);

    }
}

package designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistery {

    private static final Map<String, DocumentPrototype> prototypes = new HashMap<>();

    static {
        System.out.println("=== Loading master templates (one-time cost) ===");
        long start = System.currentTimeMillis();
        prototypes.put("CONTRACT", new ContractDocument());
        prototypes.put("RESUME",   new ResumeDocument());
        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Templates loaded in %d ms%n%n", elapsed);
    }

    public DocumentPrototype getDocument(String type) {
        DocumentPrototype prototype = prototypes.get(type.toUpperCase());
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown template type: " + type);
        }
        return prototype.clone();   // ← this is instant, no DB hit
    }

}

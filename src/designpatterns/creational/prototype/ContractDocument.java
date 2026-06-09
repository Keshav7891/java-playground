package designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ContractDocument implements DocumentPrototype{
    private String title;
    private String fontFamily;
    private double topMarginCm;
    private double sideMarginCm;
    private boolean hasPageNumbers;
    private String headerText;
    private List<String> standardClauses;

    public ContractDocument() {
        System.out.println("[DB] Loading standard contract template...");
        this.title         = "Untitled Contract";
        this.fontFamily    = "Times New Roman";
        this.topMarginCm   = 2.5;
        this.sideMarginCm  = 3.0;
        this.hasPageNumbers = true;
        this.headerText    = "CONFIDENTIAL";
        this.standardClauses = new ArrayList<>(List.of(
                "1. Parties agree to confidentiality.",
                "2. Governing law: India.",
                "3. Dispute resolution via arbitration.",
                "4. Force majeure applies.",
                "5. Amendments must be in writing."
        ));

        simulateSlowLoad();
    }

    private ContractDocument(ContractDocument source) {
        this.title          = source.title;
        this.fontFamily     = source.fontFamily;
        this.topMarginCm    = source.topMarginCm;
        this.sideMarginCm   = source.sideMarginCm;
        this.hasPageNumbers = source.hasPageNumbers;
        this.headerText     = source.headerText;
        // Deep copy of the list — clones share NO mutable state
        this.standardClauses = new ArrayList<>(source.standardClauses);
    }

    @Override
    public DocumentPrototype clone() {
        return new ContractDocument(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public double getTopMarginCm() {
        return topMarginCm;
    }

    public void setTopMarginCm(double topMarginCm) {
        this.topMarginCm = topMarginCm;
    }

    public double getSideMarginCm() {
        return sideMarginCm;
    }

    public void setSideMarginCm(double sideMarginCm) {
        this.sideMarginCm = sideMarginCm;
    }

    public boolean isHasPageNumbers() {
        return hasPageNumbers;
    }

    public void setHasPageNumbers(boolean hasPageNumbers) {
        this.hasPageNumbers = hasPageNumbers;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public List<String> getStandardClauses() {
        return standardClauses;
    }

    public void setStandardClauses(String standardClause) {
        this.standardClauses.add(standardClause);
    }

    @Override
    public String toString() {
        return "ContractDocument{" +
                "title='" + title + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                ", topMarginCm=" + topMarginCm +
                ", sideMarginCm=" + sideMarginCm +
                ", hasPageNumbers=" + hasPageNumbers +
                ", headerText='" + headerText + '\'' +
                ", standardClauses=" + standardClauses +
                '}';
    }

    private void simulateSlowLoad() {
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }
}

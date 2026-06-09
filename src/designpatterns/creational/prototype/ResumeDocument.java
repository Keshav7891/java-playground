package designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ResumeDocument implements DocumentPrototype{

    private String candidateName;
    private String fontStyle;
    private boolean showPhoto;
    private List<String> sections;

    public ResumeDocument() {
        System.out.println("[DB] Loading standard resume template...");
        this.candidateName = "Candidate Name";
        this.fontStyle     = "Modern";
        this.showPhoto     = false;
        this.sections      = new ArrayList<>(List.of(
                "Summary", "Work Experience", "Education", "Skills", "Certifications"
        ));

        simulateSlowLoad();
    }

    // Private copy constructor
    private ResumeDocument(ResumeDocument source) {
        this.candidateName = source.candidateName;
        this.fontStyle     = source.fontStyle;
        this.showPhoto     = source.showPhoto;
        this.sections      = new ArrayList<>(source.sections);
    }

    @Override
    public DocumentPrototype clone() {
        return new ResumeDocument((this));
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public boolean isShowPhoto() {
        return showPhoto;
    }

    public void setShowPhoto(boolean showPhoto) {
        this.showPhoto = showPhoto;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(String section) {
        this.sections.add(section);
    }

    @Override
    public String toString() {
        return "ResumeDocument{" +
                "candidateName='" + candidateName + '\'' +
                ", fontStyle='" + fontStyle + '\'' +
                ", showPhoto=" + showPhoto +
                ", sections=" + sections +
                '}';
    }

    private void simulateSlowLoad() {
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }
}

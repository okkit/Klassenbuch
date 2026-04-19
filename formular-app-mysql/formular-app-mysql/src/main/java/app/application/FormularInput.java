package app.application;

public class FormularInput {
    private final String titel;
    private final String beschreibung;
    private final boolean newsletter;
    private final boolean datenschutzAkzeptiert;
    private final String kategorie;

    public FormularInput(String titel,
                         String beschreibung,
                         boolean newsletter,
                         boolean datenschutzAkzeptiert,
                         String kategorie) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.newsletter = newsletter;
        this.datenschutzAkzeptiert = datenschutzAkzeptiert;
        this.kategorie = kategorie;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public boolean isDatenschutzAkzeptiert() {
        return datenschutzAkzeptiert;
    }

    public String getKategorie() {
        return kategorie;
    }
}

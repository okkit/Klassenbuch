package app.domain;

import app.application.ValidationException;

public class Formular {
    private Long id;
    private final String titel;
    private final String beschreibung;
    private final boolean newsletter;
    private final boolean datenschutzAkzeptiert;
    private final String kategorie;

    public Formular(String titel,
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

    public void validiereFachlich() {
        if (titel.length() < 3) {
            throw new ValidationException("Fachliche Prüfung: Der Titel muss mindestens 3 Zeichen lang sein.");
        }

        if (beschreibung.length() < 10) {
            throw new ValidationException("Fachliche Prüfung: Die Beschreibung muss mindestens 10 Zeichen lang sein.");
        }

        if (!datenschutzAkzeptiert) {
            throw new ValidationException("Fachliche Prüfung: Der Datenschutz muss akzeptiert werden.");
        }

        if ("WICHTIG".equals(kategorie) && !newsletter) {
            throw new ValidationException(
                    "Fachliche Prüfung: Bei Kategorie 'WICHTIG' muss Newsletter aktiviert sein.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

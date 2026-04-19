package app.application;

import app.domain.Formular;
import app.persistence.FormularRepository;

public class FormularService {

    private final FormularRepository repository;

    public FormularService(FormularRepository repository) {
        this.repository = repository;
    }

    public void speichern(FormularInput input) {
        Formular formular = new Formular(
                input.getTitel(),
                input.getBeschreibung(),
                input.isNewsletter(),
                input.isDatenschutzAkzeptiert(),
                input.getKategorie());

        formular.validiereFachlich();
        repository.save(formular);
    }
}

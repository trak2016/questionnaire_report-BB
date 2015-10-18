package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;

/**
 * Class CrudService
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface CrudService<T, I> {

    T getElement(I id);

    List<T> getElements();

    void add(T element);

    void update(T element);

    void delete(T element);
    
    void deleteById(I id);
    
    T save(T element);
}

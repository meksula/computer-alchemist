package com.computeralchemist.domain.repetition_protector;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Component
public class RepetitionProtector {
    private RepositoryProvider repositoryProvider;

    @Autowired
    public void setRepositoryProvider(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    public boolean isComponentExist(ComputerComponent component) {
        ComputerComponent checking = repositoryProvider.findComponentByProducentAndModel(component);

        return checking != null
                && checking.getProducent().equals(component.getProducent())
                && checking.getModel().equals(component.getModel());
    }

}

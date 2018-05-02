package com.computeralchemist.domain.rating;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.OpinionDto;
import com.computeralchemist.repository.RepositoryProvider;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

@Aspect
@Component
public class UpdateComponentRates {
    private RepositoryProvider repositoryProvider;

    @Autowired
    public void setRepositoryProvider(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    private ComputerComponent computerComponent;
    private double rate;

    @AfterReturning(value = "execution(* com.computeralchemist.controller.components.ComponentsController.putOpinionOfComponent(..))",
                    returning = "opinion")
    public void updateComponentRate(OpinionDto opinion) {
        String componentType = opinion.getComponentType().toString();
        long id = opinion.getProductId();
        this.rate = opinion.getRate();

        this.computerComponent = repositoryProvider.findComponent(componentType, id);

        avgRate();
        repositoryProvider.updateComponent(computerComponent);
    }

    private void avgRate() {
        computerComponent.setVotes(computerComponent.getVotes() + 1);
        computerComponent.setAllPoints(computerComponent.getAllPoints() + rate);
        double rateAvg = computerComponent.getAllPoints() / computerComponent.getVotes();
        computerComponent.setRatesEvg(rateAvg);
    }
}

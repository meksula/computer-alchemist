package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.repository.sets.FamilySetRepository;
import com.computeralchemist.repository.sets.GamingSetRepository;
import com.computeralchemist.repository.sets.WorkSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Service
public class ComputerSetManagerImpl implements ComputerSetManager {
    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();
    private ComputerSet computerSet;
    private WorkSetRepository workSetRepository;
    private FamilySetRepository familySetRepository;
    private GamingSetRepository gamingSetRepository;

    @Autowired
    public void setWorkSetRepository(WorkSetRepository workSetRepository,
                                     FamilySetRepository familySetRepository,
                                     GamingSetRepository gamingSetRepository) {
        this.workSetRepository = workSetRepository;
        this.familySetRepository = familySetRepository;
        this.gamingSetRepository = gamingSetRepository;
    }

    @Override
    public ComputerSet initSet(String user, String type) {
        String parsed = extracter.extractComputerTypeFromJson(type);
        computerSet = ComputerSetTypes.valueOf(parsed).createSet();
        computerSet.setAuthor(user);
        updateSet(computerSet);
        return computerSet;
    }

    @Override
    public ComputerSet updateSet(ComputerSet computerSet) {
        return null;
    }

    @Override
    public ComputerSet findComputerSetById(long setId) {
        return null;
    }

    @Override
    public boolean isSetCompatible() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isPublic() {
        return false;
    }

    @Override
    public List<ComputerComponent> getContent() {
        return null;
    }

    @Override
    public void setAuthor(String author) {

    }
}

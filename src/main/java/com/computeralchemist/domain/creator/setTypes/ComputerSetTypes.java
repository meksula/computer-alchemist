package com.computeralchemist.domain.creator.setTypes;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public enum ComputerSetTypes {

    work {
        @Override
        public ComputerSet createSet(long id) {
            WorkComputerSet computerSet = new WorkComputerSet();
            computerSet.setType(this);
            computerSet.setSetId(id);
            return computerSet;
        }
    },

    family {
        @Override
        public ComputerSet createSet(long id) {
            FamilyComputerSet computerSet = new FamilyComputerSet();
            computerSet.setType(this);
            computerSet.setSetId(id);
            return computerSet;
        }
    },

    gaming {
        @Override
        public ComputerSet createSet(long id) {
            GamingComputerSet computerSet = new GamingComputerSet();
            computerSet.setType(this);
            computerSet.setSetId(id);
            return computerSet;
        }
    };

    public abstract ComputerSet createSet(long id);
}

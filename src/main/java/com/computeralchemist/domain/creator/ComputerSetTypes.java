package com.computeralchemist.domain.creator;

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
            computerSet.setId(id);
            return computerSet;
        }
    },

    family {
        @Override
        ComputerSet createSet(long id) {
            FamilyComputerSet computerSet = new FamilyComputerSet();
            computerSet.setType(this);
            computerSet.setId(id);
            return computerSet;
        }
    },

    gaming {
        @Override
        ComputerSet createSet(long id) {
            GamingComputerSet computerSet = new GamingComputerSet();
            computerSet.setType(this);
            computerSet.setId(id);
            return computerSet;
        }
    };

    abstract ComputerSet createSet(long id);
}

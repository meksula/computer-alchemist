package com.computeralchemist.domain.creator;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public enum ComputerSetTypes {

    work {
        @Override
        public ComputerSet createSet() {
            return new WorkComputerSet();
        }
    },

    family {
        @Override
        ComputerSet createSet() {
            return new FamilyComputerSet();
        }
    },

    gaming {
        @Override
        ComputerSet createSet() {
            return new GamingComputerSet();
        }
    };

    abstract ComputerSet createSet();
}

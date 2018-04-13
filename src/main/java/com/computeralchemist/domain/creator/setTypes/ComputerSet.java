package com.computeralchemist.domain.creator.setTypes;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.supply.PowerSupply;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public abstract class ComputerSet {
    private ComputerSetTypes type;
    private Map<ComponentType, Long> componentList;
    private String author;
    private String createDate;
    private long votes;
    private boolean compatible;
    private boolean finished;
    private boolean isPublic;

    private Cpu cpu;
    private Motherboard motherboard;
    private Ram ram;
    private Disk disk;
    private GraphicsCard graphicsCard;
    private PowerSupply powerSupply;
    private ComputerCase computerCase;

    public boolean isSetCompatible() {
        return this.compatible;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setCompatible(boolean compatible) {
        this.compatible = compatible;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public ComputerSetTypes getType() {
        return type;
    }

    public void setType(ComputerSetTypes type) {
        this.type = type;
    }

    public Map<ComponentType, Long> getComponentList() {
        return componentList;
    }

    public void setComponentList(Map<ComponentType, Long> componentList) {
        this.componentList = componentList;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }
}

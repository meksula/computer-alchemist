package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentType;

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
}

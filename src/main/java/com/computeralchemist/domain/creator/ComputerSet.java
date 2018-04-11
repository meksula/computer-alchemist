package com.computeralchemist.domain.creator;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public abstract class ComputerSet {
    private String author;
    private long setId;
    private long votes;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getSetId() {
        return setId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}

package com.guigu.code.dto.goods;

public class search {
    private String name;
    private Integer flID;

    public search() {
    }

    public search(String name, Integer flID) {
        this.name = name;
        this.flID = flID;
    }

    @Override
    public String toString() {
        return "search{" +
                "name='" + name + '\'' +
                ", flID=" + flID +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlID() {
        return flID;
    }

    public void setFlID(Integer flID) {
        this.flID = flID;
    }
}

package edu.cs.birzeit.inclassactivity2;

public class Books {
    private String name,auther;
    private String pages;

    public Books(String name, String auther, String pages) {
        this.name = name;
        this.auther = auther;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}

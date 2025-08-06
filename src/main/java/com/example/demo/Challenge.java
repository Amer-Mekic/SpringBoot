package com.example.demo;

public class Challenge {
    private Long id;
    private String month;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Challenge(Long id, String m, String d){
        this.id=id;
        month=m;
        description=d;
    }


}

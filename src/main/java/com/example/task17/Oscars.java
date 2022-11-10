package com.example.task17;

public class Oscars {
    private String index;
    private String year;
    private String age;
    private String name;
    private String movie;

    public Oscars(String index, String year, String age, String name, String movie) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() { return movie; }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return String.format("\nIndex: %s\nYear: %s\nAge: %s\nName: %s\nMovie: %s\n",
                this.getIndex(), this.getYear(), this.getAge(), this.getName(), this.getMovie());
    }
}

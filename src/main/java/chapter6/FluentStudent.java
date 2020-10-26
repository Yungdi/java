package chapter6;

public class FluentStudent {

    private String name;
    private int level;

    public FluentStudent name(String name) {
        this.name = name;
        return this;
    }

    public String name() {
        return name;
    }

    public FluentStudent level(int level) {
        this.level = level;
        return this;
    }

    public int level() {
        return level;
    }
}
package inheritance;

public interface Father extends GrandFather {

    default void love() {
        System.out.println("I am father.");
    }
}

package inheritance;

public interface Mother {

    default void love() {
        System.out.println("I am mother");
    }
}

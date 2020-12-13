package inheritance;

public interface GrandFather {

    default void love() {
        System.out.println("grand father");
    }
}

package diamond;

public interface Mother {
    void eat();

    default void goBed() {
        System.out.println("bye");
    }
}

package diamond;

public class LeeHa implements Father, Mother {

    @Override
    public void eat() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        LeeHa leeHa = new LeeHa();
    }
}

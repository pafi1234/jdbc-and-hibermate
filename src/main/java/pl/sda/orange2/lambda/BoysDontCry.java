package pl.sda.orange2.lambda;

//its functional interface because has one abstract method
@FunctionalInterface //ochrona przed błędami ludzkimi
public interface BoysDontCry {
    void silnoreki();
    default void cry() {};
}

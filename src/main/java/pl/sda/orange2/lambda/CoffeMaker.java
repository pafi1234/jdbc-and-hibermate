package pl.sda.orange2.lambda;

@FunctionalInterface
public interface CoffeMaker {
    String prepare(int water, String coffeeType);

}

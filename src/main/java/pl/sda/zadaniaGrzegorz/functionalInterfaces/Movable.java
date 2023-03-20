package pl.sda.zadaniaGrzegorz.functionalInterfaces;

public abstract class Movable {

    abstract String move();

    String moveWith(String partner) {
        return move() + " with " + partner;
    }

    String moveAlone(String reason) {
        return move() + " alone because of " + reason;
    }
}

package pl.sda.orange2.lambda;

public class LambdaExperiences {

    public static void main(String[] args) {
      BoysDontCry boy = new ChlopakiNiePlacza();
      boy.silnoreki();

      ChlopakiNiePlacza boy2 = new ChlopakiNiePlacza();
      boy2.sing();


      //klasa anonimowa
      BoysDontCry anonymousClassReference = new BoysDontCry() {
          @Override
          public void silnoreki() {
              System.out.println("Anonimowy Silnoreki");
          }
      };
      anonymousClassReference.silnoreki();

        // () parenthesis - arguments list
        // -> arguments, body separator
        // {} parenthesis - method body
      BoysDontCry firstLambda = () -> {};
      BoysDontCry secondLambda = () -> System.out.println("Lambda");
      secondLambda.silnoreki();
      BoysDontCry thirdLambda = () -> {
          System.out.println("One");
          System.out.println("Two");
      };

        System.out.println("-----------------------------");
        System.out.println("Coffe time");

        CoffeMaker myCoffeMaker = (int water, String coffeeType) -> "my coffee";
        CoffeMaker myCoffeMaker2 = (int water, String coffeeType) -> {
        return "my coffee";
        };
        CoffeMaker myCoffeMaker3 = (int water, String coffeeType) -> {
        System.out.println("Coffee brewing...");
        return "my coffee";
        };
        CoffeMaker shortVersion = ((water, coffeeType) -> "my coffee");
        shortVersion.prepare(5,"Large Java Coffe");
    }
}

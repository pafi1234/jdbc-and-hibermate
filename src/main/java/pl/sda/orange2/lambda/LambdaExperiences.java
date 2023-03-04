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
    }
}

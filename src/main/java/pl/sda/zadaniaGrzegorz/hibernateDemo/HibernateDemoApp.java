package pl.sda.zadaniaGrzegorz.hibernateDemo;

import java.util.List;

public class HibernateDemoApp {

    public static void main(String[] args) {
        var car1 = new Car(); // to samo co Car car1 = new Car()
        //car1.setId(1); //setId tylko kiedy nie ma ustawionej @GenerationValue w polu Id
        car1.setName("Ford");
        car1.setModel("Mustang");

        var car2 = new Car();
        //car2.setId(2); //setId tylko kiedy nie ma ustawionej @GenerationValue w polu Id
        car2.setName("Opel");
        car2.setModel("Corsa");

        var util = new HibernateUtil();
        var factory = util.getFactory();

        try(var session = factory.openSession()) {
            var transaction = session.beginTransaction();
            session.persist(car1);
            session.persist(car2);
            transaction.commit();
        }

        System.out.println("Wylistowane dane z bazy:");
        try(var session = factory.openSession()) {
            List<Car> carsFromDb = session.createQuery("from Car", Car.class).list();
            carsFromDb.forEach(each -> {
                System.out.println("Samochód o id = " + each.getId());
                System.out.println(each.getName() + " " + each.getModel() + "\n");
            });
        }
    }
}

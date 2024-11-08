package org.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.entites.composition.Batch;
import org.hibernate.entites.composition.Ingredient;
import org.hibernate.entites.composition.Label;
import org.hibernate.entites.composition.Shampoo;
import org.hibernate.entites.vehicles.Bike;
import org.hibernate.entites.vehicles.Car;
import org.hibernate.entites.vehicles.Vehicle;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Bike bike = new Bike();
        bike.setWheelSize(26);

        Car car = new Car();
        car.setPaintCode("red");

        entityManager.persist(bike);
        entityManager.persist(car);

        List<Vehicle> vehicles = List.of(bike, car);

        persistShampoo(entityManager);

        Shampoo shampoo = entityManager.find(Shampoo.class, 1);
        System.out.println(shampoo.getBatch().getSerial());
        System.out.println(shampoo.getIngredients().get(0).getName());

//        System.out.println(label.getShampoo());

//        Batch batch = new Batch();
//        Collections.unmodifiableSet()
//        batch.getShampoo().add(new Shampoo());
//        batch.getShampoo().iterator().next().setBrand("");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void persistShampoo(EntityManager entityManager) {
        Shampoo shampoo = new Shampoo();

        Label label = new Label();
        label.setTitle("Primary label");

        Batch batch = new Batch();
        batch.setSerial("1x-snaff-buhb");

        Ingredient ing = new Ingredient();
        ing.setName("Lavender");
        Ingredient ing2 = new Ingredient();
        ing2.setName("Salt");

        shampoo.setLabel(label);
        shampoo.setBatch(batch);
        shampoo.setIngredients(List.of(ing, ing2));

        entityManager.persist(label);
        entityManager.persist(shampoo);
        entityManager.persist(batch);
        entityManager.persist(ing);
        entityManager.persist(ing2);
    }
}
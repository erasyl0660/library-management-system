import java.util.ArrayList;
import java.util.List;

public class Main {

    static abstract class Vehicle {
        protected String brand;
        protected String model;
        protected int year;

        public Vehicle(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public abstract void startEngine();
        public abstract void stopEngine();

        public String info() {
            return brand + " " + model + " (" + year + ")";
        }
    }


    static class Car extends Vehicle {
        private int doors;
        private String transmission;

        public Car(String brand, String model, int year, int doors, String transmission) {
            super(brand, model, year);
            this.doors = doors;
            this.transmission = transmission;
        }

        @Override
        public void startEngine() {
            System.out.println("Автомобиль іске қосылды: " + info());
        }

        @Override
        public void stopEngine() {
            System.out.println("Автомобиль тоқтады: " + info());
        }

        @Override
        public String toString() {
            return info() + ", есік: " + doors + ", трансмиссия: " + transmission;
        }
    }

    static class Motorcycle extends Vehicle {
        private String bodyType;
        private boolean hasBox;

        public Motorcycle(String brand, String model, int year, String bodyType, boolean hasBox) {
            super(brand, model, year);
            this.bodyType = bodyType;
            this.hasBox = hasBox;
        }

        @Override
        public void startEngine() {
            System.out.println("Мотоцикл іске қосылды: " + info());
        }

        @Override
        public void stopEngine() {
            System.out.println("Мотоцикл тоқтады: " + info());
        }

        @Override
        public String toString() {
            return info() + ", кузов: " + bodyType + ", бокс: " + (hasBox ? "бар" : "жоқ");
        }
    }

    static class Garage {
        private String name;
        private List<Vehicle> vehicles = new ArrayList<>();

        public Garage(String name) {
            this.name = name;
        }

        public void addVehicle(Vehicle v) {
            vehicles.add(v);
        }

        public void removeVehicle(Vehicle v) {
            vehicles.remove(v);
        }

        public List<Vehicle> getVehicles() {
            return vehicles;
        }

        public String getName() {
            return name;
        }
    }

    static class Fleet {
        private List<Garage> garages = new ArrayList<>();

        public void addGarage(Garage g) {
            garages.add(g);
        }

        public void removeGarage(Garage g) {
            garages.remove(g);
        }

        public void showAllVehicles() {
            for (Garage g : garages) {
                System.out.println("Гараж: " + g.getName());
                for (Vehicle v : g.getVehicles()) {
                    System.out.println("  - " + v);
                }
            }
        }
    }

    public static void main(String[] args) {

        Vehicle car = new Car("Hyundai", "Sonata", 2021, 4, "Автомат");
        Vehicle moto = new Motorcycle("Honda", "CBR", 2020, "Спорт", true);

        Garage garageA = new Garage("Гараж A");
        Garage garageB = new Garage("Гараж B");

        garageA.addVehicle(car);
        garageB.addVehicle(moto);

        Fleet fleet = new Fleet();
        fleet.addGarage(garageA);
        fleet.addGarage(garageB);

        car.startEngine();
        moto.startEngine();
        moto.stopEngine();

        System.out.println("\nАвтопарк тізімі:");
        fleet.showAllVehicles();
    }
}

package bai_tap_them.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    private int roomNo = 0;
    private  List<Animal> animalList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public Room(){

    }
    public Room(int roomNo, List<Animal> animalList){
        this.roomNo = roomNo;
        this.animalList = animalList;
    }
    public void addAnimal(Animal a){
        this.animalList.add(a);
    }
    public void removeAnimal(String name){
        for (Animal animal: animalList) {
            if (animal.getName() == name){
                animalList.remove(animal);
            }
        }
    }
    public void display(){
        System.out.println("Room name: " + roomNo);
        System.out.println("- List animal: ");
        int count = 0;
        for(Animal animal : animalList){
            count ++;
            System.out.print(count+". ");
            animal.display();
            animal.showSound();
        }
    }
    public void input(){
        System.out.print("Input Room: ");
        roomNo = Integer.parseInt(scanner.nextLine());

    }
    public Animal createAnimal(){
        Animal animal = null;
        int choose;
        do {
            System.out.println("Create a animal: " +
                    "\n1. Create Tiger" +
                    "\n2. Create Dog" +
                    "\n3. Create another(Cat)" +
                    "\n4. Exit.");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1 : animal = new Tiger();animal.input();animalList.add(animal);break;
                case 2 : animal = new Dog();animal.input();animalList.add(animal);break;
                case 3 : animal = new Cat();animal.input();animalList.add(animal);break;
                default:
                    break;
            }
        }while (choose !=4);
        return animal;
    }
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}

package bai_tap_them.zoo;

import case_study.controllers.Input_InformationServices;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;
    private String description;

    public Animal() {
    }

    public Animal(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    abstract void showSound();

    public void display() {
        System.out.println("Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}');
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name animal: ");
        name = scanner.nextLine();
        System.out.print("Input age animal: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.print("Input description: ");
        description = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

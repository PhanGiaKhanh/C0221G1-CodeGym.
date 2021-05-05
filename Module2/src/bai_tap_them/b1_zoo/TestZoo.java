package bai_tap_them.b1_zoo;

import java.util.Scanner;

public class TestZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        int roomNo;
        int choose;
        do {

            System.out.print("1. AddObject room" +
                    "\n2. Delete room" +
                    "\n3. AddObject animal " +
                    "\n4. Delete animal" +
                    "\n5. Display animals" +
                    "\n6. Exit " +
                    "\nChoose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    Room room = new Room();
                    room.input();
                    zoo.addRoom(room);
                    zoo.display();
                    break;
                case 2:
                    System.out.print("Input room delete: ");
                    roomNo = Integer.parseInt(scanner.nextLine());
                    zoo.removeRoom(roomNo);
                    break;
                case 3:
                    zoo.display();
                    System.out.print("Input animal in room: ");
                    roomNo = Integer.parseInt(scanner.nextLine());
                    for (Room r : zoo.getRoomList()) {
                        if(r.getRoomNo() == roomNo){
                            r.createAnimal();
                            break;
                        }
                    }
                    System.out.println("Not exist " + roomNo);
                    break;
                case 4:
                    System.out.print("Input room animal: ");
                    roomNo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input animal delete: ");
                    String animal = scanner.nextLine();
                    for (Room r : zoo.getRoomList()) {
                        if(r.getRoomNo() == roomNo){
                            r.removeAnimal(animal);
                            break;
                        }
                    }
                    System.out.println("Not exist " + roomNo);
                    break;
                case 5:
                    zoo.display();

            }
        } while (choose != 6);
    }
}

package bai_tap_them.b1_zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Room> roomList;
    public Zoo(){
        roomList = new ArrayList<>();
    }
    public void addAnimal(int roomNo, Room a) {
        for (int i = 0; i < roomList.size() - 1; i++) {
            if (i == roomNo) {
                roomList.add(roomNo, a);
            }
        }
        System.out.println("Not Room " + roomNo);
    }
    public void  removeAnimal(int roomNo, String name){
        for (int i = 0; i < roomList.size() - 1; i++) {
            if (i == roomNo){
                roomList.remove(name);
            }
        }
        System.out.println("Not Room " + roomNo);
    }
    public void addRoom (Room r){
        roomList.add(r);
    }
    public void removeRoom(int roomNo){
        for (Room r : roomList) {
            if (r.getRoomNo() == roomNo){
                roomList.remove(r);
            }
        }
        System.out.println("Not Room "+ roomNo);
    }

    public void display(){
        System.out.println("List room animal: ");
        roomList.forEach(e-> e.display());
        System.out.println();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}

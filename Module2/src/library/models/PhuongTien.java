package library.models;

public abstract class PhuongTien {
    protected String name;
    public abstract void showInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
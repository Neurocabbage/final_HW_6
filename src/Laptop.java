public class Laptop {
    String model;
    int ram;
    int hdd;
    String os;
    String color;

    public String toString() {
        return model + ", ОЗУ:" + ram +
                " GB, Жесткий диск: " + hdd +
                " GB, Операционная система: " + os +
                ", Цвет: " + color;
    }

}

public class Shop {
    private String manufacturer;
    private double diagonal;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Shop(String manufacturer, double diagonal, int ram, int hdd, String os, String color) {
        this.manufacturer = manufacturer;
        this.diagonal = diagonal;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOS() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOperatingSystem(String os) {
        this.os = os;
    }

   
    public String toString() {
        String res = "Ноутбук: [" + manufacturer
                        + ", " + diagonal
                        + ", RAM " + ram
                        + ", HDD " + hdd
                        + ", " + os
                        + ", " + color + "]";
        return res;
    }

 
    public boolean equals(Object o) {
        Shop laptop = (Shop) o;
        boolean res = ram >= laptop.ram && hdd >= laptop.hdd && os.equals(laptop.os) && color.equals(laptop.os);
        return res;
    }

}
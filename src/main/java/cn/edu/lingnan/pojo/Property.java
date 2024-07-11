package cn.edu.lingnan.pojo;


public class Property {
    private String pid;
    private String address;
    private int price;
    private int area;
    private String type;

    @Override
    public String toString() {
        return "Property{" +
                "pid='" + pid + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", type='" + type + '\'' +
                '}';
    }



    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Property(){

    }

    public Property(String pid, String address, int price, int area, String type) {
        this.pid = pid;
        this.address = address;
        this.price = price;
        this.area = area;
        this.type = type;


    }
}

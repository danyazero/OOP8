package productsProcessor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Product implements Serializable, Comparable<Product> {


    //Product: id, Найменування, Виробник, Ціна, Термін зберігання, Кількість.
    private int id; //id
    private String name; //Найменування
    private String manufacturer; //Виробник
    private double price; //Ціна
    private LocalDate term; //Термін зберігання
    private int count; //Кількість

    private static int uid = 0;

    public Product() {
        
    }
    public Product(String name, String manufacturer, double cost, LocalDate term, int count) {
        uid++;
        this.id = uid;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = cost;
        this.term = term;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getTerm() {
        return term;
    }

    public void setTerm(LocalDate term) {
        this.term = term;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public int compareTo(Product o){
//        if (getPrice().compareTo(o.getPrice()) == 0)
//
//        return 0;
//    }

    @Override
    public String toString() {
        return  "#" + id + "  Назва: " + name + " Виробник: " + manufacturer + " Ціна:  " + price + "  Термін: " + term + " Кількість: " + count;
    }

    @Override
    public int compareTo(Product o) {
        int k = Double.compare(price*count, o.getPrice()*o.getCount());
        if(k != 0) return k;
        return -Double.compare(price, o.getPrice());
    }
}
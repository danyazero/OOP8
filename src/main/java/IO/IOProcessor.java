package IO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import productsProcessor.Product;
import productsProcessor.ProductsList;

import java.io.*;
import java.util.*;

public class IOProcessor implements IO {

    public List<Product> readObjects() {
        List<Product> prods = new ArrayList<Product>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            prods = (List<Product>) ois.readObject();
            System.out.println("File read success!");
            return prods;
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("File Not Found!");
        }
        return prods;
    }

    public void writeObjects(ProductsList products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(products.getProducts());
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeObjectsToJson(ProductsList products) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Product> prods = products.getProducts();
            objectMapper.writeValue(new File("person.json"), prods);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> readObjectsFromJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        try {
            return objectMapper.readValue(new File("person.json"), new TypeReference<List<Product>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


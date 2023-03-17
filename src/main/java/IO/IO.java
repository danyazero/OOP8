package IO;

import productsProcessor.Product;
import productsProcessor.ProductsList;

import java.util.List;

public interface IO {
    public List<Product> readObjects();
    public void writeObjects(ProductsList products);
    public void writeObjectsToJson(ProductsList products);
    public List<Product> readObjectsFromJSON();
}

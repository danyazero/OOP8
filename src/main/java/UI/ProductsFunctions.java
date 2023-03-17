package UI;

import productsProcessor.Product;
import productsProcessor.ProductsList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface ProductsFunctions {
    public List<Product> getProductsByName(ProductsList products, Scanner sc);
    public List<Product> getProductByPrice(ProductsList products, Scanner sc);
    public void addNewProduct(ProductsList products, Scanner scanner);
    public void deleteElementById(ProductsList products, Scanner sc);
    public void showProducts(List<?> products);
    public List<Product> getProductByTerm(ProductsList products, Scanner sc);
    public void createProductsArray(ProductsList products);

    public List<Product> getSortedArrayByPrice(List<Product> products);
    public List<Product> getSortedProducts(List<Product> products);
    public List<String> getOnlyManufacturers(List<Product> products);

    public Map<String, List<Product>> getManufacturersProductsList(List<Product> products);
    public void showMapObjects(Map<String, List<Product>> manufacturerProducts);
}

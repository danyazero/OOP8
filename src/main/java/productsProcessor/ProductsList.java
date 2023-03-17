package productsProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsList {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsByName(String name) {
        List<Product> productsByName = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                productsByName.add(product);
            }
        }
        return productsByName;
    }

    public void setProductsList(List<Product> prods) {
        products = prods;
    }

    public List<Product> getProductByTerm(LocalDate term) {
        List<Product> productsByTerm = new ArrayList<>();
        for (Product product : products) {
            if (product.getTerm().isAfter(term)) {
                productsByTerm.add(product);
            }
        }
        return productsByTerm;
    }

    public void deleteById(int id){
        products.removeIf(p -> (p.getId() == id));
    }

    public List<Product> getProductByNameAndPrice(String name, double cost) {
        List<Product> productsByPrice = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name) && (product.getPrice() <= cost)) {
                productsByPrice.add(product);
            }
        }
        return productsByPrice;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}

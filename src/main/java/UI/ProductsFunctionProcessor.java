package UI;

import productsProcessor.Product;
import productsProcessor.ProductsList;

import java.time.LocalDate;
import java.util.*;

public class ProductsFunctionProcessor implements ProductsFunctions{
    public List<Product> getProductsByName(ProductsList products, Scanner sc) {
        System.out.print("Enter name of products >> ");
        String name = sc.next();

        return getSortedProducts(products.getProductsByName(name));
    }

    public List<Product> getProductByPrice(ProductsList products, Scanner sc) {

        System.out.print("Enter name of products >> ");
        String name = sc.next();
        System.out.print("Enter price of products >> ");
        double cost = sc.nextDouble();

        return products.getProductByNameAndPrice(name, cost);
    }

    public void addNewProduct(ProductsList products, Scanner scanner) {
        System.out.print("Enter name >> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter manufacturer >> ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter cost >> ");
        double cost = scanner.nextDouble();
        System.out.print("Enter year, month, day of term >> ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.print("Enter count >> ");
        int count = scanner.nextInt();
        products.addProduct(new Product(name, manufacturer, cost, LocalDate.of(year, month, day), count));
    }

    public void deleteElementById(ProductsList products, Scanner sc){
        System.out.print("Enter id to delete >> ");
        int id = sc.nextInt();
        products.deleteById(id);
    }

    public List<Product> getSortedProducts(List<Product> products){

        products.sort((o1, o2) -> {
            if (o1.getTerm().isAfter(o2.getTerm())) return -1;
            if (o1.getTerm().isBefore(o2.getTerm())) return 1;
            return 0;
        });

        return products;
    }
    public void showProducts(List<?> products) {
        products.forEach(System.out::println);
    }

    public void showMapObjects(Map<String, List<Product>> manufacturerProducts){
        for (Map.Entry<String, List<Product>> entry: manufacturerProducts.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public List<Product> getProductByTerm(ProductsList products, Scanner sc) {
        System.out.print("Enter day >> ");
        int d = sc.nextInt();
        System.out.print("Enter month >> ");
        int m = sc.nextInt();
        System.out.print("Enter year >> ");
        int y = sc.nextInt();
        LocalDate date = LocalDate.of(y, m, d);

        return products.getProductByTerm(date);
    }

    public void createProductsArray(ProductsList products) {
        products.addProduct(new Product("Оселедець", "Norven", 119.50, LocalDate.of(2022, 12, 25), 45));
        products.addProduct(new Product("Шоколад", "Milka", 90.75, LocalDate.of(2022, 10, 15), 100));
        products.addProduct(new Product("Нaпій", "Pepsi", 27.60, LocalDate.of(2021, 12, 25), 37));
        products.addProduct(new Product("Йогурт", "Danone", 28.90, LocalDate.of(2023, 3, 15), 12));
        products.addProduct(new Product("Йогурт", "Марійка", 23.60, LocalDate.of(2023, 2, 25), 30));
        products.addProduct(new Product("Йогурт", "Dolche", 27.60, LocalDate.of(2022, 2, 28), 30));
        products.addProduct(new Product("Масло", "Ферма", 46.50, LocalDate.of(2023, 4, 25), 30));
        products.addProduct(new Product("Ковбаса", "Добров", 83.90, LocalDate.of(2023, 4, 5), 30));
        products.addProduct(new Product("Сік", "Sandora", 66.90, LocalDate.of(2022, 12, 15), 30));
        products.addProduct(new Product("Молоко", "Ферма", 33.40, LocalDate.of(2023, 11, 25), 43));
    }

    @Override
    public List<Product> getSortedArrayByPrice(List<Product> products) {

        products.sort((o1, o2) -> {
            int k = Double.compare(o1.getPrice()*o1.getPrice(), o2.getPrice()*o2.getCount());
            if(k != 0) return k;
            return -Double.compare(o1.getPrice(), o2.getPrice());
        });

        return products;
    }

    public Map<String, List<Product>> getManufacturersProductsList(List<Product> products){
        List<String> manufactures = getOnlyManufacturers(products);

        Map<String, List<Product>> manufacturerProducts = new HashMap<>();
        manufactures.forEach(manu ->
                manufacturerProducts.put(manu, products.stream().filter(m -> m.getManufacturer() == manu).toList())
        );

        return manufacturerProducts;
    }

    public List<String> getOnlyManufacturers(List<Product> products){

        List<String> manufactures = products.stream().map(m -> m.getManufacturer()).toList();

        return manufactures;
    }
}

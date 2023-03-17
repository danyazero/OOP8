package main;


import IO.IO;
import IO.IOProcessor;
import UI.ProductsFunctionProcessor;
import UI.ProductsFunctions;
import productsProcessor.ProductsList;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        new Main().run();
    }

    private void menu() {
        println("[0] Read file from JSON.");
        println("[1] Read file from Binary");
        println("[2] Show all entries");
        println("[3] Filter products by name and sort by term");
        println("[4] Filter by Name & Price");
        println("[5] Filter by Term");
        println("[6] Sorted by Cost & price");
        println("[7] Show manufacturers List");
        println("[8] Show every manufacturer products");
        println("[9] Add new product");
        println("[10] Delete Element By Id");
        println("[11] Save in Binary File");
        println("[12] Add few Products to Array");
        println("[13] Save in JSON file");
        println("[14] Exit");
        System.out.print(">> ");
    }

    private void run() {
        ProductsList products = new ProductsList();
        IO io = new IOProcessor();
        ProductsFunctions funs = new ProductsFunctionProcessor();
        loop:
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            switch (m) {

                case 0 -> products.setProductsList(io.readObjectsFromJSON());
                case 1 -> products.setProductsList(io.readObjects());
                case 2 -> funs.showProducts(products.getProducts());
                case 3 -> funs.showProducts(funs.getProductsByName(products, scanner));
                case 4 -> funs.showProducts(funs.getProductByPrice(products, scanner));
                case 5 -> funs.showProducts(funs.getProductByTerm(products, scanner));
                case 6 -> funs.showProducts(funs.getSortedArrayByPrice(products.getProducts()));
                case 7 -> funs.showProducts(funs.getOnlyManufacturers(products.getProducts()));
                case 8 -> funs.showMapObjects(funs.getManufacturersProductsList(products.getProducts()));
                case 9 -> funs.addNewProduct(products, scanner);
                case 10 -> funs.deleteElementById(products, scanner);
                case 11 -> io.writeObjects(products);
                case 12 -> funs.createProductsArray(products);
                case 13 -> io.writeObjectsToJson(products);
                case 14 -> {
                    break loop;
                }
            }
        }

    }

    private void println(String value) {
        System.out.println(value);
    }
}
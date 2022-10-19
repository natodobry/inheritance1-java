package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        SimpleDateFormat d01 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products:");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.println("Customs fee: ");
                double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));
            } else if (ch == 'u') {
                System.out.println("Manufacture date (DD/MM/YYYY):");
                Date date = d01.parse(sc.next());
                list.add(new UsedProduct(name, price, date));
            } else {
                list.add(new Product(name, price));
            }


        }


        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}

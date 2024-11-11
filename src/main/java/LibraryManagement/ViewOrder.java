package LibraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrder implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("\nEnter book name: ");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine();
        int i = database.getBook(bookname);
        if(i>-1){
            System.out.println("Book\t\tUser\t\tPrice\t\tQty");
           for(Order order : database.getAllOrders()) {
               if (order.getBook().getName().matches(bookname)) {
                   System.out.println(order.getBook().getName() + "\t\t"
                           + order.getUser().getName() + "\t\t" + order.getQty() + "\t" + order.getPrice());
               }
           }
            System.out.println();
        }else{
            System.out.println("Book does not exist!\n");
        }
        user.menu(database, user);
    }
}

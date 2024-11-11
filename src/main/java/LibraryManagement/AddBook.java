package LibraryManagement;

import java.util.Scanner;

public class AddBook  implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = s.nextLine();
        if(database.getBook(name)>-1){
            System.out.println("There is already a book in the database" );
            user.menu(database, user);
        }
        else{
            book.setName(name);
            System.out.println("Enter book author: ");
            book.setAuthor(s.nextLine());
            System.out.println("Enter book publisher: ");
            book.setPublisher(s.nextLine());
            System.out.println("Enter book collection adress: ");
            book.setAdress(s.nextLine());
            System.out.println("Enter book qty: ");
            book.setQty(s.nextInt());
            System.out.println("Enter book price: ");
            book.setPrice(s.nextDouble());
            System.out.println("Enter borrowing copies: ");
            book.setBrwcopies(s.nextInt());
            database.AddBook(book);
            System.out.println("Book added successfully");
            user .menu(database,user);
            s.close();
        }

    }
}

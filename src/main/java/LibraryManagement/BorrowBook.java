package LibraryManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class BorrowBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookname = s.nextLine();

        int i = database.getBook(bookname);
        if(i>-1) {
            Book book = database.getBook(i);
            boolean n =true;
            for (Borrowing b : database.getBrws()) {
                if(b.getBook().getName().matches(bookname) &&
                        b.getUser().getName().matches(user.getName())) {
                    n = false;
                    System.out.println("You have borrowed this book before !");
                }
            }
           if(n) {
               if (book.getBrwcopies() > 1 ) {
                   Borrowing borrowing = new Borrowing(book, user);
                   book.setBrwcopies(book.getBrwcopies() - 1);
                   database.borrowBook(borrowing, book, i);
                   System.out.println("You must return the book before 14 days from now\n"
                           + "Expiry data:" + borrowing.getFinish() + "\nEnjoy!\n");
               }else {
                   System.out.println("This book isn't available for borrow.");
               }
           }
        }else {
            System.out.println("Book doesn't exist\n");
        }
        user.menu(database, user);
    }
}

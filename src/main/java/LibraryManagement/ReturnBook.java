package LibraryManagement;

import java.util.Scanner;

public class ReturnBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name: ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.nextLine();
        if(!database.getBrws().isEmpty()) {
            for (Borrowing b : database.getBrws()) {
                if (b.getBook().getName().matches(bookName)
                       && b.getUser().getName().matches(user.getName())) {
                    Book book = b.getBook();
                    int i = database.getAllBooks().indexOf(book);
                    if(b.getDaysleft() < 0 ) {
                        System.out.println("You are late!\n" +
                                "You have to pay "+ Math.abs(b.getDaysleft()*50)+ "as fine\n");
                    }
                    book.setBrwcopies(book.getBrwcopies() +1);
                    database.returnBook(b, book, i);
                    System.out.println("Book returned\nThank you");
                    break;
                } else {
                    System.out.println("You didn't borrow this book");
                }
            }
        }else {
            System.out.println("You didn't borrow this book");
        }
        user.menu(database, user);
    }
}

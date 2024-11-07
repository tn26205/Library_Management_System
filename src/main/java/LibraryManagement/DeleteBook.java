package LibraryManagement;


import java.util.Scanner;

public class DeleteBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name:");
        String bookName = s.nextLine();

        int i = database.getBook(bookName);
        if(i>-1){
          database.deleteBook(i);
            System.out.println("Book deleted successfully!\n");
        }else{
            System.out.println("Book does not exist!\n");
        }
        user.menu(database, user);
    }
}

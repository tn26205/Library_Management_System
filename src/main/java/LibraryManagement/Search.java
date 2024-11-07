package LibraryManagement;

import java.util.Scanner;

public class Search implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("\nEnter book name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int i = database.getBook(name);
        if(i>-1){
            System.out.println("\n"+database.getBook(i).toString()+"\n");
        }else{
            System.out.println("Book does not exist!\n");
        }
        user.menu(database, user);
    }
}







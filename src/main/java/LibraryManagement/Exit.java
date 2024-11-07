package LibraryManagement;

import java.util.Scanner;

public class Exit implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("\nAre you sure that you want to quit?\n" +
                "1.Yes\n2.Main Menu");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if(i == 1){
            s.close();
        }else {
            user.menu(database, user);
        }
    }
}

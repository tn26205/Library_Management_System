package org.example;
import java.io.*;
import java.util.ArrayList;

public class Database {
   private ArrayList<User>users = new ArrayList<User>();
   private ArrayList<String>usernames = new ArrayList<String>();
   private ArrayList<Book>books = new ArrayList<Book>();
   private  ArrayList<String>booknames = new ArrayList<String>();

    private File usersfile = new File(Main.class.getClassLoader().getResource("Users").getFile());
    private File booksfile = new File(Main.class.getClassLoader().getResource("Books").getFile());

    public Database() {
        if(!usersfile.exists()){
            usersfile.mkdir();
        }
        if(!booksfile.exists()){
            booksfile.mkdir();
        }
    }

    public void AddUser(User s) {
        users.add(s);
        usernames.add(s.getName());
    }
    public int login(String phonenumber, String email){
        int n = -1 ;
        for(User s : users){
            if (s.getPhoneNumber().matches(phonenumber)&&s.getEmail().matches(email)){
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }
    public User getUser(int n){
        return users.get(n);
    }
    public void AddBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
    }
    private void getUsers() {
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
            String s1;
             while((s1= br1.readLine())!=null){
                  text1 = text1 + s1;
            }
             br1.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        if(!text1.matches("")||!text1.isEmpty()){
            String[] a1 = text1.split("<NewUser/>");
            for(String s : a1) {
                String [] a2 = s.split("<N/>");
                if(a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1],a2[2]);
                    AddUser(user);
                }else{
                    User user = new NormalUser(a2[0], a2[1],a2[2]);
                   AddUser(user);
                }
            }
        }
    }
    private void saveUsers() {
        String text1 = "";
        for(User user : users){
            text1 += user.toString() + "<NewUser/>\n" ;
        }
        try {
            PrintWriter pw = new PrintWriter(usersfile);
            pw.println(text1);
            pw.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}

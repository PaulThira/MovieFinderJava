import java.util.*;
import java.util.stream.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Person {
    private String Name;
    private TypeOfUser userType;
    private List<Integer> likedMoviesGenre;
    private String Password;
    private boolean logedIn;
    public Person(){
        Name="Mara";
        userType=TypeOfUser.Admin;
        likedMoviesGenre=new ArrayList<Integer>(10);
        for(int i=0;i<10;i++){
            likedMoviesGenre.add(i,0);
        }
        Password="1234Pere";
        logedIn=false;
    }
    public Person(String name,TypeOfUser status,String Passwords){
        Name=name;
        userType=status;
        likedMoviesGenre=new ArrayList<Integer>(10);
        for(int i=0;i<10;i++){
            likedMoviesGenre.add(i,0);
        }
        Password=Passwords;
        logedIn=true;
    }
    public void Print(){
        System.out.println(Name);
    }
    public void SetName(String name){
        Name=name;
    }
    public void LikeMovie(Movie Film){
        Film.AddLike();
        MovieGenre G=Film.GetGenre();
        if(G==MovieGenre.Action){
           int count= likedMoviesGenre.get(0);
           likedMoviesGenre.set(0,count+1);
        }
        if(G==MovieGenre.Fantasy){
            int count= likedMoviesGenre.get(1);
            likedMoviesGenre.set(1,count+1);
        }
        if(G==MovieGenre.Comedy){
            int count= likedMoviesGenre.get(2);
            likedMoviesGenre.set(2,count+1);
        }
        if(G==MovieGenre.Fiction){
            int count= likedMoviesGenre.get(3);
            likedMoviesGenre.set(3,count+1);
        }
        if(G==MovieGenre.Horror){
            int count= likedMoviesGenre.get(4);
            likedMoviesGenre.set(4,count+1);
        }
        if(G==MovieGenre.Crime){
            int count= likedMoviesGenre.get(5);
            likedMoviesGenre.set(5,count+1);
        }
        if(G==MovieGenre.Indie){
            int count= likedMoviesGenre.get(6);
            likedMoviesGenre.set(6,count+1);
        }
        if(G==MovieGenre.Thriller){
            int count= likedMoviesGenre.get(7);
            likedMoviesGenre.set(7,count+1);
        }
        if(G==MovieGenre.Romance){
            int count= likedMoviesGenre.get(8);
            likedMoviesGenre.set(8,count+1);
        }
        if(G==MovieGenre.Drama){
            int count= likedMoviesGenre.get(9);
            likedMoviesGenre.set(9,count+1);
        }
    }
    public TypeOfUser GetStatus(){
        return userType;
    }
    public void ChangeStatus(TypeOfUser status,Person p){
        if(p.GetStatus()==TypeOfUser.Admin){
            userType=status;
        }
        else{
            System.out.println("You need an Admin to change your status");
        }
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void ChangePassword(String passwords){
        System.out.println("Write the password.....");
        Scanner in = new Scanner(System.in);

        String s=in.nextLine();
        if(s.equals(Password)){
            Password=passwords;
            System.out.println("Changed Password");
        }
        else{
            System.out.println("Incorect Password");
        }
    }
    public void LogIn(){

            System.out.println("Write the password.....");
            Scanner in = new Scanner(System.in);

            String s=in.nextLine();
            if(s.equals(Password)){
                logedIn=true;
                System.out.println("Welcome back "+Name);
            }
            else{
                System.out.println("Incorrect Password");

            }


    }
    public void LogOut(){
        System.out.println("Logged out");
        logedIn=false;
    }
public MovieGenre  MostLikedGenre(){
        int dominantGenre=Collections.max(likedMoviesGenre);
        int i=likedMoviesGenre.indexOf(dominantGenre);
        MovieGenre genre = null;
    if(i==0){
        genre=MovieGenre.Action;
    }
    if(i==1){
        genre=MovieGenre.Fantasy;
    }
    if(i==2){
        genre=MovieGenre.Comedy;
    }
    if(i==3){
        genre=MovieGenre.Fiction;
    }
    if(i==4){
        genre=MovieGenre.Horror;
    }
    if(i==5){
        genre=MovieGenre.Crime;
    }
    if(i==6){
        genre=MovieGenre.Indie;
    }
    if(i==7){
        genre=MovieGenre.Thriller;
    }
    if(i==8){
        genre=MovieGenre.Romance;
    }
    if(i==9){
        genre=MovieGenre.Drama;
    }
    return genre;
}

    public String getName() {
        return Name;
    }
}






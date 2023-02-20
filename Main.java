import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter; // Step 1
import java.io.IOException;
import java.io.*;

public class Main {


    public static void Menu(Feed F,Accounts A) throws IOException{

            Scanner in = new Scanner(System.in);
        FileWriter writer = new FileWriter("C:\\Users\\pault\\Desktop\\MoviesList.txt");
        BufferedWriter buffer = new BufferedWriter(writer);

        for(int i=0;i<F.getRecomandations().size();i++){
            buffer.write(F.getRecomandations().get(i).GetTitle());
            buffer.newLine();
            buffer.write(F.getRecomandations().get(i).getDescription());
            buffer.newLine();
            buffer.write(F.getRecomandations().get(i).getReleaseDate().toString());
            buffer.newLine();
            buffer.write(F.getRecomandations().get(i).getDirector());
            buffer.newLine();
            buffer.write(F.getRecomandations().get(i).getMovieStudio());
            buffer.newLine();
            buffer.write(F.getRecomandations().get(i).getLikes());
            buffer.newLine();
        }
        buffer.close();
        System.out.println("Success");
        System.out.println("0 is for registering");
            System.out.println("1 is for showing the feed");
            System.out.println("2 is for searching for a movie");
            System.out.println("3 is for liking a movie");
            System.out.println("4 is for logging in");
            System.out.println("5 is for for logout");
            System.out.println("6 is for searching for an account");
            System.out.println("7 is for showing the most popular movies");
            System.out.println("8 is for closing the app");
            Person P=new Person();
            int option=in.nextInt();

            do{


                switch(option){
                    case 0:
                        System.out.println("Type your name and a password in order to register");

                        String namelyAndPasswords=in.nextLine();


                        String[] VAccounts=namelyAndPasswords.split(" ");

                        P.SetName(VAccounts[1]);
                        P.setPassword(VAccounts[2]);
                        A.AddAccount(P);

                        P=new Person();
                        System.out.println("Account made successfully!");
                        break;
                    case 1:
                        System.out.println("This is your feed....");
                        LinkedList<Movie>Films=F.getRecomandations();
                        for(int i=0;i<F.getRecomandations().size();i++){
                          F.getRecomandations().get(i).Print();
                        }
                        // Write the name of four oceans to the file


                        // Close the file.

                    break;
                    case 2:
                        System.out.println("Type the movie you are looking for....");
                        String s=in.nextLine();
                        F.SearchForMovies(s);
                        break;
                    case 3:
                        System.out.println("Type the movie you want to like....");
                        String p=in.nextLine(), s1=in.nextLine();
                        int i=F.FindMovie(s1);
                        F.ShowFeed(P);
                        F.LikeMovie(i);
                        P.LikeMovie(F.getRecomandations().get(i));
                        System.out.println("Thank you for yor feedback!!!!");
                        break;
                    case 4:
                        System.out.println("Type in the username and password");
                        String namesAndPasswords;

                        namesAndPasswords=in.nextLine();
                        String[] VAccount=namesAndPasswords.split(" ");
                        break;

                    case 5:
                        P.LogOut();
                        System.out.println("Logout successful!");
                        break;
                    case 6:
                        System.out.println("Type in the name of the account you are looking for");
                        String s2=in.nextLine();
                        A.LookingForWho(s2);
                        break;
                    case 7:
                        LinkedList<Movie>S=F.SortMovies();
                        System.out.println("These are the best movies in order.......");
                        for(int i1=0;i1<S.size();i1++){
                            S.get(i1).Print();
                        }
                        break;
                    case 8:

                        break;

                }
                System.out.println("ByeBye");
                option=in.nextInt();
        }while(option!=8);





        }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");

        try {
            Scanner sc=new Scanner(new File("C:\\Users\\pault\\Desktop\\Accounts.txt"));
            int c=0;
            String s=sc.nextLine();
            LinkedList<String> MovieFiles=new LinkedList<String>();
            Accounts A=new Accounts();

            Person P=new Person("FirstAdmin",TypeOfUser.Admin,"Netflix");
            A.AddAccount(P);
            Feed F=new Feed();
            while(sc.hasNextLine()){

               for(int i=0;i<6;i++){
                   if(sc.hasNextLine()==false){
                       break;
                   }
                   if(c%6==i){
                       MovieFiles.push(sc.nextLine());
                   }
                   c++;
               }
               if(c%6==0&&c!=0){
                    Movie M=new Movie();

                    M.SetTitle(MovieFiles.get(0));
                    M.SetDescription(MovieFiles.get(5));
                   SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                   try{
                       M.SetDate(DateFor.parse(MovieFiles.get(4)));
                   } catch (ParseException e) {
                       throw new RuntimeException(e);
                   }
                   M.SetDirector(MovieFiles.get(3));
                   M.SetStudio(MovieFiles.get(2));
                   int K=Integer.parseInt(MovieFiles.get(1));
                   if(K>=0&&K<=9){
                       if(K==0){
                           M.SetGenre(MovieGenre.Action);
                       }
                       if(K==1){
                           M.SetGenre(MovieGenre.Fantasy);

                       }
                       if(K==2){
                           M.SetGenre(MovieGenre.Comedy);

                       }
                       if(K==3){
                           M.SetGenre(MovieGenre.Fiction);

                       }
                       if(K==4){
                           M.SetGenre(MovieGenre.Horror);

                       }
                       if(K==5){
                           M.SetGenre(MovieGenre.Crime);

                       }
                       if(K==6){
                           M.SetGenre(MovieGenre.Indie);

                       }
                       if(K==7){
                           M.SetGenre(MovieGenre.Thriller);

                       }
                       if(K==8){
                           M.SetGenre(MovieGenre.Romance);
                       }
                       if(K==9){
                           M.SetGenre(MovieGenre.Drama);
                       }

                   }


                   F.AddMovie(M,P);

                   MovieFiles.clear();
               }


            }

            Menu(F,A);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
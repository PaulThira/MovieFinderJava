import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.util.Calendar;

public class Movie {
    private String title;
    private String Description;
    private Date releaseDate;
    private String director;
    private String movieStudio;
    private MovieGenre genre;
    private Integer Likes;
    public Movie(){
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        title="Avatar ";
        Description="A 12 year old kills a sociopathic tyrant with the power of the elements";
        director="Aang";
        movieStudio="Nickelodeon";
        genre=MovieGenre.Fantasy;
        Likes=0;
        try{
            releaseDate=DateFor.parse("08/12/2011");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
    public void SetTitle(String titles){
        title=titles;
    }
    public void SetDescription(String describe){
        Description=describe;
    }
    public void SetDirector(String directors){
        director=directors;
    }
    public void SetStudio(String studios){
       movieStudio=studios;
    }
    public void SetGenre(MovieGenre genres){
        genre=genres;
    }
    public void Print(){
        System.out.println(title);
        System.out.println(Description);
        System.out.println(director);
        System.out.println(movieStudio);
        System.out.println(genre.toString());
        System.out.println(releaseDate.toString());

    }
    public void AddLike(){
        Likes += 1;
    }
    public MovieGenre GetGenre(){
        return genre;
    }
    public void ReadMovie(){
        Scanner in = new Scanner(System.in);
        title=in.nextLine();
        Description=in.nextLine();
        director=in.nextLine();
        movieStudio=in.nextLine();
        int i=in.nextInt();
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
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String dates=in.nextLine();
        try{
            releaseDate=DateFor.parse(dates);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
public void SetDate(Date D){
        releaseDate=D;
}
public String GetTitle(){
        return title;
}

    public Integer getLikes() {
        return Likes;
    }

    public String getDescription() {
        return Description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieStudio() {
        return movieStudio;
    }
}

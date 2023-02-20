import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Feed {
    private LinkedList<Movie> Recomandations;

   public  Feed(){
       Movie e=new Movie();
       Recomandations=new LinkedList<Movie>();
       Recomandations.push(e);
    }
    public Feed(int nrOfMovies){

        Recomandations=new LinkedList<Movie>();
        for(int i=0;i<nrOfMovies;i++){
            Movie e=new Movie();
            Recomandations.push(e);
            System.out.println("Movie added!");
        }
    }
    public void ShowFeed(Person P){
       MovieGenre preferedGenre=P.MostLikedGenre();
       List<Movie> preferedMovies=Recomandations.stream().filter(Movie->Movie.GetGenre()==preferedGenre).collect(Collectors.toList());
       List<Movie> restOfTheMovies=Recomandations.stream().filter(Movie->Movie.GetGenre()!=preferedGenre).collect(Collectors.toList());
        Collections.shuffle(restOfTheMovies);
        Collections.shuffle(preferedMovies);
       for(int i=0;i<preferedMovies.size();i++){
           preferedMovies.get(i).Print();
       }
        for(int i=0;i<restOfTheMovies.size();i++){
            restOfTheMovies.get(i).Print();
        }
    }
    public Feed(int nrOfMovies,LinkedList<Movie>films){
        Recomandations=films;

    }

    public void AddMovie(Movie M,Person P){
       if(P.GetStatus()==TypeOfUser.Admin){

           Recomandations.push(M);

       }
       else{
           System.out.println("Only Admins can add movies");
       }
    }
    public void SearchForMovies(String MovieName){
       LinkedList<String>MovieNames=new LinkedList<String>();
       for(int i=0;i<Recomandations.size();i++){
           MovieNames.push(Recomandations.get(i).GetTitle());
       }
        Pattern pattern = Pattern.compile(MovieName, Pattern.CASE_INSENSITIVE);
        LinkedList<Matcher> SimilarMovies=new LinkedList<Matcher>();
        for(int i=0;i<Recomandations.size();i++){
            SimilarMovies.push(pattern.matcher(MovieName));
        }

        for(int i=0;i<Recomandations.size();i++){
            if(SimilarMovies.get(i).find()==true){
                Recomandations.get(i).Print();
            }
        }

    }

    public LinkedList<Movie> getRecomandations() {
        return Recomandations;
    }
    public int FindMovie(String Title){
        for(int i=0;i<Recomandations.size();i++){
            if(Recomandations.get(i).GetTitle().equals(Title)){
                Recomandations.get(i).Print();
                return i;
            }
        }

        return -1;
    }
    public void LikeMovie(int i){
       Recomandations.get(i).AddLike();
    }
    public LinkedList<Movie> SortMovies(){
       LinkedList<Integer> Likes=new LinkedList<>();
       for(int i=0;i<Recomandations.size();i++){
           Likes.add(Recomandations.get(i).getLikes());
       }
       List<Integer> Sorted=Likes.stream().sorted().collect(Collectors.toList());
       LinkedList<Integer>Positions=new LinkedList<Integer>();
       for(int i=0;i<Recomandations.size();i++){
           for(int j=0;j<Recomandations.size();j++){
               if(Likes.get(i)==Sorted.get(j)){
                   Positions.add(j);
               }
           }
       }
       LinkedList<Movie> SortedMovies=new LinkedList<Movie>();
       for(int i=0;i<Recomandations.size();i++){
           SortedMovies.add(Recomandations.get(Positions.get(i)));
       }
       return SortedMovies;
    }
}

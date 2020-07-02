import java.util.*;

public class Solution{
public static void main(String [] args){
    Scanner s = new Scanner(System.in);
    Movie [] moviee = new Movie[4];
    for(int i=0; i<moviee.length; i++){
        int movieId = s.nextInt(); s.nextLine();
      String director = s.nextLine();
      int rating = s.nextInt();s.nextLine();
      int budget = s.nextInt(); s.nextLine();
      moviee[i]=new Movie(movieId, director, rating, budget);
    }

    String directors = s.nextLine();
    int ratings = s.nextInt();s.nextLine();
    int budgets = s.nextInt(); s.nextLine();
    int output1 = findAvgBudgetByDirector(moviee, directors);
    if(output1>0){
        System.out.println(output1);
    } else {
        System.out.println("Sorry – No movie is available with the specified rating and budget requirement");
    }

    Movie output2 = getMovieByRatingBudget(moviee, ratings, budgets);

    if(output2!=null){
        System.out.println(output2.getMovieId());
    } else {
        System.out.println("Sorry -No movie is available with the specified rating and budget requirement");
    }



}



public static int findAvgBudgetByDirector(Movie [] movie, String director){
    int amount = 0;
    int count=0;
    for(int i=0; i<movie.length; i++){
        if(movie[i].getDirector().equalsIgnoreCase(director)){
            count++;
            amount = amount + movie[i].getBudget();
        }
    }
    return amount/count;

}

public static Movie getMovieByRatingBudget(Movie [] movies, int rating, int budget){
Movie movie1 = null;
for(int i=0; i<movies.length; i++){
    if(movies[i].getRating()==rating && movies[i].getBudget()==budget){
        if(movies[i].getBudget()%movies[i].getRating()==0){
            movie1=movies[i];
            return movie1;
        }
    }
}
return null;
}



}
 class Movie {
     private int movieId;
     private String director;
     private int rating;
     private int budget;

	public Movie(int movieId, String director, int rating, int budget) {
		this.movieId = movieId;
		this.director = director;
		this.rating = rating;
		this.budget = budget;
    }

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
    
    

     
    
}
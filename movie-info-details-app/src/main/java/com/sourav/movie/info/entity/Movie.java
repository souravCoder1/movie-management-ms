// Movie.java - Entity class representing a movie
@Entity
public class Movie {
    @Id
    private Long id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    // other attributes, getters, and setters
}

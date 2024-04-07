// MovieService.java - Service class to handle business logic
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}

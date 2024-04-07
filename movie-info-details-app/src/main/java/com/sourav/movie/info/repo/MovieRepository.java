// MovieRepository.java - Repository interface for Movie entity
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // custom query methods if needed
}
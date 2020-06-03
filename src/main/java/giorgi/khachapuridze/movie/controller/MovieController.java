package daviti.chanturia.movie.controller;


import daviti.chanturia.movie.dto.movie.*;
import daviti.chanturia.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("addMovie")
    public AddMovieOutput addMovie(@RequestBody AddMovieInput addMovieInput) {
        return movieService.addMovie(addMovieInput);
    }

    @PostMapping("getMovie")
    public GetMovieOutput getMovie(@RequestBody GetMovieInput getMovieInput) {
        return movieService.getMovie(getMovieInput);
    }

    @PostMapping("getMovies")
    public GetMoviesOutput getMovies(@RequestBody GetMoviesInput getMoviesInput) {
        return movieService.getMovies(getMoviesInput);
    }

    @DeleteMapping("deleteMovie/{id}")
    public void deletePost(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}

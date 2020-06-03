package daviti.chanturia.movie.service;

import daviti.chanturia.movie.dto.movie.*;

public interface MovieService {
    AddMovieOutput addMovie(AddMovieInput addMovieInput);

    GetMovieOutput getMovie(GetMovieInput getMovieInput);

    GetMoviesOutput getMovies(GetMoviesInput getMoviesInput);

    void deleteMovie(Long id);
}
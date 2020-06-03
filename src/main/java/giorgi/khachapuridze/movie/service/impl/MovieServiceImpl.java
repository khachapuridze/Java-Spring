package daviti.chanturia.movie.service.impl;


import daviti.chanturia.movie.dto.movie.*;
import daviti.chanturia.movie.model.Movie;
import daviti.chanturia.movie.repository.MovieRepository;
import daviti.chanturia.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public AddMovieOutput addMovie(AddMovieInput addMovieInput) {

        Movie movie = new Movie();
        movie.setTitle(addMovieInput.getTitle());
        movie.setCountry(addMovieInput.getCountry());

        movieRepository.save(movie);

        AddMovieOutput addMovieOutput = new AddMovieOutput();
        addMovieOutput.setMsg("ფილმი წარმატებით დაემატა");
        return addMovieOutput;
    }





    @Override
    public GetMoviesOutput getMovies(GetMoviesInput getMoviesInput) {
        List<MovieDTO> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setCountry(movie.getCountry());
            movies.add(movieDTO);
        }
        GetMoviesOutput getMoviesOutput = new GetMoviesOutput();
        getMoviesOutput.setMovieDTOList(movies);
        return getMoviesOutput;
    }


    @Override
    public GetMovieOutput getMovie(GetMovieInput getMovieInput) {

        Movie movie = movieRepository.getOne(getMovieInput.getMovieId());

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setCountry(movie.getCountry());

        GetMovieOutput getMovieOutput = new GetMovieOutput();
        getMovieOutput.setCountry(movieDTO.getCountry());
        getMovieOutput.setId(movieDTO.getId());
        getMovieOutput.setTitle(movieDTO.getTitle());
        return getMovieOutput;
    }




    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.getOne(id);
        movieRepository.delete(movie);
    }



}

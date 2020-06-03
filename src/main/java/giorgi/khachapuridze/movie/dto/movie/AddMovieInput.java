package daviti.chanturia.movie.dto.movie;

import lombok.Data;

@Data
public class AddMovieInput {
    private Long id;
    private String title;
    private String country;

}

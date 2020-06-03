package daviti.chanturia.movie.dto.movie;

import lombok.Data;

import java.util.List;

@Data
public class GetMoviesOutput {
    List<MovieDTO> movieDTOList;

}

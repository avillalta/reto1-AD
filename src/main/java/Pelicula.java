import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    private String id;
    private String titulo;
    private Integer anho;
    private String director;
    private String genero;


}

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File archivoPelis = new File("peliculas.csv");
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new FileReader(archivoPelis))){
            String linea;
            while ((linea = bfr.readLine()) != null){
                var partes = linea.split(",");
                peliculas.add(new Pelicula(
                        partes[0],
                        partes[1],
                        Integer.parseInt(partes[2]),
                        partes[3],
                        partes[4]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder resultado = new StringBuilder();
        try(BufferedReader bfr = new BufferedReader(new FileReader("template.html"))) {
            String linea;
            while((linea = bfr.readLine()) != null) {
                resultado.append(linea).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File dir = new File("salida");
        dir.mkdir();

        for(Pelicula m : peliculas) {
            try(BufferedWriter bfw = new BufferedWriter(new FileWriter("salida/"+m.getTitulo()+"-"+m.getId()+".html"))) {
                bfw.write(
                        resultado.toString()
                                .replace("%%1%%", m.getId())
                                .replace("%%2%%", m.getTitulo())
                                .replace("%%3%%", m.getAnho().toString())
                                .replace("%%4%%", m.getDirector())
                                .replace("%%5%%", m.getGenero())
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

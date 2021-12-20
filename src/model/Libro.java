package model;
/**
 * Clase encargada de administrar los datos y
 * atributos del onjeto libro
 * @version  19/12/21
 * @author Deisy Monroy y Karen Hernández
 */
public class Libro {
    /**
     *Atrubutos de la clase Libro
     */
    private String idLibro;
    private String titulo;
    private String autor;
    private String genero;
    /**
     *constructor de la clase
     * @param  idLibro que es de tipo string
     */
    public Libro(String idLibro){
        this.idLibro=idLibro;
    }

    /**
     *constructor de la clase
     * @param  idLibro que es de tipo string
     * @param  titulo que es de tipo string
     * @param  autor que es de tipo string
     */
    public Libro(String idLibro, String titulo, String autor, String genero) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     *metodos get y set de los atributos
     */

    /**
     *metodo de get de idLibro
     * @return idLibro
     */
    public String getIdLibro() {
        return idLibro;
    }
    /**
     *metodo de set de idLibro
     * @param  idLibro
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }
    /**
     *metodo de get de titulo
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     *metodo de set de titulo
     * @param  titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     *metodo de get de autor
     * @return autor
     */
    public String getAutor() {
        return autor;
    }
    /**
     *metodo de set de autor
     * @param  autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     *metodo toString de la clase
     * @return el libro, el titulo y el autor
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro='" + idLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}

/**
 * Representa un Pokémon con atributos básicos como nombre, tipo, nivel, aguante y poder.
 */
public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;
    private int poder;

    /**
     * Constructor para inicializar un Pokémon con nombre y tipo.
     * El nivel se establece automáticamente a 1, y el aguante se calcula según el nivel.
     *
     * @param nombre Nombre del Pokémon.
     * @param tipo   Tipo del Pokémon (e.g., "Agua", "Fuego", "Tierra").
     */
    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        nivel = 1;
        this.aguante = (int) Math.round(nivel * 2.5); // Se calcula el aguante.
    }

    /**
     * Constructor para inicializar un Pokémon con nombre, tipo y nivel específico.
     * El aguante se calcula según el nivel dado.
     *
     * @param nombre Nombre del Pokémon.
     * @param tipo   Tipo del Pokémon (e.g., "Agua", "Fuego", "Tierra").
     * @param nivel  Nivel inicial del Pokémon.
     */
    public Pokemon(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.aguante = (int) Math.round(nivel * 2.5); // Se calcula el aguante.
    }

    /**
     * Obtiene el valor actual del aguante del Pokémon.
     *
     * @return El valor de aguante.
     */
    public int getAguante() {
        return aguante;
    }

    /**
     * Establece un nuevo valor para el aguante del Pokémon.
     *
     * @param aguante Nuevo valor de aguante.
     */
    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    /**
     * Obtiene el nombre del Pokémon.
     *
     * @return Nombre del Pokémon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del Pokémon.
     *
     * @return Tipo del Pokémon.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nivel actual del Pokémon.
     *
     * @return Nivel del Pokémon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece un nuevo nivel para el Pokémon.
     *
     * @param nivel Nuevo nivel del Pokémon.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Calcula el poder del Pokémon en función de su nivel y el tipo del oponente.
     *
     * @param contrincante El Pokémon oponente.
     * @return El poder calculado del Pokémon.
     */
    public int calcularPoder(Pokemon contrincante) {
        int min = nivel * 3;
        int max = nivel * 10;
        poder = (int) (Math.random() * (max - min + 1)) + min;

        // Ajuste de poder según los tipos de los Pokémon.
        if ((tipo == "Agua") && (contrincante.tipo == "Fuego")) {
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Agua") && (contrincante.tipo == "Tierra")) {
            contrincante.poder = poder - (2 * nivel);
        }
        if ((tipo == "Fuego") && (contrincante.tipo == "Agua")) {
            contrincante.poder = poder - (2 * nivel);
        }
        if ((tipo == "Fuego") && (contrincante.tipo == "Tierra")) {
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Tierra") && (contrincante.tipo == "Agua")) {
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Tierra") && (contrincante.tipo == "Fuego")) {
            contrincante.poder = poder - (2 * nivel);
        }
        return poder;
    }

    /**
     * Incrementa el nivel del Pokémon en 1 y actualiza sus estadísticas.
     */
    public void subirNivel() {
        this.nivel++;
        this.actualizarStats();
    }

    /**
     * Actualiza las estadísticas del Pokémon, recalculando su aguante según el nivel.
     */
    public void actualizarStats() {
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    /**
     * Disminuye el aguante del Pokémon en 1.
     */
    public void disminuirAguante() {
        this.aguante--;
    }

    /**
     * Devuelve una representación en texto de los atributos del Pokémon.
     *
     * @return Una cadena que describe el Pokémon.
     */
    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }
}

public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;
    private int poder;

// Añada los constructores********************

    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        nivel = 1;
        this.aguante = (int) Math.round(nivel * 2.5);
        // se calculara aguante
    }
    public Pokemon(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.aguante = (int) Math.round(nivel * 2.5); // se calculara aguante
    }



// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // la logica genial: Si nivel es 1 = crear numero aleatorio entre 3 y 10; 2: 6 y 20 etc.
    // profe ha dicho que mejor si creamos la posibilidad de tener nivel mayor que solo 4 asi que he inmentado esto.
    public int calcularPoder(Pokemon contrincante){
        int min = nivel * 3;
        int max = nivel * 10;
        poder = (int) (Math.random() * (max - min + 1)) + min;

        // los tipos
        if ((tipo == "Agua") && (contrincante.tipo == "Fuego")) {
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Agua") && (contrincante.tipo == "Tierra")){
            contrincante.poder = poder - (2 * nivel);
        }
        if ((tipo == "Fuego") && (contrincante.tipo == "Agua")) {
            contrincante.poder = poder - (2 * nivel);
        }
        if ((tipo == "Fuego") && (contrincante.tipo == "Tierra")){
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Tierra") && (contrincante.tipo == "Agua")) {
            poder = poder + (2 * this.nivel);
        }
        if ((tipo == "Tierra") && (contrincante.tipo == "Fuego")){
            contrincante.poder = poder - (2 * nivel);
        }
        return poder;
    }

    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}

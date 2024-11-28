/**
 * Representa un combate entre dos Pokémon, permitiendo realizar rondas
 * y determinar un ganador.
 */
public class Combate {

    /**
     * Pokémon del jugador.
     */
    public Pokemon pokemonJugador;

    /**
     * Pokémon del rival.
     */
    public Pokemon pokemonRival;

    /**
     * Constructor que inicializa el combate con dos Pokémon, uno del jugador
     * y otro del rival.
     *
     * @param pokemonJugador El Pokémon controlado por el jugador.
     * @param pokemonRival   El Pokémon controlado por el rival.
     */
    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival) {
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }

    /**
     * Realiza una ronda de combate entre los dos Pokémon.
     * Calcula el poder de cada uno, y disminuye el aguante del perdedor.
     * Si el poder es igual, reinicia la ronda para determinar un ganador.
     *
     * @return El Pokémon ganador de la ronda.
     */
    public Pokemon Ronda() {
        int poderJugador = pokemonJugador.calcularPoder(pokemonJugador);
        int poderRival = pokemonRival.calcularPoder(pokemonRival);

        if (poderJugador > poderRival) {
            pokemonRival.disminuirAguante();
            return pokemonJugador;
        } else if (poderRival > poderJugador) {
            pokemonJugador.disminuirAguante();
            return pokemonRival;
        } else {
            // Si hay empate, reinicia la ronda.
            return Ronda();
        }
    }

    /**
     * Determina el ganador del combate verificando cuál Pokémon
     * tiene aguante restante.
     *
     * @return El Pokémon ganador o null si no hay un ganador claro.
     */
    public Pokemon Ganador() {
        if (pokemonJugador.getAguante() == 0 && pokemonRival.getAguante() != 0) {
            return pokemonRival;
        } else if (pokemonJugador.getAguante() != 0 && pokemonRival.getAguante() == 0) {
            return pokemonJugador;
        } else {
            return null;
        }
    }
}

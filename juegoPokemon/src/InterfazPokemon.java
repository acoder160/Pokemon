import java.util.Scanner;

/**
 * Clase que representa la interfaz del juego de Pokémon.
 * Permite la interacción del jugador con el sistema y gestiona el flujo del juego.
 */
public class InterfazPokemon {
    private Scanner teclado; // Para leer la entrada del jugador.
    public int rondaCombate = 0; // Ronda actual del combate.
    private boolean juego = true; // Estado del juego (activo o finalizado).

    /**
     * Constructor que inicializa el scanner para la entrada del jugador.
     */
    public InterfazPokemon() {
        teclado = new Scanner(System.in);
    }

    /**
     * Método principal que gestiona el flujo del juego.
     * Incluye la creación del Pokémon del jugador y los combates contra oponentes.
     */
    public void Juego() {
        System.out.println("..........................................................\n" +
                "...................--Crea tu pokemon--....................\n" +
                "..........................................................");

        // Creación del Pokémon del jugador.
        Pokemon pokemonJugador = menuCreacionPokemonJugador();

        // Bucle principal del juego.
        while (juego) {
            rondaCombate++;
            Pokemon pokemonRival = siguientePokemonRival();
            System.out.println("Presentación del Pokémon oponente:\n");
            System.out.println(pokemonRival.toString());
            pulsaEnter();

            // Inicio del combate.
            Pokemon ganador = Partida(pokemonJugador, pokemonRival);
            if (ganador == pokemonRival) {
                System.out.println(pokemonRival.getNombre() + " te ha derrotado");
                mostrarFinPartida();
                juego = false;
            } else if (ganador == pokemonJugador) {
                System.out.println("Genial: Has derrotado a " + pokemonRival.getNombre());
                pokemonJugador.subirNivel();

                // Verificar si se han derrotado a los tres rivales.
                if (rondaCombate == 3) {
                    mostrarJuegoSuperado();
                    juego = false;
                    break;
                }
                pulsaEnter();
            }
        }
    }

    /**
     * Método que gestiona una partida entre dos Pokémon.
     *
     * @param pokemonJugador Pokémon del jugador.
     * @param pokemonRival   Pokémon rival.
     * @return El Pokémon ganador de la partida.
     */
    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);
        while (combate.Ganador() == null) {
            System.out.println("Gana la ronda " + combate.Ronda().getNombre());
            System.out.println("Aguante de " + pokemonJugador.getNombre() + ": " + pokemonJugador.getAguante());
            System.out.println("Aguante de " + pokemonRival.getNombre() + ": " + pokemonRival.getAguante());
            if (combate.Ganador() == pokemonRival) {
                return pokemonRival;
            } else if (combate.Ganador() == pokemonJugador) {
                return pokemonJugador;
            }
        }
        return null;
    }

    /**
     * Menú de creación del Pokémon del jugador.
     *
     * @return El Pokémon creado por el jugador.
     */
    private Pokemon menuCreacionPokemonJugador() {
        System.out.println("Introduce el nombre del Pokémon:");
        String nombre = teclado.nextLine();

        System.out.println("Elige el tipo del Pokémon (1. Agua, 2. Fuego, 3. Tierra):");
        int n = teclado.nextInt();
        teclado.nextLine(); // Limpia el buffer del scanner.
        String tipo = "";

        // Asignación del tipo basado en la elección del jugador.
        if (n == 1) {
            tipo = "Agua";
        } else if (n == 2) {
            tipo = "Fuego";
        } else if (n == 3) {
            tipo = "Tierra";
        } else {
            System.out.println("Has introducido un número incorrecto");
            juego = false; // Termina el juego si la entrada es inválida.
        }

        return new Pokemon(nombre, tipo);
    }

    /**
     * Genera el siguiente Pokémon rival según la ronda actual.
     *
     * @return El Pokémon rival generado.
     */
    public Pokemon siguientePokemonRival() {
        String nombre = "";
        String tipo = "";

        if (rondaCombate == 1) {
            nombre = "Caterpie";
            tipo = "Tierra";
        } else if (rondaCombate == 2) {
            nombre = "Bulbasaur";
            tipo = "Agua";
        } else if (rondaCombate == 3) {
            nombre = "Charmander";
            tipo = "Fuego";
        }

        return new Pokemon(nombre, tipo, rondaCombate);
    }

    /**
     * Muestra el mensaje de victoria al completar el juego.
     */
    private void mostrarJuegoSuperado() {
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    /**
     * Muestra el mensaje de derrota al perder el juego.
     */
    private void mostrarFinPartida() {
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO ++++++");
    }

    /**
     * Método para pausar el juego y continuar cuando se presiona ENTER.
     */
    private void pulsaEnter() {
        System.out.println("\nPULSA ENTER PARA CONTINUAR");
        teclado.nextLine();
    }
}

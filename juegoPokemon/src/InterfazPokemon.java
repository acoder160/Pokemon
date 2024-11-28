import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;
    public int rondaCombate = 0;
    private boolean juego = true;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }


    public void Juego() {
        System.out.println("..........................................................\n" +
                "...................--Crea tu pokemon--....................\n" +
                "..........................................................");
        // creamos el pokemon
    Pokemon pokemonJugador = menuCreacionPokemonJugador();
        while(juego){
            rondaCombate++;
    Pokemon pokemonRival = siguientePokemonRival();
        System.out.println("Presentación del pokemon oponente:\n");
        System.out.println(pokemonRival.toString());
            pulsaEnter();
        // iniciamos el combate
       Pokemon ganador = Partida(pokemonJugador, pokemonRival);
       if(ganador == pokemonRival){
           System.out.println(pokemonRival.getNombre() + " te ha derrotado");
           mostrarFinPartida();
           juego = false;
       }
       else if(ganador == pokemonJugador){
           System.out.println("Genial: Has derrotado a "+pokemonRival.getNombre());
           pokemonJugador.subirNivel();

            // ocurre si hemos ganado todos 3 pokemones rivales
            if(rondaCombate == 3){
                mostrarJuegoSuperado();
                juego = false;
                break;
            }
           pulsaEnter();
       }
       }
    }
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



    private Pokemon menuCreacionPokemonJugador(){
        System.out.println("Introduce el nombre del Pokémon:");
        String nombre = teclado.nextLine();

        System.out.println("Elige el tipo del Pokémon (1. Agua, 2. Fuego, 3. Tierra):");
        int n = teclado.nextInt();
        teclado.nextLine(); // Limpia el salto de línea pendiente (CHATGPT) limpia el bufer del scaner
        String tipo = "";
        if(n == 1){
            tipo = "Agua";
        }
        else if(n == 2){
            tipo = "Fuego";
        }
        else if(n == 3){
            tipo = "Tierra";
        }
        else{
            System.out.println("Has introducido numero incorrecto");
            juego = false;
        }
        Pokemon pokemonJugador = new Pokemon(nombre, tipo);
        return pokemonJugador;
    }

    public Pokemon siguientePokemonRival() {

        String nombre = "";
        String tipo = "";

        if(rondaCombate == 1){
             nombre = "Caterpie";
             tipo = "tierra";
        }
        else if(rondaCombate == 2){
            nombre = "Bulbasur";
            tipo = "agua";
        }
        else if (rondaCombate == 3) {
            nombre = "Charmander";
            tipo = "fuego";
        }

        Pokemon pokemonRival = new Pokemon(nombre, tipo, rondaCombate);
        return pokemonRival;

    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }
    // para mas reutilizacion del codigo
    private void pulsaEnter(){
        System.out.println("\nPULSA ENTER PARA CONTINUAR");
        teclado.nextLine();
    }

}

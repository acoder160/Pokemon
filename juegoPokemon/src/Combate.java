public class Combate {

    // Añada los atributos y el constructor *************

    public Pokemon pokemonJugador;
    public Pokemon pokemonRival;


    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }

    //***************************************************

    public Pokemon Ronda(){
    int poderJugador = pokemonJugador.calcularPoder(pokemonJugador);
    int poderRival = pokemonRival.calcularPoder(pokemonRival);

    if(poderJugador > poderRival){
        pokemonRival.disminuirAguante();
        return pokemonJugador;
    }
    else if(poderRival > poderJugador){
        pokemonJugador.disminuirAguante();
        return pokemonRival;
    }

    // si nadie ha ganado reiniciamos la ronda e reintentamos definir el ganador
    else{
        return Ronda();
    }

    }

    public Pokemon Ganador(){
        if(pokemonJugador.getAguante() == 0 && pokemonRival.getAguante() != 0){
            return pokemonRival;
        }
        else if(pokemonJugador.getAguante() != 0 && pokemonRival.getAguante() == 0){
            return pokemonJugador;
        }
        else{
            return null;
        }

    }
}


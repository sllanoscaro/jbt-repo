public class Main {
    public static void main(String[] args) {
        Funcion funcion1 = new Funcion("Minions","Accion","eyau","afsfsaf","niños");
        Sala sala1 = new Sala(1,"14:00");
        String[][] asientos = sala1.generarSaladeCine();
        funcion1.agregarSala(sala1);
        sala1.mostrarSalaCine(asientos);
        sala1.mostrarBooleanoSala();
        System.out.println("----------------------------------------------------------------------------");
        funcion1.reservarAsiento(sala1.getButacas(),3,'A');
        sala1.mostrarBooleanoSala();
        funcion1.marcarAsientoOcupado(asientos,3,'A');
        sala1.mostrarSalaCine(asientos);

    }

}

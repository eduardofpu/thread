package thread.bilder;

public class Main {


    public static void main(String[] args) {
        Pessoa p = new Pessoa()
                .nome("Eduardo")
                .email("eduardo.delfino@gmail.com")
                .sexo("M")
                .idade(37)
                .builder();

        System.out.println(p);
    }


}

package thread.bilder;


// Livro Effective Java
public class Pessoa {
        private String nome;
        private String email;
        private String sexo;
        private int idade;

    public Pessoa() {
    }

    private Pessoa(String nome, String email, String sexo, int idade) {
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Pessoa nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Pessoa email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa sexo(String sexo) {
            this.sexo = sexo;
            return this;
        }

        public Pessoa idade(int idade) {
            this.idade = idade;
            return this;
        }

        Pessoa builder(){
         return new Pessoa(nome, email, sexo , idade);
        }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                '}';
    }
}

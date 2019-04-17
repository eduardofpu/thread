package thread.conta;

public class ContaTest implements Runnable{

    private Conta conta = new Conta();

    public static void main(String[] args) {

        ContaTest contaTest = new ContaTest();
        Thread willian = new Thread(contaTest, "william");
        Thread anna = new Thread(contaTest, "Anna");

        willian.start();
        anna.start();
    }

    public static synchronized  void imprime(){

        synchronized (ContaTest.class){ // classe literal  fala para o compilador vai la e procura a instancia dessa classe
            System.out.println("asasaas");
        }

    }


    // Sincronizando a thread  apenas uma thread vai executar o codigo por vez
    private synchronized void saque(int valor){
        if(conta.getSaldo() >= valor){

            System.out.println(Thread.currentThread().getName() + " está indo sacar");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            conta.saque(valor);
            System.out.println(Thread.currentThread().getName() + " completou o saque "+ conta.getSaldo());
        }else{
            System.out.println(" Sem dinheiro para "+Thread.currentThread().getName()+" efetuar o saque, saldo: "+conta.getSaldo());
        }

    }

    //sincronizar por bloco
    private synchronized void saque2(int valor){
        synchronized (conta) {
            if (conta.getSaldo() >= valor) {

                System.out.println(Thread.currentThread().getName() + " está indo sacar");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                conta.saque(valor);
                System.out.println(Thread.currentThread().getName() + " completou o saque " + conta.getSaldo());
            } else {
                System.out.println(" Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: " + conta.getSaldo());
            }
        }
    }


    public void run() {

        for(int i = 0; i < 5 ; i++){
            saque(10);
            if(conta.getSaldo() < 0){
                System.out.println("Oh meu deus!");
            }

        }

    }
}

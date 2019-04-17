package thread.email.lock;

public class EntregadorLock implements Runnable {
    private ListaMembrosLock listaMembros;

    public EntregadorLock(ListaMembrosLock listaMembros) {
        this.listaMembros = listaMembros;
    }

    public void run() {

        String nomeThread = Thread.currentThread().getName();
        System.out.println("Começando o trabalho de entrega ");
        int qtdPendente = listaMembros.getEmailsPendentes();
        boolean aberta = listaMembros.isAberta();

        while (aberta || qtdPendente > 0){

            try{

                String email = listaMembros.obterEmailMembro();
                if(email != null){
                    System.out.println(nomeThread + " Enviando email para "+email);
                    Thread.sleep(2000);
                    System.out.println(" Envio para " + email + " concluido com sucesso");
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }

            aberta = listaMembros.isAberta();
            qtdPendente = listaMembros.getEmailsPendentes();

        }

        System.out.println("Atividades finalizadas");
    }
}

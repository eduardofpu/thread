package thread.email.lock;

import javax.swing.*;

public class EntregadorMain {
    public static void main(String[] args) {

        ListaMembrosLock listaMembros = new ListaMembrosLock();
        Thread t1 = new Thread(new EntregadorLock(listaMembros), " Entregador 1 ");
        Thread t2 = new Thread(new EntregadorLock(listaMembros), " Entregador 2 ");

        t1.start();
        t2.start();

        while (true){
            String email = JOptionPane.showInputDialog(" Digite o email do membro ");
            if(email == null){
                listaMembros.fecharLista2();
                break;
            }
            listaMembros.adicionarEmailMembro(email);
        }

    }
}

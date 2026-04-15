import java.util.*;
import java.time.*;

public class PedidoExame {
    String cpf;
    String nome;
    LocalDate dataRealz;
    LocalDate dataEntreg;
    ArrayList<Exame> examesSolicitados; 

    public PedidoExame(String cpf, String nome, LocalDate dataRealz, LocalDate dataEntreg, ArrayList<Exame> examesSolicitados) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataRealz = dataRealz;
        this.dataEntreg = dataEntreg;
        this.examesSolicitados =  examesSolicitados;
        //antes this.examesSolicitados =new ArrayList<>(); tava ignorando a lista q criei e printando uma vazia
    }

    public void mostrarPedido(){
        int cont = 1;
        System.out.println("CPF: " +cpf+ "\nNOME: " + nome + "   DATA REALIZAÇÃO: " + dataRealz.toString().replace("-", "/"));
        for (Exame e : examesSolicitados) {
            System.out.println("EXAME " + cont + " :" + e.toString());
            cont++;
        }
        System.out.println("DATA LIBERAÇÃO RESULTADOS: " + dataEntreg.toString().replace("-", "/"));
    }
}
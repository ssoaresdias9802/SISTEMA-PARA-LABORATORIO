import java.util.*;
/*
Laura Rocha Yaguiu RA: 10736399
Stephanie Soares Dias Ra: 10223952
*/
public class Main {
    boolean finalizado = false;

    


    public static void main (String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Laboratorio lab = new Laboratorio();
        int opcao;
        boolean carregarExames = false;
        boolean carregarEstatisticas = false;
        String cpf;
        String nome;
         
        do {
            lab.mostrarMenu();
            System.out.println("Qual opção você deseja acessar?");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    // caso 4 já tenha sido ativado, apenas op 5 e 6 disponível
                    if (carregarEstatisticas == true) {
                        System.out.println("Apenas opções 5 e 6 disponíveis!");
                        break;
                    }
                    lab.lerArquivo();
                    carregarExames = true;
                    System.out.println("Dados dos exames carregados com sucesso!");
                    break;
                case 2:
                    //caso op 1 nao tenha sido ativada
                    if (!carregarExames) {
                        System.out.println("Carregue exames primeiro!");
                        break;
                    }
                    // caso 4 já tenha sido ativado, apenas op 5 e 6 disponível
                    if (carregarEstatisticas == true) {
                        System.out.println("Apenas opções 5 e 6 disponíveis!");
                        break;
                    }
                   
                    ArrayList<Exame> examesSolicitados = new ArrayList<>();
                    sc.nextLine(); 
                    System.out.print("CPF: ");
                    cpf = sc.nextLine();

                    System.out.print("NOME: ");
                    nome = sc.nextLine();

                    boolean maisExames = true;

                    while (maisExames) {
                        System.out.println("Abreviação Exames (XXX para sair):");
                        String abrev = sc.nextLine().toUpperCase();

                        if (abrev.equals("XXX")) {
                            break;
                        }

                        Exame e = lab.buscarExame(abrev);

                        if (e != null) {
                            examesSolicitados.add(e);
                        } else {
                            System.out.println("Exame não encontrado!");
                        }
                    }
                    lab.adicionarPaciente(cpf, nome, examesSolicitados);
                    
                    break;
                case 3:
                    //caso op 1 nao tenha sido ativada
                    if (!carregarExames) {
                        System.out.println("Carregue exames primeiro!");
                        break;
                    }
                    // caso 4 já tenha sido ativado, apenas op 5 e 6 disponível
                    if (carregarEstatisticas == true) {
                        System.out.println("Apenas opções 5 e 6 disponíveis!");
                        break;
                    }
                    
                    sc.nextLine(); 
                    System.out.println("Informe CPF de consulta:");
                    cpf = sc.nextLine();

                    PedidoExame e = lab.procurarPaciente(cpf);
                    if (e != null) {
                            lab.consultarPaciente(e);
                        } else {
                            System.out.println("Paciente não encontrado!");
                        }
                    break;
                case 4:
                    if (!carregarExames) {
                        System.out.println("Carregue exames primeiro!");
                        break;
                    }

                    lab.finalizarAtendimentos(); 

                    carregarEstatisticas = true;
                    System.out.println("Atendimentos finalizados e arquivo gerado!");
                    break;
                case 5:
                    if (!carregarExames) {
                        System.out.println("Carregue exames primeiro!");
                        break;
                    }

                    lab.verEstatisticas();
                    break;
                case 6:
                    System.out.println("Aplicação encerrada!\nIntegrantes: Laura Yaguiu e Stephanie Dias");
                    break;

            } 
        } while (opcao!= 6);
        //sc.close();
    }
}
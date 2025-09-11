package gerenciadorLoja;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Memoria {
    }
    public static void salvaUsuarios(String nomearquivo, List<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Cliente c : clientes){
                bw.write(c.getId() + "," + c.getNome() + "," + c.getEmail() + "," + c.getNumero());
                bw.newLine();
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public static List<Cliente> carregaUsuarios(String nomearquivo){
        List<Cliente> clientes = new ArrayList<>()
        try (BufferedReader br = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = br.readline) != null){
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                String numero = dados[3];
                clientes.add(new Cliente(id, nome, email, numero));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler csv, iniciando sistema com lista vazia");
        }
    
    
}

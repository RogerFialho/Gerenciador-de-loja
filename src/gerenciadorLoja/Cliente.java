package gerenciadorLoja;

import java.util.Scanner;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String numero;

    public Cliente (int id , String nome, String email, String numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;

        if (this.id <= 0){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a id: ");
            int idtemp;
            do {
                idtemp = scanner.nextInt();
            } while (idtemp <= 0); 
            setId(idtemp);
            scanner.close();
        }
        if (this.nome == null){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome: ");
            String nometemp;
            do {
                nometemp = scanner.nextLine();
            } while (nometemp == null); 
            setNome(nometemp);
            scanner.close();
        }
        if (this.email == null){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o email: ");
            String emailtemp;
            do {
                emailtemp = scanner.nextLine();
            } while (emailtemp == null); 
            setEmail(emailtemp);
            scanner.close();
        }
        if (this.numero == null){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o numero: ");
            String numerotemp;
            do {
                numerotemp = scanner.nextLine();
            } while (numerotemp == null); 
            setNumero(numerotemp);
            scanner.close();
        }
    }

    public String getNome() {
        return nome;
    }  
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getNumero() {
        return numero;
    } 
     
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
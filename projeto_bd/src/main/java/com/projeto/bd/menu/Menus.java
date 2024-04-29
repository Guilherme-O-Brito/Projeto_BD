package com.projeto.bd.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.projeto.bd.DAO.AssinaturaDAO;
import com.projeto.bd.DAO.ChefeDeDepartamentoDAO;
import com.projeto.bd.models.Assinatura;
import com.projeto.bd.models.ChefeDeDepartamento;

public class Menus {
    
    public static void assinatura(){

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        AssinaturaDAO commands = new AssinaturaDAO();
        Assinatura assinaturaAux;
        ArrayList<Assinatura> assinaturas;
        int id;
        String tema;
        int livro_id;

        System.out.println("Opcoes de Assinatura: ");
        System.out.println("1 - Listar todas as assinaturas");
        System.out.println("2 - Inserir nova assinatura");
        System.out.println("3 - Editar uma assinatura");
        System.out.println("4 - Deletar uma assinatura");

        option = input.nextInt();

        switch(option){

            case 1:
                assinaturas = commands.selectAssinatura();
                break;
            
            case 2:

                System.out.print("Insira o id da assinatura: ");
                id = input.nextInt();
                System.out.print("Insira o tema da assinatura: ");
                input.nextLine();
                tema = input.nextLine();
                System.out.print("Insira o livro_id da assinatura: ");
                livro_id = input.nextInt();

                assinaturaAux = new Assinatura(id, tema, livro_id);

                commands.insertAssinatura(assinaturaAux);

                break;
            case 3:
                System.out.print("Insira o id da assinatura a ser editada: ");
                id = input.nextInt();
                System.out.print("Insira o novo Tema: ");
                input.nextLine();
                tema = input.nextLine();
                commands.updateAssinaturaNome(id, tema);
                break;
            
            case 4:
                System.out.print("Insira o id da assinatura a ser removida: ");
                id = input.nextInt();
                commands.deleteAssinatura(id);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }
        
    }

    public static void chefe_de_Departamento(){
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        ChefeDeDepartamentoDAO commands = new ChefeDeDepartamentoDAO();
        ChefeDeDepartamento chefeDeDepartamentoAux;
        ArrayList<ChefeDeDepartamento> chefesDeDepartamento;
        String nome;
        String novoNome;
        int matricula;
        String email;
        String telefone;

        System.out.println("Opcoes de Chefe de Departamento: ");
        System.out.println("1 - Listar todas os Chefes de Departamento");
        System.out.println("2 - Inserir novo Chefe de Departamento");
        System.out.println("3 - Editar um Chefe de Departamento");
        System.out.println("4 - Deletar um Chefe de Departamento");

        option = input.nextInt();

        switch(option){

            case 1:
                chefesDeDepartamento = commands.selectChefeDeDepartamento();
                break;
            
            case 2:

                System.out.print("Insira o nome do chefe de departamento: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira a matricula do chefe de departamento: ");
                matricula = input.nextInt();
                System.out.print("Insira o email do chefe de Departamento: ");
                input.nextLine();
                email = input.nextLine();
                System.out.print("Insira o telefone do chefe de Departamento: ");
                telefone = input.nextLine();

                chefeDeDepartamentoAux = new ChefeDeDepartamento(nome,matricula,email,telefone);

                commands.insertChefeDeDepartamento(chefeDeDepartamentoAux);

                break;
            case 3:
                System.out.print("Insira o nome do chefe de departamento a ser editado: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o novo nome do chefe de departamento: ");
                novoNome = input.nextLine();
                System.out.print("Insira a matricula do chefe de departamento: ");
                matricula = input.nextInt();
                System.out.print("Insira o email do chefe de Departamento: ");
                input.nextLine();
                email = input.nextLine();
                System.out.print("Insira o telefone do chefe de Departamento: ");
                telefone = input.nextLine();

                commands.updateChefeDeDepartamentoNome(nome, matricula, email, telefone, novoNome);

                break;
            
            case 4:
                System.out.print("Insira o nome do chefe de departamento a ser removido: ");
                input.nextLine();
                nome = input.nextLine();
                commands.deleteChefeDeDepartamento(nome);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

    public static void cliente(){
        
    }

    public static void departamento(){
        
    }

    public static void editora(){
        
    }

    public static void funcionario(){
        
    }

    public static void livro(){
        
    }

}

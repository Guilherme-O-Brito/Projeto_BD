package com.projeto.bd.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.projeto.bd.DAO.AssinaturaDAO;
import com.projeto.bd.DAO.Assinatura_has_editoraDAO;
import com.projeto.bd.DAO.ChefeDeDepartamentoDAO;
import com.projeto.bd.DAO.ClienteDAO;
import com.projeto.bd.DAO.Cliente_has_assinaturaDAO;
import com.projeto.bd.DAO.DepartamentoDAO;
import com.projeto.bd.DAO.EditoraDAO;
import com.projeto.bd.DAO.FuncionarioDAO;
import com.projeto.bd.DAO.LivroDAO;
import com.projeto.bd.models.Assinatura;
import com.projeto.bd.models.ChefeDeDepartamento;
import com.projeto.bd.models.Cliente;
import com.projeto.bd.models.Departamento;
import com.projeto.bd.models.Editora;
import com.projeto.bd.models.Funcionario;
import com.projeto.bd.models.Livro;

public class Menus {
    
    public static void assinatura(){

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        Assinatura_has_editoraDAO relation = new Assinatura_has_editoraDAO();
        Cliente_has_assinaturaDAO relation2 = new Cliente_has_assinaturaDAO();
        AssinaturaDAO commands = new AssinaturaDAO();
        Assinatura assinaturaAux;
        ArrayList<Assinatura> assinaturas;
        int id;
        String tema;
        String editora_nome;

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

                assinaturaAux = new Assinatura(id, tema);

                commands.insertAssinatura(assinaturaAux);

                do{
                    System.out.print("Insira o nome de uma editora que faz parte dessa assinatura: ");
                    editora_nome = input.nextLine();
                    relation.insertAssinatura_has_editora(id, editora_nome);
                    System.out.println("Deseja inserir outra editora nessa assinatura? (1 - sim / qualquer coisa - nao)");
                    option = input.nextInt();
                    input.nextLine();
                }while(option == 1);

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
                relation.deleteAssinatura_has_editoraByAssinatura(id);
                relation2.deleteCliente_has_assinaturaByAssinatura(id);
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
        String departamento_nome;

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
                System.out.print("Insira o departamento gerenciado por ele: ");
                departamento_nome = input.nextLine();

                chefeDeDepartamentoAux = new ChefeDeDepartamento(nome,matricula,email,telefone,departamento_nome);

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
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        ClienteDAO commands = new ClienteDAO();
        Cliente_has_assinaturaDAO relation = new Cliente_has_assinaturaDAO();
        Cliente clienteAux;
        ArrayList<Cliente> clientes;
        String nome;
        String email;
        String telefone;
        String endereco;
        String data_de_nascimento;
        int assinatura_id;

        System.out.println("Opcoes de Clientes: ");
        System.out.println("1 - Listar todas os CLientes");
        System.out.println("2 - Inserir novo Cliente");
        System.out.println("3 - Editar um Cliente");
        System.out.println("4 - Deletar um Cliente");

        option = input.nextInt();

        switch(option){

            case 1:
                clientes = commands.selectCliente();
                break;
            
            case 2:

                System.out.print("Insira o nome do Cliente: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o email do cliente: ");
                email = input.nextLine();
                System.out.print("Insira o telefone do Cliente: ");
                telefone = input.nextLine();
                System.out.print("Insira o endereco do cliente: ");
                endereco = input.nextLine();
                System.out.print("Insira a data de nascimento do cliente: ");
                data_de_nascimento = input.nextLine();

                clienteAux = new Cliente(nome, email, telefone, endereco, data_de_nascimento);

                commands.insertCliente(clienteAux);

                do{
                    System.out.print("Insira o id de uma assinatura que que o cliente tem: ");
                    assinatura_id = input.nextInt();
                    relation.insertCliente_has_assinatura(assinatura_id, nome);
                    System.out.println("Deseja inserir outra editora nessa assinatura? (1 - sim / qualquer coisa - nao)");
                    option = input.nextInt();
                }while(option == 1);

                break;
            case 3:
                System.out.print("Insira o nome do cliente a ser editado: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o email do cliente: ");
                email = input.nextLine();
                System.out.print("Insira o telefone do Cliente: ");
                telefone = input.nextLine();
                System.out.print("Insira o endereco do cliente: ");
                endereco = input.nextLine();
                System.out.print("Insira a data de nascimento do cliente: ");
                data_de_nascimento = input.nextLine();

                commands.updateClienteNome(nome, email, telefone, endereco, data_de_nascimento);

                break;
            
            case 4:
                System.out.print("Insira o nome do cliente a ser removido: ");
                input.nextLine();
                nome = input.nextLine();
                relation.deleteCliente_has_assinaturaByCliente(nome);
                commands.deleteCliente(nome);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

    public static void departamento(){
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        DepartamentoDAO commands = new DepartamentoDAO();
        Departamento departamentoAux;
        ArrayList<Departamento> departamentos;
        String nome;
        String area;
        String email;
        String telefone;

        System.out.println("Opcoes de Departamento: ");
        System.out.println("1 - Listar todas os Departamentos");
        System.out.println("2 - Inserir novo Departamento");
        System.out.println("3 - Editar um Departamento");
        System.out.println("4 - Deletar um Departamento");

        option = input.nextInt();

        switch(option){

            case 1:
                departamentos = commands.selectDepartamento();
                break;
            
            case 2:

                System.out.print("Insira o nome do Departamento: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira a area do Departamento: ");
                area = input.nextLine();
                System.out.print("Insira o email do Departamento: ");
                email = input.nextLine();
                System.out.print("Insira o telefone do Departamento: ");
                telefone = input.nextLine();

                departamentoAux = new Departamento(nome, area, email, telefone);

                commands.insertDepartamento(departamentoAux);

                break;
            case 3:
                System.out.print("Insira o nome do departamento a ser editado: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira a area do Departamento: ");
                area = input.nextLine();
                System.out.print("Insira o email do Departamento: ");
                email = input.nextLine();
                System.out.print("Insira o telefone do Departamento: ");
                telefone = input.nextLine();

                commands.updateDepartamentoNome(nome, area, email, telefone);

                break;
            
            case 4:
                System.out.print("Insira o nome do Departamento a ser removido: ");
                input.nextLine();
                nome = input.nextLine();
                commands.deleteDepartamento(nome);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

    public static void editora(){
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        EditoraDAO commands = new EditoraDAO();
        Assinatura_has_editoraDAO relation = new Assinatura_has_editoraDAO();
        Editora editoraAux;
        ArrayList<Editora> editoras;
        String nome;
        String email;
        String telefone;

        System.out.println("Opcoes de Editora: ");
        System.out.println("1 - Listar todas as Editoras");
        System.out.println("2 - Inserir nova Editora");
        System.out.println("3 - Editar uma Editora");
        System.out.println("4 - Deletar uma Editora");

        option = input.nextInt();

        switch(option){

            case 1:
                editoras = commands.selectEditora();
                break;
            
            case 2:

                System.out.print("Insira o nome da Editora: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o email da Editora: ");
                email = input.nextLine();
                System.out.print("Insira o telefone da Editora: ");
                telefone = input.nextLine();

                editoraAux = new Editora(nome, email, telefone);

                commands.insertEditora(editoraAux);

                break;
            case 3:
                System.out.print("Insira o nome da editora a ser editada: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o email da Editora: ");
                email = input.nextLine();
                System.out.print("Insira o telefone da Editora: ");
                telefone = input.nextLine();

                commands.updateEditoraNome(nome, email, telefone);

                break;
            
            case 4:
                System.out.print("Insira o nome da Editora a ser removida: ");
                input.nextLine();
                nome = input.nextLine();
                relation.deleteAssinatura_has_editoraByEditora(nome);
                commands.deleteEditora(nome);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

    public static void funcionario(){
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        FuncionarioDAO commands = new FuncionarioDAO();
        Funcionario funcionarioAux;
        ArrayList<Funcionario> funcionarios;
        String nome;
        String data_de_nascimento;
        String cargo;
        int matricula;
        String email;
        String telefone;
        String departamento_nome;

        System.out.println("Opcoes de Funcionario: ");
        System.out.println("1 - Listar todos os Funcionarios");
        System.out.println("2 - Inserir novo Funcionario");
        System.out.println("3 - Editar um Funcionario");
        System.out.println("4 - Deletar um Funcionario");

        option = input.nextInt();

        switch(option){

            case 1:
                funcionarios = commands.selectFuncionario();
                break;
            
            case 2:

                System.out.print("Insira o nome do Funcionario: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira a data de nascimento do Funcionario: ");
                data_de_nascimento = input.nextLine();
                System.out.print("Insira o cargo do Funcionario: ");
                cargo = input.nextLine();
                System.out.print("Insira a matricula do Funcionario: ");
                matricula = input.nextInt();
                System.out.print("Insira o email do Funcionario: ");
                input.nextLine();
                email = input.nextLine();
                System.out.print("Insira o telefone do Funcionario: ");
                telefone = input.nextLine();
                System.out.print("Insira o departamento do Funcionario: ");
                departamento_nome = input.nextLine();

                funcionarioAux = new Funcionario(nome, data_de_nascimento, cargo, matricula, email, telefone, departamento_nome);

                commands.insertFuncionario(funcionarioAux);

                break;
            case 3:
                System.out.print("Insira o nome do funcionario a ser editado: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira a data de nascimento do Funcionario: ");
                data_de_nascimento = input.nextLine();
                System.out.print("Insira o cargo do Funcionario: ");
                cargo = input.nextLine();
                System.out.print("Insira a matricula do Funcionario: ");
                matricula = input.nextInt();
                System.out.print("Insira o email do Funcionario: ");
                input.nextLine();
                email = input.nextLine();
                System.out.print("Insira o telefone do Funcionario: ");
                telefone = input.nextLine();
                System.out.print("Insira o departamento do Funcionario: ");
                departamento_nome = input.nextLine();

                commands.updateFuncionarioNome(nome, email, cargo, matricula, telefone, data_de_nascimento, departamento_nome);

                break;
            
            case 4:
                System.out.print("Insira o nome do funcionario a ser removido: ");
                input.nextLine();
                nome = input.nextLine();
                commands.deleteFuncionario(nome);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

    public static void livro(){
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int option;
        LivroDAO commands = new LivroDAO();
        Livro livroAux;
        ArrayList<Livro> livros;
        int id;
        String nome;
        String autor;
        String genero;
        String assunto;
        String edicao;
        int estoque;
        String editora_nome;

        System.out.println("Opcoes de Livro: ");
        System.out.println("1 - Listar todos os Livros");
        System.out.println("2 - Inserir novo Livro");
        System.out.println("3 - Editar um Livro");
        System.out.println("4 - Deletar um Livro");

        option = input.nextInt();

        switch(option){

            case 1:
                livros = commands.selectLivro();
                break;
            
            case 2:

                System.out.print("Insira o id do livro: ");
                id = input.nextInt();
                System.out.print("Insira o nome do livro: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o autor do livro: ");
                autor = input.nextLine();
                System.out.print("Insira o genero do livro: ");
                genero = input.nextLine();
                System.out.print("Insira o assunto do livro: ");
                assunto = input.nextLine();
                System.out.print("Insira a edicao do livro: ");
                edicao = input.nextLine();
                System.out.print("Insira o estoque do livro: ");
                estoque = input.nextInt();
                System.out.print("Insira a editora do livro: ");
                input.nextLine();
                editora_nome = input.nextLine();

                livroAux = new Livro(id, nome, autor, genero, assunto, edicao, estoque, editora_nome);

                commands.insertLivro(livroAux);

                break;
            case 3:
                System.out.print("Insira o id do livro a ser editado: ");
                id = input.nextInt();
                System.out.print("Insira o novo nome do funcionario: ");
                input.nextLine();
                nome = input.nextLine();
                System.out.print("Insira o autor do livro: ");
                autor = input.nextLine();
                System.out.print("Insira o genero do livro: ");
                genero = input.nextLine();
                System.out.print("Insira o assunto do livro: ");
                assunto = input.nextLine();
                System.out.print("Insira a edicao do livro: ");
                edicao = input.nextLine();
                System.out.print("Insira o estoque do livro: ");
                estoque = input.nextInt();
                System.out.print("Insira a editora do livro: ");
                input.nextLine();
                editora_nome = input.nextLine();

                commands.updateLivroNome(id, nome, autor, genero, assunto, edicao, estoque, editora_nome);

                break;
            
            case 4:
                System.out.print("Insira o id do livro a ser removido: ");
                id = input.nextInt();
                commands.deleteLivro(id);
                break;

            default:
                System.out.println("Opcao Invalida!");

        }

    }

}

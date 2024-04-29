package com.projeto.bd;

import java.util.Scanner;

import com.projeto.bd.menu.Menus;

public class Main {
    public static void main(String[] args) {
        
        int option = 0;
        Scanner input = new Scanner(System.in);

        do{

            System.out.println("Selecione qual dos menus deseja acessar: ");
            System.out.println("1 - Menu de assinaturas");
            System.out.println("2 - Menu de Chefe de departamento");
            System.out.println("3 - Menu de Clientes");
            System.out.println("4 - Menu de Departamentos");
            System.out.println("5 - Menu de Editoras");
            System.out.println("6 - Menu de Funcionarios");
            System.out.println("7 - Menu de Livros");
            System.out.println("0 - Sair");

            option = input.nextInt();

            switch(option){

                case 1: 
                    Menus.assinatura();
                    break;
                case 2:
                    Menus.chefe_de_Departamento();
                    break;
                case 3:
                    Menus.cliente();
                    break;
                case 4:
                    Menus.departamento();
                    break;
                case 5:
                    Menus.editora();
                    break;
                case 6:
                    Menus.funcionario();
                    break;
                case 7:
                    Menus.livro();
                    break;
                case 0:
                    System.out.println("Fechando Sistema!");
                    break;
                default:
                    System.out.println("Opcao invalida por favor insira um valor valido!");
            }

        }while(option != 0);

        input.close();

    }
}
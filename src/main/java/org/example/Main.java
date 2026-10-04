package org.example;

import org.example.domain.User;
import org.example.repository.UserRepositoryImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl repo = new UserRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- MENU USER ---");
            System.out.println("1. Crear user");
            System.out.println("2. Buscar por id");
            System.out.println("3. Actualizar user");
            System.out.println("4. Eliminar user");
            System.out.println("5. Contar users (ADICIONAL)");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch(op) {
                case 1:
                    System.out.print("id: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("nombre: "); String n = sc.nextLine();
                    System.out.print("email: "); String e = sc.nextLine();
                    repo.save(new User(id, n, e));
                    System.out.println("Guardado!");
                    break;
                case 2:
                    System.out.print("id a buscar: "); int idB = sc.nextInt();
                    User u = repo.selectUserById(idB);
                    System.out.println(u != null ? u : "No existe");
                    break;
                case 3:
                    System.out.print("id a actualizar: "); int idU = sc.nextInt(); sc.nextLine();
                    System.out.print("nuevo nombre: "); String nn = sc.nextLine();
                    System.out.print("nuevo email: "); String ne = sc.nextLine();
                    repo.updateUser(new User(idU, nn, ne));
                    System.out.println("Actualizado!");
                    break;
                case 4:
                    System.out.print("id a eliminar: "); int idD = sc.nextInt();
                    repo.deleteUser(idD);
                    System.out.println("Eliminado si existia");
                    break;
                case 5:
                    System.out.println("Total usuarios en el array: " + repo.countUsers());
                    break;
            }
        } while(op != 0);
    }
}

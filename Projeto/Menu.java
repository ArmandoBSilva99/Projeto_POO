import java.util.Scanner;
import java.util.List;

public class Menu
{
    public void iMenu() {
        Login app = new Login();
        
        Scanner input = new Scanner(System.in);
        int menu = 0;
        while(true) {
            System.out.println("---------MENU------------");
            System.out.println("1 - Registar Utilizador ");
            System.out.println("2 - Ver Utilizadores Registados ");
            System.out.println("3 - Login");
            System.out.println("4 - Sair");
            
            menu = input.nextInt();
            input.nextLine();
            
            if(menu == 1){
                System.out.println("Codigo Utilizador: ");
                String cod = input.nextLine();
                
                System.out.println("Password: ");
                String pass = input.nextLine();
                
                System.out.println("Nome Utilizador: ");
                String nome = input.nextLine();
                
                System.out.println("Latitude: ");
                double lat = input.nextDouble();
                
                System.out.println("Longitude: ");
                double longi = input.nextDouble();
                
                GPS local = new GPS(lat, longi);
                
                try {
                    app.registarUtilizador(cod, nome, local, pass);
                }    
                catch(Exception e) {
                    System.out.println(e);
                }
            }
            if (menu == 2){
                System.out.println("Utilizadores: " + app.getAllUtilizadores().toString());
            }
            if (menu == 3){
                System.out.println("Codigo: ");
                String cod = input.nextLine();
                
                System.out.println("Pass: ");
                String pass = input.nextLine();
                
                if (app.validaUtilizador(cod, pass)) System.out.println("Login com Sucesso!");
                else System.out.println("Login Falhou!");
            }    
            if (menu == 4)
                break;
            
                
        }
    }    
}

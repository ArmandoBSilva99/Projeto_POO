
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[]){
        Login app = new Login();
        Utilizador u = new Utilizador("u48","Francisco", new GPS(-97.28862, 59.067047),"1010");
        GPS gp = new GPS(-97.84033,59.35376);
        
        
        Menu menu = new Menu();
        menu.iMenu();
    }    
}

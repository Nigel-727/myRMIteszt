

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Nigel-727
 */
public class Kliens {
  private Interfesz szervercsonk;
  //
  public Kliens() {
    System.out.println("Én meg a kliens vagyok és szerver nélkül élni nem tudok");
    //
    regisztráció();
    //
    try {
      System.out.print("Először megmondom, láz-e a 38.5: ");
      System.out.println(
          szervercsonk.isVanELázad(38.5)
      );
      System.out.print("Majd elosztom 100-at 15-tel: ");
      System.out.println(
          szervercsonk.hányados(100.0, 15.0)
      );
    } catch (RemoteException ex) {
      ex.printStackTrace();
    }
  }//konstruktor Kliens()
  private void regisztráció() {
    try {
      Registry r=LocateRegistry.getRegistry("localhost");
      szervercsonk=(Interfesz)r.lookup("latodugye"); 
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  } //regisztráció()
  public static void main(String[] args) {
    new Kliens();
  }
}//class Kliens

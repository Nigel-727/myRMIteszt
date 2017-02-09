

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Nigel-727
 */
public class Szerver implements Interfesz {
  
  public Szerver() {
    ; //nemtörténik semmi
    System.out.println("A Szerver példány sikeresen létrejött.");
  }
  
  @Override
  public boolean isVanELázad(double testHőmérséklet) throws RemoteException {
    return (38.0<=testHőmérséklet);
  }

  @Override
  public double hányados(double osztandó, double osztó) throws RemoteException {
    return osztandó/osztó;
  }
  
  public static void main(String[] args) {
    try {
      Szerver szerver = new Szerver();
      Interfesz szervercsonk = (Interfesz)UnicastRemoteObject.exportObject(szerver, 0); // #ezmiez
      Registry r=LocateRegistry.getRegistry();
      r.bind("latodugye", szervercsonk);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
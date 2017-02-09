/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nigel-727
 */
public interface Interfesz extends Remote {
  public boolean isVanELázad(double testHőmérséklet) throws RemoteException;
  public double hányados(double osztandó, double osztó) throws RemoteException;
}

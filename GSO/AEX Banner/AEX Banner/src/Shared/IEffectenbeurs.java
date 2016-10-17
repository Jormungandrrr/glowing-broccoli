/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import Server.Fonds;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Marc
 */
public interface IEffectenbeurs extends Remote {
    public List<Fonds> getKoersen()throws RemoteException;
    public int getNumberOfFonds() throws RemoteException;
    public Fonds getFond(int nr) throws RemoteException;
    public Fonds addFond(String name, int koers) throws RemoteException;
    public void stop() throws RemoteException;
}

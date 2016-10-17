/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Shared.IEffectenbeurs;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Example of RMI using Registry
 *
 * @author Jorrit
 */
public class RMIClient {

    // Set binding name for student administration
    private static final String bindingName = "MockEffectenbeurs";

    // References to registry and student administration
    private Registry registry = null;
    private IEffectenbeurs meb = null;

    // Constructor
    public RMIClient(String ipAddress, int portNumber) {

        // Print IP address and port number for registry
        System.out.println("Client: IP Address: " + ipAddress);
        System.out.println("Client: Port number " + portNumber);

        // Locate registry at IP address and port number
        try {
            registry = LocateRegistry.getRegistry(ipAddress, portNumber);
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            registry = null;
        }

        // Print result locating registry
        if (registry != null) {
            System.out.println("Client: Registry located");
        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }

        // Print contents of registry
        if (registry != null) {
            printContentsRegistry();
        }

        // Bind student administration using registry
        if (registry != null) {
            try {
                this.meb = (IEffectenbeurs) registry.lookup(bindingName);
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind MockEffect");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                meb = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind MockEffect");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                meb = null;
            }
        }

        // Print result binding student administration
        if (meb != null) {
            System.out.println("Client: MockEffect bound");
        } else {
            System.out.println("Client: MockEffect is null pointer");
        }

        // Test RMI connection
        if (meb != null) {
            System.out.println("Test");
            AEXBanner.eb = meb;
            AEXBanner.main();
        }
    }

    // Print contents of registry
    private void printContentsRegistry() {
        try {
            String[] listOfNames = registry.list();
            System.out.println("Client: list of names bound in registry:");
            if (listOfNames.length != 0) {
                for (String s : registry.list()) {
                    System.out.println(s);
                }
            } else {
                System.out.println("Client: list of names bound in registry is empty");
            }
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot show list of names bound in registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        // Welcome message
        System.out.println("CLIENT USING REGISTRY");

        // Get ip address of server
        Scanner input = new Scanner(System.in);
        System.out.print("Client: Enter IP address of server: ");
        String ipAddress = input.nextLine();

        // Get port number
        System.out.print("Client: Enter port number: ");
        int portNumber = input.nextInt();

        // Create client
        RMIClient client = new RMIClient(ipAddress, portNumber);
    }
}

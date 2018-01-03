package agendae.rmi.i;

public interface IAgendaE extends java.rmi.Remote {
    String getEmailAddr(String nume) throws java.rmi.RemoteException;
    String getName(String email) throws java.rmi.RemoteException;
}

    

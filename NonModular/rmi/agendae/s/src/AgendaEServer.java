package agendae.rmi.s;
import agendae.rmi.i.IAgendaE;
import java.rmi.server.UnicastRemoteObject;
// Varianta cu apel rmiregistry direct
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// Varianta JNDI
import javax.naming.Context;
import javax.naming.InitialContext;

public class AgendaEServer{ 
  public static void main(String args[]) {
    String host="localhost";
    int port=1099;
    if(args.length>0)
       port=Integer.parseInt(args[0]);
    try {
      AgendaEImpl obj=new AgendaEImpl();
      IAgendaE stub=(IAgendaE)UnicastRemoteObject.exportObject(obj,0);
      // Varianta cu apel rmiregistry direct
      /*
      Registry registry=LocateRegistry.getRegistry(host,port);
      registry.bind("CmmdcServer",stub);
      */
      // Varianta JNDI
      String sPort=Integer.valueOf(port).toString();
      System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
      System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
      Context ctx=new InitialContext();
      ctx.bind("AgendaEServer",stub);
      System.out.println("AgendaEServer ready");
      System.out.println("Press CTRL+C to finish !");
      //System.in.read();
    } 
    catch (Exception e) {
      System.out.println("CmmdcImpl err: " + e.getMessage());
    }
  }
} 

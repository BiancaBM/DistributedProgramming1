package agendae.rmi.c;
import agendae.rmi.i.IAgendaE;
import java.util.Scanner;
// Varianta cu apel rmiregistry direct
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// Varianta JNDI
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.InputMismatchException;

public class AgendaEClient {
  public static void main(String args[]) {
    String host="localhost";
    int port=1099;
    if(args.length>0)
      host=args[0];
    if (args.length>1)
      port=Integer.parseInt(args[1]);
    Scanner scanner=new Scanner(System.in);
      
    try {
      // Varianta cu apel rmiregistry direct
      /*
      Registry registry=LocateRegistry.getRegistry(host,port);
      IAgendaE obj=(IAgendaE)registry.lookup("AgendaEServer");
      */
      // Varianta JNDI
      String sPort=Integer.valueOf(port).toString();
      System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
      System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
      Context ctx=new InitialContext();
      IAgendaE obj=(IAgendaE)ctx.lookup("AgendaEServer");
      
      int prel;
      String ch="Y",nume="",email="",r="";
      while(ch.startsWith("Y")){
        do{
          System.out.println("Continue ? (Y/N)");
          ch=scanner.next().toUpperCase();
        }
        while((!ch.startsWith("Y"))&&(!ch.startsWith("N")));
        if(ch.startsWith("Y")){
          System.out.println("Natura interogarii ?");
          System.out.println("(Dupa nume:1,Dupa email:2)");
          do{
            prel=0;
            try{
              prel=scanner.nextInt();
            }
            catch(InputMismatchException e){}
          }
          while((prel<1)&&(prel>2));
          switch(prel){
            case 1 :
              System.out.println("Numele");              
              nume=scanner.next();
              r=obj.getEmailAddr(nume);
              break;
            case 2 :
              System.out.println("Email");
              email=scanner.next();
              r=obj.getName(email);
              break;
            default: System.out.println("Comanda eronata");
          }
          if(r!=null){
            System.out.println("Results :");
            System.out.println(r);
          }
          else{
            System.out.println("No item found !");
          }           
        }
      }
    }
    catch (Exception e) {
      //System.out.println("AgendaEClient exception: "+e.getMessage());
      e.printStackTrace();
    }
  }
}

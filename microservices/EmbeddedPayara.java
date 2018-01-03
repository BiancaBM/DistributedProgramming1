import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class EmbeddedPayara {

    public static void main(String[] args) throws BootstrapException{
      String fileName="";
      if(args.length==0){
        System.out.println("Usage: java EmbeddedPayara fileName\n");
        //System.out.println("Usage: java EmbeddedPayara warFileName\n");
        //System.out.println("The .war extension will be omitted.");
      }
      else{
        fileName=args[0];
        System.out.println(fileName);
        PayaraMicro.getInstance()                           
          .addDeployment(fileName)                        
          .bootStrap(); 
      }          
    }

}
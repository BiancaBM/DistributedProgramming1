import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.JMSConsumer;
import java.util.Scanner;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties; 
import java.io.IOException;
import javax.annotation.Resource; 

public class  MsgClientSender{
  final static String CONNECTION_JNDI_NAME = "myTopicConnectionFactory";
  final static String TOPIC_JNDI_NAME_1 = "cmmdc";
  final static String TOPIC_JNDI_NAME_2 = "results";
  private String msg,clientID,clientName;
  private InitialContext ctx;
  
  @Resource(lookup=CONNECTION_JNDI_NAME)
  private static TopicConnectionFactory cf;
  @Resource(lookup=TOPIC_JNDI_NAME_1)
  private static Topic reqTopic;  
  @Resource(lookup=TOPIC_JNDI_NAME_2)
  private static Topic resTopic;  
  
  MsgClientSender(String clientID,String clientName){
    this.clientID=clientID;
    this.clientName=clientName;    
  }
  
  private void service(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti m :");
    long m=scanner.nextLong();
    String sm=new Long(m).toString();
    System.out.println("Introduceti n :");
    long n=scanner.nextLong();
    String sn=new Long(n).toString();
    System.out.println("Introduceti 'messageId'-ul raspunsului");
    String messageId=scanner.next();
    msg=sm+" "+sn+" "+messageId;
    try{
      
      JMSContext jmsctx=cf.createContext();
      jmsctx.setClientID(clientID);
      
      JMSProducer producer=jmsctx.createProducer(); 
      JMSConsumer consumer = jmsctx.createDurableConsumer(resTopic,clientName);      
      producer.send(reqTopic,msg);
      
      jmsctx.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args){
    if(args.length<2){
      System.out.println("Usage:");
      System.out.println("java MsgSOAPClientSender clientID clientName");
      System.exit(0);
    }
    MsgClientSender client=new MsgClientSender(args[0],args[1]);
    client.service();
  }
  
}

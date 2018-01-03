import javax.jms.TextMessage;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSConsumer;
import java.util.Scanner;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties; 
import java.io.IOException;
import javax.annotation.Resource; 

public class  MsgClientReceiver{
  final static String CONNECTION_JNDI_NAME = "myTopicConnectionFactory";
  final static String TOPIC_JNDI_NAME_2 = "results";
  private String messageId,clientID,clientName;
  private InitialContext ctx;
  
  @Resource(lookup=CONNECTION_JNDI_NAME)
  private static TopicConnectionFactory cf;
  @Resource(lookup=TOPIC_JNDI_NAME_2)
  private static Topic resTopic;  
  
  MsgClientReceiver(String clientID,String clientName){
    this.clientID=clientID;
    this.clientName=clientName;   
  }

  public void service(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti 'messageId'-ul raspunsului");
    messageId=scanner.next();
    try{
  
      JMSContext jmsctx=cf.createContext();
      jmsctx.setClientID(clientID);
      
      JMSConsumer consumer = jmsctx.createDurableConsumer(resTopic,clientName);
      Message msg=null;
      while((msg=consumer.receive())!=null){
        if(msg instanceof TextMessage){
          TextMessage m=(TextMessage)msg;
          System.out.println(m.getText());
          //String msgId=m.getJMSMessageID();
          if(m.propertyExists("key")){
            String msgId=m.getStringProperty("key");
            System.out.println(msgId);
          
            if(msgId.equals(messageId)){
              System.out.println("Cmmdc : "+m.getText());
              break;
            }
          }
        }
      }   
      jmsctx.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args){
    if(args.length<2){
      System.out.println("Usage:");
      System.out.println("java MsgSOAPClientReceiver clientID clientName");
      System.exit(0);
    }
    MsgClientReceiver client=new MsgClientReceiver(args[0],args[1]);
    client.service();
  }
  
  
}

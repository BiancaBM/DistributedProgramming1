import javax.jms.TextMessage;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSConsumer;
import javax.jms.JMSProducer;
import javax.jms.JMSException;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties; 
import java.io.IOException;
import javax.annotation.Resource; 

public class  MsgCmmdcServer{
  final static String CONNECTION_JNDI_NAME = "myTopicConnectionFactory";
  final static String TOPIC_JNDI_NAME_1 = "cmmdc";
  final static String TOPIC_JNDI_NAME_2 = "results";
  private InitialContext ctx;
  
  @Resource(lookup=CONNECTION_JNDI_NAME)
  private static TopicConnectionFactory cf;
  @Resource(lookup=TOPIC_JNDI_NAME_1)
  private static Topic reqTopic;  
  @Resource(lookup=TOPIC_JNDI_NAME_2)
  private static Topic resTopic;  
  
  public static void main(String[] args){
    MsgCmmdcServer server=new MsgCmmdcServer();
    server.service();
  }
  
  private void service(){
    try{
      
      JMSContext jmsctx=cf.createContext();
      //JMSConsumer consumer = jmsctx.createSharedConsumer(reqTopic,"Cmmdc");
      JMSConsumer consumer = jmsctx.createConsumer(reqTopic);
      JMSProducer producer = jmsctx.createProducer();
      Message msg=null;
      while(true){         
        while((msg=consumer.receive())!=null){
          System.out.println("Itt");
          if(msg instanceof TextMessage){
            TextMessage tm=(TextMessage)msg;
            String s=tm.getText();
            System.out.println(s);
            String[] ss=s.split(" ");
            //if(ss.length==3){
              System.out.println(ss.length);
              long m=Long.parseLong(ss[0]);
              long n=Long.parseLong(ss[1]);
              String messageId=ss[2];        
              long c=cmmdc(m,n);
              tm=jmsctx.createTextMessage();
              tm.setText((new Long(c)).toString());
              //tm.setJMSMessageID(messageId);
              tm.setStringProperty("key",messageId);
            //}
            producer.send(resTopic,tm);
            System.out.println("Itt2");
            System.out.println("Server sent "+c+" to "+resTopic+" / "+messageId);
          } 
        }
      }             
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  private long cmmdc(long m,long n){
    long c,r;
    do{
      c=n;
      r=m % n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }
 
}

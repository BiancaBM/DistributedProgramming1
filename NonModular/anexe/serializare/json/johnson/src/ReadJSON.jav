import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;
import java.io.FileInputStream;

public class ReadJSON{

  public static void main(String[] args){
    try{
      FileInputStream inputStream=new FileInputStream("data.txt");   
       
      final Mapper mapper = new MapperBuilder().build();
      
      final MyModel object=mapper.readObject(inputStream,MyModel.class);
     
      System.out.println("m="+object.getM());
      System.out.println("n="+object.getN());
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
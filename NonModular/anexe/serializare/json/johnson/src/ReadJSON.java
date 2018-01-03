import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;
import java.io.FileInputStream;
import java.util.List;
import java.util.Iterator;

public class ReadJSON{

  public static void main(String[] args){
    try{
      FileInputStream inputStream=new FileInputStream("data.txt");   
       
      final Mapper mapper = new MapperBuilder().build();
      
      final MyModel object=mapper.readObject(inputStream,MyModel.class);
      List<Disciplina> lst=object.getList();
      Iterator<Disciplina> iter=lst.iterator();
      while(iter.hasNext()){
        Disciplina d=iter.next();
        System.out.println(d.getNume());
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
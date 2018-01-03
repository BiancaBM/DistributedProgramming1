import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;

public class Generate{

  public static void main(String[] args){
    try{
      FileOutputStream outputStream=new FileOutputStream("data.txt");
      //final MyModel object=new MyModel();     
      //object.setM(50);
      //object.setN(30);
      List<Disciplina> list=new ArrayList<Disciplina>(3);
      Disciplina d=new Disciplina();
      d.setNume("Analiza numerica");
      list.add(d);
      d=new Disciplina();
      d.setNume("Programare distribuita");
      list.add(d);
      final MyModel object=new MyModel();
      object.setList(list);    
      final Mapper mapper = new MapperBuilder().build();
      mapper.writeObject(object, outputStream);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
<!doctype html>
<body>
  <%@ page import="java.nio.file.Path,java.nio.file.Paths,java.nio.file.Files,java.io.OutputStream" %>
  <%
    String fs=System.getProperty("file.separator");
    String pathApp=application.getRealPath("/")+fs;    
    Path path=Paths.get(pathApp+"walking_santa.gif");
    System.out.println(path);
    try{
      ServletOutputStream sos=response.getOutputStream();
      response.setContentType("image/gif");
      Files.copy(path,sos);
    }
    catch(Exception e){
      response.setContentType("text/plain"); 
      System.out.println(e.getMessage());
      out.println("Cererea d-voastra nu poate fi satisfacuta");
    }     
  %>
</body>
</html>
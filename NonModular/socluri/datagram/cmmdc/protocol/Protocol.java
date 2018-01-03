package cmmdc.datagram.p;
import java.io.Serializable;

public class Protocol implements Serializable{
  static final long serialVersionUID = 1L;
  public long x,y;
  public Protocol(long x,long y){
    this.x=x;
    this.y=y;
  }
}

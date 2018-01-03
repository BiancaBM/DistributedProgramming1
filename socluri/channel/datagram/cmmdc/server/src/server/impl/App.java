package cmmdc.datagramchannel.s.impl;
public class App{
  public interface CmmdcService {
    long cmmdc(long m, long n);
  }

  public static CmmdcService cmmdcService=(long m, long n) -> 
    { 
      long r,c;
      do{
         c=n;
         r=m%n;
         m=n;
         n=r;
         }
      while(r!=0);
      return c;
    };   
}

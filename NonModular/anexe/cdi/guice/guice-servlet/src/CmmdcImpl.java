package service.impl;
import service.ICmmdc;

public class CmmdcImpl implements ICmmdc{
  public long cmmdc(long m,long n){
    long r,c;
    do{
       c=n;
       r=m%n;
       m=n;
       n=r;
       }
    while(r!=0);
    return c;
  }
}

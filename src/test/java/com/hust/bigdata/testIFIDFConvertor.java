package com.hust.bigdata;

import com.hust.algorithm.canopy.Canopy;
import com.hust.convertor.TFIDFConvertor;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
public class testIFIDFConvertor {
    @Test
    public void func1(){
        TFIDFConvertor tfidfConvertor=new TFIDFConvertor();
        List<String[]> seglist= new ArrayList<String[]>();
        String[] str1={"习近平","出席","纪念","红军","长征","胜利","80周年","大会"};
        String[] str2={"李克强","会见","菲律宾","总统","杜特尔特"};
        String[] str3={"李克强","会见","杜特尔特","南海","问题","中","菲","关系","全部"};
        String[] str4={"长征","胜利","80周年","习近平","讲话","全文"};
        seglist.add(str1);
        seglist.add(str2);
        seglist.add(str3);
        seglist.add(str4);
        tfidfConvertor.setSegList(seglist);
        List<double[]> vectors=tfidfConvertor.getVector();
        Canopy canopy=new Canopy();
        canopy.setVectors(vectors);
        canopy.cluster();
        System.out.println("T="+canopy.getT());
        System.out.println("resultIndex="+canopy.getResultIndex());
        System.out.println("canopy="+canopy.getCanopy());
    }

    @Test
    public void func2(){
        ArrayList<String> s=new ArrayList<String>();

        String str=new String();
        for(int i=0;i<2;i++){
            String str1=new String();
            if(i==0){
                str="000000";
                str1=str;
            }
            else{
                str="111111";
                str1=str;
            }
            s.add(str1);
            System.out.println(s);
        }
    }

    @Test
    public void func3(){
         class Person{
             int i=-1;
             Person(){}
             Person(int i){this.i=i;};
             public String toString(){
                 return "i="+this.i;
             }
        }
        Person p=new Person(11);
        Person p2=new Person();
        p2=p;
        System.out.println(p2.toString());
        p.i=22;
        System.out.println(p2.toString());

    }

}

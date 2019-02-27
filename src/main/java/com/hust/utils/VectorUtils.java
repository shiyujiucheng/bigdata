package com.hust.utils;

import java.util.Arrays;

/**
 * 向量工具类
 * */
public class VectorUtils {

    public static double module(double[] vector){
        double sum=0;
        if(vector==null||vector.length==0){
            return 0;
        }

        for (int i=0;i<vector.length;i++){
            sum+=vector[i]*vector[i];
        }
        return Math.sqrt(sum);
    }
    public static double multiply(double[] vector1,double[] vector2){
        double sum=0;
        if(vector1==null||vector2==null||vector1.length==0||vector2.length==0){
            return 0;
        }
        //调整向量维数
        double[] v1,v2;
        if(vector1.length<vector2.length){
            v1=new double[vector2.length];
            v1= Arrays.copyOf(vector1,vector1.length);
            v2=vector2.clone();
        }
        else if(vector1.length>vector2.length){
            v2=new double[vector1.length];
            v2= Arrays.copyOf(vector2,vector2.length);
            v1=vector1.clone();
        }
        else{
            v1=vector1.clone();
            v2=vector2.clone();
        }

        for(int i=0;i<v1.length;i++)
            sum+=v1[i]*v2[i];
        return sum;
    }
}

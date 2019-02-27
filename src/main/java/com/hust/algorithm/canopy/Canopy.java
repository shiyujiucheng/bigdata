package com.hust.algorithm.canopy;

import com.hust.distance.CosDistance;

import java.util.ArrayList;
import java.util.List;

/**
 * Canopy聚类算法
 * @author 王雨夫
 * 单阈值
 * @decription: 这里的是单阈值完成聚类，且resultIndex是存取下标list的List。
 * */
public class Canopy {
    //原本的文本向量化操作后的向量集合
    private List<double[]> vectors;
    //聚类结果对应的下标集合
    private List<List<Integer>> resultIndex;
    //Canopy初始阈值T1
    private double T=0f;
    //聚类结果类别数量
    private int canopy=0;
    //用于相似度计算的类
    private CosDistance cosDistance;

    //Canopy算法
    public void cluster(){
    cosDistance=new CosDistance(vectors);
    if(T==0){T=cosDistance.getThreshold();}

    //初始化聚类的结果集合
    resultIndex=new ArrayList<List<Integer>>();
    //tmpIndex存储着一个Canopy所有的点（向量）在vectors的下标
    List<Integer> tmpIndex=null;
    for(int i=0;i<vectors.size();i++){
        if(i==0){
            tmpIndex=new ArrayList<Integer>();
            tmpIndex.add(i);
            resultIndex.add(tmpIndex);
            continue;
        }

        boolean isFind=false;

        for (int j=0;j<resultIndex.size();j++){
            //计算向量与已有的类的向量的平均值（的相似度）是否大于阈值，若大于，则加入该类
            if(cosDistance.getDistance(i,resultIndex.get(j))>T){
                tmpIndex=resultIndex.get(j);
                tmpIndex.add(i);
                resultIndex.remove(j);
                resultIndex.add(tmpIndex);
            //说明当前点已经加入相似的类，退出循环
                isFind=true;
                break;
            }

        }
        if(isFind==false){
            //若当前点与其他类都不符合，则新建一个类
            tmpIndex=new ArrayList<Integer>();
            tmpIndex.add(i);
            resultIndex.add(tmpIndex);
        }
    }
    canopy=resultIndex.size();
    }


    public List<double[]> getVectors() {
        return vectors;
    }

    public void setVectors(List<double[]> vectors) {
        this.vectors = vectors;
    }

    public List<List<Integer>> getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(List<List<Integer>> resultIndex) {
        this.resultIndex = resultIndex;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    public int getCanopy() {
        return canopy;
    }

    public void setCanopy(int canopy) {
        this.canopy = canopy;
    }

        /**
         * 1.if not have a cluster
         * add current vector to cluster1
         * 2.calucate the distance between the new vector and other clusters
         * 3.if(dis<T1) add it to the cluster (not delete from list)
         * if(dis<T2) add it to the cluster
         * repeat  2,3 until the list empty
         * */



}

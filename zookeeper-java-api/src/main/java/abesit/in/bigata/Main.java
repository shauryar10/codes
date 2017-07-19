package abesit.in.bigata;

import org.apache.zookeeper.ZooKeeper;

/**
 * Created by datreont on 7/3/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("My main is working ");


        CRUD_ZK zk = new CRUD_ZK();
//        zk.printMe();
//        zk.zk_Create();
//        zk.zk_Read();
//        zk.zk_Update();
//        zk.zk_Delete();
        zk.connectZ();
        zk.CreateNode();
        zk.UpdateNode();
       // zk.z
       // System.out.println(zk.connectZ());
    }
}
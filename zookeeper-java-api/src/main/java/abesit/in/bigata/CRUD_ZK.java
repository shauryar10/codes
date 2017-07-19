package abesit.in.bigata;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;

/**
 * Created by datreont on 7/3/17.
 */
public class CRUD_ZK extends ZK_Connection {

    ZK_Connection zk_connection = new ZK_Connection();
    private static ZooKeeper zkeeper;


    public void connectZ () {
        try {

            //
            //System.out.println(zkeeper);
            System.out.println("zkeeperConnectZ");
            //return  zkeeper ;

            zoo= zk_connection.connect("192.168.100.205:2181");
            String path = "/MyFirstZnode";
            System.out.println("zkeeperConnected");
            //System.out.println(zkeeper.getSessionId());
            //System.out.println("zkeeperConnected");
//            String a =  "My first zookeeper app" ;
//            byte[] data = a.getBytes();
//            create(path, data);



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("E1");
            //return  zkeeper ;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("E2");
            //return  zkeeper ;
            }

        }

public void CreateNode(){
    try {
        System.out.println("create enter");
        byte[] data = "vanshika".getBytes() ;
        zoo.create("/abesit17",data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("node created");
    } catch (KeeperException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void UpdateNode(){
    try {
        String path = "/abesit17";
        byte[] updateData = "vanshika garg".getBytes();
        zoo.setData(path,updateData,zoo.exists(path,true).getVersion());
        System.out.println("data updated");
    } catch (KeeperException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
 }



    //public static void create(String path, byte[] data) throws
      //      KeeperException,InterruptedException {
        //zkeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
          //      CreateMode.PERSISTENT);
    //}

//    public void zk_Create (){
//        System.out.println("Znode Created ");
//    }
//    public void zk_Read (){
//        System.out.println("Znode Read ");
//    }
//    public void zk_Update (){
//        System.out.println("Znode Updated ");
//    }
//    public void zk_Delete (){
//        System.out.println("Znode Deleted ");
//    }
}

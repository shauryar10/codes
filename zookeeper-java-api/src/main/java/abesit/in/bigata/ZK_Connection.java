package abesit.in.bigata;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by datreont on 7/3/17.
 */
public class ZK_Connection {
    //private String name = "ZK_Connection" ;


    // Local Zookeeper object to access ZooKeeper ensemble
    protected ZooKeeper zoo;
    final CountDownLatch connectionLatch = new CountDownLatch(1);


    public ZooKeeper connect(String host) throws IOException,
            InterruptedException {

        zoo = new ZooKeeper(host, 2000, new Watcher() {

            public void process(WatchedEvent we) {

                if (we.getState() == Event.KeeperState.SyncConnected) {
                    connectionLatch.countDown();
                    System.out.println("connected");
                }
            }
        });

        connectionLatch.await();
        return zoo;
    }

    // Method to disconnect from zookeeper server
    public void close() throws InterruptedException {
        zoo.close();
    }



}

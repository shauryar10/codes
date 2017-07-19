import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

import static java.lang.System.out;

/**
 * Created by vanshika on 12/7/17.
 */
public class Connection {



        private Cluster cluster;
        private Session session;


        public void connect(final String node, final int port)
        {
            this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
            final Metadata metadata = cluster.getMetadata();
            out.printf("Connected to cluster: %s\n", metadata.getClusterName());
            for (final Host host : metadata.getAllHosts())
            {
                out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                        host.getDatacenter(), host.getAddress(), host.getRack());
            }
            session = cluster.connect();
        }
/**
 * Provide my Session.
 *
 *  @return My session.
 */
public Session getSession()
{
    return this.session;
}
        /** Close cluster. */
       // public void close()
        //{
          //  cluster.close();
        //}
    }



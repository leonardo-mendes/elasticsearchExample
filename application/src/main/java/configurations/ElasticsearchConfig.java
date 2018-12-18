package configurations;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.hosts}")
    private String elasticSearchHost;

    @Value("${elasticsearch.port}")
    private Integer elasticSearchPort;

    @Value("${elasticsearch.cluster.name}")
    private String elasticSearchClusterName;

    @Bean
    public Client client() throws UnknownHostException {
        final TransportClient client = new PreBuiltTransportClient(Settings.builder()
                .put("cluster.name", elasticSearchClusterName)
                .build());

        client.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticSearchHost), elasticSearchPort));

        return client;
    }

}

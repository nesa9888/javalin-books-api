import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class ElasticClient {

    private static ElasticsearchClient client = null;

    public static ElasticsearchClient getElasticSearchClientInstance() {
        if(client != null) {
            return client;
        } else {
            RestClient restClient = RestClient.builder(new HttpHost[] {new HttpHost("localhost", 9200)}).build();
            ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
            client = new ElasticsearchClient(transport);

            return client;
        }
    }
}

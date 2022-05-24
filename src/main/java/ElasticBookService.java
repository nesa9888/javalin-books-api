import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

import java.io.IOException;
import java.util.List;

public class ElasticBookService {

    private final ElasticsearchClient client = ElasticClient.getElasticSearchClientInstance();

    public List<Book> getAllBooks() throws IOException {
        SearchResponse<Book> result = client.search( i-> i.index("knige").query(q-> q.matchAll(m->m)), Book.class);
        return result.hits().hits().stream().map(Hit::source).toList();
    }
}

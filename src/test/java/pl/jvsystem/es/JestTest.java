package pl.jvsystem.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class JestTest {

    JestClient client;
    @Before
    public void setUp() throws Exception {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        client = factory.getObject();
    }

    @Test
    public void testName() throws Exception {
        //client.execute(new CreateIndex.Builder("pl").build());
        //DocumentResult result = client.execute(new Index.Builder(new Car("Octavia", "Skoda")).index("pl").type("car").build());

        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "Octavia");
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.query(queryBuilder);
        System.out.println(ssb.toString());
        Search pl = new Search.Builder(ssb.toString()).addIndex("pl").build();
        SearchResult searchResult = client.execute(pl);
        System.out.println(searchResult.getTotal());


    }

    @After
    public void tearDown() throws Exception {
        client.shutdownClient();
    }

    private class Car {
        private String name;
        private String company;

        public Car(String name, String company) {
            this.name = name;
            this.company = company;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }

}

package legacy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
//https://blog.frankel.ch/refactoring-code-testability-example/
@ExtendWith(MockitoExtension.class)
public class CustomersReaderTest {

    @Mock
    private CloseableHttpClient client;
    @Mock
    private CloseableHttpResponse response;
    @Mock
    private HttpEntity entity;
    private CustomersReader customersReader;

    @BeforeEach
    public void setUp() {
        customersReader = new CustomersReader();
    }

    @Test
    public void should_return_json() throws IOException {

        try (var config = mockStatic(Configuration.class);
             var httpclient = mockStatic(HttpClients.class)) {

            config.when(Configuration::getCustomersUrl).thenReturn("crap://test");
            httpclient.when(HttpClients::createDefault).thenReturn(client);
            when(client.execute(any(HttpUriRequest.class))).thenReturn(response);
            when(response.getEntity()).thenReturn(entity);

            InputStream stream = new ByteArrayInputStream("{ \"hello\" : \"world\" }".getBytes());
            when(entity.getContent()).thenReturn(stream);
            JSONObject json = customersReader.read();

            assertThat(json.has("hello"));
            assertThat(json.get("hello")).isEqualTo("world");
        }// the static mocks is not visible outside the block above
    }
}
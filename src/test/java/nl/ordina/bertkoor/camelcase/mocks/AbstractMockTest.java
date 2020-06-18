package nl.ordina.bertkoor.camelcase.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractMockTest {

    private WireMockServer mockServer;
    private int wiremockPort;

    @BeforeAll
    void setupMockServer() {
        mockServer = new WireMockServer(WireMockConfiguration.options().port(0));
        mockServer.start();
        wiremockPort = mockServer.port();
    }

    @AfterAll
    void tearDownMockServer() {
        mockServer.stop();
    }

    int wiremockPort() {
        return wiremockPort;
    }
}
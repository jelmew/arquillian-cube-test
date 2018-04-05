import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.ConfigurableMavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Arquillian.class)
public class HealthCheckIntegrationTest {

    @ArquillianResource
    protected URL deploymentUrl;

    @Deployment(testable = false)
    public static WebArchive createDeployment() throws MalformedURLException {
        ConfigurableMavenResolverSystem resolver = Maven.configureResolver()
                .withRemoteRepo("Artifactory", new URL("http://artifactory.crv4all.com/artifactory/all"), "default");

        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")

                .addClasses(
                StubClass.class
        );
        return war;
    }


    @Test
    public void test() {
        Assert.assertTrue(true);
    }

}

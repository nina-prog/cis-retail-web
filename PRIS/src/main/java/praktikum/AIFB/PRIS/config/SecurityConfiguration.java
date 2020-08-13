package praktikum.AIFB.PRIS.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class represents the server configuration to enable SSL traffic.
 *
 * @author merti
 *
 */
@Configuration
public class SecurityConfiguration {
  /**
   * Enable SSL Traffic.
   *
   * @return new TomcatServletWebServerFactory
   */
  @Bean
  public ServletWebServerFactory servletContainer() {
    // Enable SSL Traffic
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
      @Override
      protected void postProcessContext(Context context) {
        SecurityConstraint securityConstraint = new SecurityConstraint();
        securityConstraint.setUserConstraint("CONFIDENTIAL");
        SecurityCollection collection = new SecurityCollection();
        collection.addPattern("/*");
        securityConstraint.addCollection(collection);
        context.addConstraint(securityConstraint);
      }
    };

    // Add HTTP to HTTPS redirect
    tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
    return tomcat;
  }

  /**
   * Redirect from HTTP to HTTPS. Without SSL, this application used port 8082.
   * With SSL it will use port 8443. So, any request for 8082 needs to be
   * redirected to HTTPS on 8443.
   *
   * @return new connector
   */
  private Connector httpToHttpsRedirectConnector() {
    Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
    connector.setScheme("http");
    connector.setPort(8082);
    connector.setSecure(false);
    connector.setRedirectPort(8443);
    return connector;
  }
}

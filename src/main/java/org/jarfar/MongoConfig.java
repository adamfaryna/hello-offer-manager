package org.jarfar;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * Embedded MongoDB bootstrap configuration.
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
@Configurable
public class MongoConfig {

  private static final MongodStarter starter = MongodStarter.getDefaultInstance();

  @Autowired
  private MongoProperties properties;

  @Autowired(required = false)
  private MongoClientOptions options;

  @Autowired
  private Environment environment;

  @Bean(destroyMethod = "close")
  public MongoClient mongo() throws IOException {
    Net net = mongodProcess().getConfig().net();
    properties.setHost(net.getServerAddress().getHostName());
    properties.setPort(net.getPort());
    return properties.createMongoClient(this.options, this.environment);
  }

  @Bean(destroyMethod = "stop")
  public MongodProcess mongodProcess() throws IOException {
    return mongodExecutable().start();
  }

  @Bean(destroyMethod = "stop")
  public MongodExecutable mongodExecutable() throws IOException {
    return starter.prepare(mongoConfig());
  }

  @Bean
  public IMongodConfig mongoConfig() throws IOException {
    return new MongodConfigBuilder().version(Version.Main.PRODUCTION).build();
  }
}

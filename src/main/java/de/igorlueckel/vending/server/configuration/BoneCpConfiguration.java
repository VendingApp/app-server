package de.igorlueckel.vending.server.configuration;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Igor on 13.05.2015.
 */
@Configuration
public class BoneCpConfiguration {
    @Value("${bonecp.url}")
    private String jdbcUrl;

    @Value("${bonecp.username}")
    private String jdbcUsername;

    @Value("${bonecp.password}")
    private String jdbcPassword;

    @Value("${bonecp.driverClass}")
    private String driverClass;

    @Value("${bonecp.idleMaxAgeInMinutes}")
    private Integer idleMaxAgeInMinutes;

    @Value("${bonecp.idleConnectionTestPeriodInMinutes}")
    private Integer idleConnectionTestPeriodInMinutes;

    @Value("${bonecp.maxConnectionsPerPartition}")
    private Integer maxConnectionsPerPartition;

    @Value("${bonecp.minConnectionsPerPartition}")
    private Integer minConnectionsPerPartition;

    @Value("${bonecp.partitionCount}")
    private Integer partitionCount;

    @Value("${bonecp.acquireIncrement}")
    private Integer acquireIncrement;

    @Value("${bonecp.statementsCacheSize}")
    private Integer statementsCacheSize;

    @Value("${bonecp.maxConnectionAgeInSeconds}")
    private Integer maxConnectionAgeInSeconds;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
        dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
        dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
        dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
        dataSource.setPartitionCount(partitionCount);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setStatementsCacheSize(statementsCacheSize);
        dataSource.setMaxConnectionAgeInSeconds(maxConnectionAgeInSeconds);
        return dataSource;
    }
}

package com.kuropatin.mdb.configuration;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class FlyWayConfiguration {

    private final FirstDataSourceConfiguration firstDataSourceConfiguration;
    private final SecondDataSourceConfiguration secondDataSourceConfiguration;

    @PostConstruct
    public void migrateFlyway() {
        migrate(firstDataSourceConfiguration.firstDataSource(), "db/migrations/first");
        migrate(secondDataSourceConfiguration.secondDataSource(), "db/migrations/second");
    }

    private void migrate(final DataSource dataSource, final String locations) {
        Flyway.configure()
                .dataSource(dataSource)
                .locations(locations)
                .validateOnMigrate(true)
                .validateMigrationNaming(true)
                .schemas("public")
                .defaultSchema("public")
                .load()
                .migrate();
    }
}
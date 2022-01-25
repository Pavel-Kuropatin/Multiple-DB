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
        final Flyway flywayFirst = configureFlyway(firstDataSourceConfiguration.firstDataSource(), "db/migrations/first");
        flywayFirst.migrate();

        final Flyway flywaySecond = configureFlyway(secondDataSourceConfiguration.secondDataSource(), "db/migrations/second");
        flywaySecond.migrate();
    }

    private Flyway configureFlyway(final DataSource dataSource, final String locations) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(locations)
                .ignoreMissingMigrations(false)
                .validateOnMigrate(true)
                .validateMigrationNaming(true)
                .schemas("public")
                .defaultSchema("public")
                .baselineOnMigrate(true)
                .baselineDescription("Flyway Scripts")
                .load();
    }
}
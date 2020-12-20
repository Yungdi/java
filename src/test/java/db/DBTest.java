package db;

import org.assertj.db.api.Assertions;
import org.assertj.db.type.Column;
import org.assertj.db.type.Table;
import org.assertj.db.type.Table.Order;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.Driver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

class DBTest {

    @Test
    void testTable() {
        String url = "jdbc:mariadb://localhost:3307/batch";
        String user = "root";
        String password = "root";
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        Table table = new Table(dataSource, "BATCH_JOB_INSTANCE", new Order[]{
            Order.asc("JOB_INSTANCE_ID")
        });

        Assertions.assertThat(table)
            .column("JOB_INSTANCE_ID")
            .value().isEqualTo(1L)
            .value().isEqualTo(2L);
    }
}

dataSource {
    pooled = true
    //driverClassName = "org.h2.Driver"
    //username = "sa"
    //password = ""
    //driverClassName = "com.mysql.jdbc.Driver"
    //username = "root"
    //password = "root"
    driverClassName = "org.postgresql.Driver"
    username = "postgres"
    password = "senha"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
    //dialect = 'org.hibernate.dialect.MySQLDialect'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/sgd_dev"
           // grails.config.locations = ["file:data/ds_dev.properties"]


        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/sgd_test"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/sgd_prod"

            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}

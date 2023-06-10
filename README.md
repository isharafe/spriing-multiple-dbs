# spriing-multiple-dbs
use multiple dbs in a spring data jpa project

* There are two ways to use multiple databases with spring data jpa
   * Define separate data sources and repositories for each database and use these repositories in the code
     * check branch: multiple-repositories
   * Define separate data sources and select the appropriate data source at run time using AbstractDataSourceRouter
     * check branch: abstract-routing-data-source

create external table gowthambha87edu.sparkhive(name STRING,age INT,address STRING,department STRING)
STORED AS PARQUET
LOCATION '/user/gowthambha87edu/sparkhive/';
select * from gowthambha87edu.sparkhive;
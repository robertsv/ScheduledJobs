import com.speedment.config.parameters.*

name = "test";
packageLocation = "src/main/java";
packageName = "lv.robertsv.speedment";
enabled = true;
expanded = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "webjobs";
    port = 5432;
    typeName = "PostgreSQL";
    username = "postgres";
    enabled = true;
    expanded = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "public";
        schemaName = "public";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        expanded = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "scheduled_job";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "scheduled_job";
            enabled = true;
            expanded = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Long.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "path";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "schedule";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "status";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "enabled";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
        }
    }
}
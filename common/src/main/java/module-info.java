module common {
    exports com.notetakingplus.law.common.entity;
    exports com.notetakingplus.law.common.config;
    exports com.notetakingplus.law.common.repository;

    requires java.persistence;
    requires java.sql;

    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires spring.orm;
    requires spring.data.commons;

    requires com.zaxxer.hikari;
    requires org.flywaydb.core;
    requires jackson.annotations;

    opens com.notetakingplus.law.common.entity to org.hibernate.orm.core, spring.core;
    opens com.notetakingplus.law.common.config to spring.core;
}

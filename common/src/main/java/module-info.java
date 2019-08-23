module common {
    exports com.notetakingplus.law.common.entity;
    exports com.notetakingplus.law.common.config;
    exports com.notetakingplus.law.common.repository;
    requires java.persistence;
    requires spring.context;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires spring.beans;
    requires spring.core;
    requires spring.orm;
    requires org.flywaydb.core;
    requires spring.data.commons;

    opens com.notetakingplus.law.common.entity to org.hibernate.orm.core;

    opens com.notetakingplus.law.common.config to spring.core;
}
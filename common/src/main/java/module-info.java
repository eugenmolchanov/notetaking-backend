module common {
    exports com.notetakingplus.law.common.entity;
    exports com.notetakingplus.law.common.config;
    requires java.persistence;
    requires spring.context;

    opens com.notetakingplus.law.common.entity to org.hibernate.orm.core;

    opens com.notetakingplus.law.common.config to spring.core;
}
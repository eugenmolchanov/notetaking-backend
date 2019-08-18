module common {
    exports com.notetakingplus.law.common.entity;
    requires java.persistence;
    requires spring.context;

    opens com.notetakingplus.law.common.entity to org.hibernate.orm.core;
}
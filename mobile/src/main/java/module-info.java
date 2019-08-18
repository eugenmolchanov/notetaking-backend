module law.mobile.main {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires common;
    requires java.persistence;
    requires spring.boot;
    requires spring.orm;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires spring.beans;
    requires spring.core;
    requires org.flywaydb.core;

    // java.xml.bind and net.bytebuddy are used for resolving persistence unit root URL(exception during initialization)
    requires java.xml.bind;
    requires net.bytebuddy;

    opens com.notetakingplus.law.mobile to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.config to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.dao.impl to spring.core, spring.beans, spring.aop;
    //TODO could declare module 'open' but let's see which modules will require law.mobile.main open
}
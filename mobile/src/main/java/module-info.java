module law.mobile.main {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires common;
    requires java.persistence;
    requires spring.boot;

    // java.xml.bind and net.bytebuddy are used for resolving persistence unit root URL(exception during initialization)
    requires java.xml.bind;
    requires net.bytebuddy;
    requires spring.data.jpa;
    requires spring.web;
    requires spring.beans;

    opens com.notetakingplus.law.mobile to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.config to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.service.impl to spring.beans;
    opens com.notetakingplus.law.mobile.controller to spring.beans, spring.web;
    //TODO could declare module 'open' but let's see which modules will require law.mobile.main open
}
module law.mobile.main {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.data.jpa;
    requires spring.web;
    requires spring.beans;
    requires spring.security.core;
    requires spring.security.web;

    requires common;
    requires lombok;
    requires com.fasterxml.jackson.annotation;
    requires jjwt;
    requires org.apache.tomcat.embed.core;

    opens com.notetakingplus.law.mobile to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.config to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.service.impl to spring.beans;
    opens com.notetakingplus.law.mobile.controller to spring.beans, spring.web;
    //TODO could declare module 'open' but let's see which modules will require law.mobile.main open
}

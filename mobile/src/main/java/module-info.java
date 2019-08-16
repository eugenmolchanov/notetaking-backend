module law.mobile.main {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires common;
    requires java.persistence;
    requires spring.boot;

    opens com.notetakingplus.law.mobile to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.config to spring.core, spring.beans, spring.context;
    opens com.notetakingplus.law.mobile.dao.impl to spring.core, spring.beans;
    //TODO could declare module 'open' but let's see which modules will require law.mobile.main open
}
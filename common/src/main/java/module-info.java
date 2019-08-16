module common {
    exports com.notetakingplus.law.common.entity;
    requires lombok;
    requires java.persistence;
    requires static org.mapstruct.processor; //TODO why is that??? lombok required this
}
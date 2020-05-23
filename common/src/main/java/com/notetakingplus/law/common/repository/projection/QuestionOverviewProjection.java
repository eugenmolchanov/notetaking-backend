package com.notetakingplus.law.common.repository.projection;

import java.util.Objects;

public class QuestionOverviewProjection {

    private final Integer id;
    private final String name;
    private final Integer number;

    public QuestionOverviewProjection(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionOverviewProjection that = (QuestionOverviewProjection) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }
}

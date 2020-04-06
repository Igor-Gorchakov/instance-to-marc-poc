package org.folio.reader.values;

import org.folio.processor.rule.Condition;

import java.util.List;

public abstract class SimpleValue<T> implements FieldValue {
    protected Condition condition;

    public static StringValue of(String string, Condition condition) {
        return new StringValue(string, condition);
    }

    public static ListValue of(List<String> listOfStrings, Condition condition) {
        return new ListValue(listOfStrings, condition);
    }

    public Condition getCondition() {
        return this.condition;
    }

    public abstract T getValue();

    @Override
    public Type getType() {
        return Type.SIMPLE;
    }

    public abstract SubType getSubType();

    public enum SubType {
        STRING,
        LIST_OF_STRING
    }
}
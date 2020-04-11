package org.folio.reader;

import org.folio.processor.rule.DataSource;
import org.folio.processor.rule.Rule;
import org.folio.reader.values.MissingValue;
import org.folio.reader.values.RuleValue;

public abstract class AbstractEntityReader implements EntityReader {

    @Override
    public RuleValue read(Rule rule) {
        if (isSimpleRule(rule)) {
            return readSimpleValue(rule.getDataSources().get(0));
        } else if (isCompositeRule(rule)) {
            return readCompositeValue(rule);
        }
        return MissingValue.getInstance();
    }

    private boolean isSimpleRule(Rule rule) {
        return rule.getDataSources().size() == 1;
    }

    private boolean isCompositeRule(Rule rule) {
        return rule.getDataSources().size() > 1;
    }

    protected abstract RuleValue readCompositeValue(Rule rule);

    protected abstract RuleValue readSimpleValue(DataSource dataSource);
}

package org.folio.processor.translations;

import io.vertx.core.json.JsonObject;
import org.folio.processor.rule.Translation;

public enum TranslationsHolder implements TranslationFunction {
    SET_ALTERNATIVE_TITLE_TYPE() {
        @Override
        public String apply(String value, JsonObject parameters, Settings settings) {
            return value;
        }
    },
    SET_CUSTOM_VALUE() {
        @Override
        public String apply(String value, JsonObject parameters, Settings settings) {
            return parameters.getString("value");
        }
    };

    public static TranslationFunction lookup(Translation translation) {
        return valueOf(translation.getFunction().toUpperCase());
    }
}

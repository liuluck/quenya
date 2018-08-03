package net.quenya.logstash;

import net.logstash.logback.fieldnames.ShortenedFieldNames;

public class CustomFieldNames extends ShortenedFieldNames {

    public CustomFieldNames() {
        setVersion(IGNORE_FIELD_INDICATOR);
        //setLevel(IGNORE_FIELD_INDICATOR);
        setLevelValue(IGNORE_FIELD_INDICATOR);
        //setThread(IGNORE_FIELD_INDICATOR);
    }
}

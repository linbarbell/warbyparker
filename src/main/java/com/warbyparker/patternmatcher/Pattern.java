package com.warbyparker.patternmatcher;

import java.util.*;

/**
 * Pattern for easier comparison and sorting
 */
public class Pattern implements Comparable<Pattern> {
    public static final String WILDCARD = "*";

    private List<String> fields = new ArrayList<>();
    private List<Integer> wildcardLocations = new ArrayList<>();

    public Pattern() {}
    public Pattern(List<String> fields, List<Integer> wildcardLocations) {
        this.fields = fields;
        this.wildcardLocations = wildcardLocations;
    }

    public void add(String field) {
        if (WILDCARD.equals(field)) {
            wildcardLocations.add(fields.size());
        }
        fields.add(field);
    }

    @Override
    public int compareTo(Pattern o) {
        if (o == null) return 1;
        if (wildcardLocations.size() > o.wildcardLocations.size())
            return 1;
        if (wildcardLocations.size() < o.wildcardLocations.size())
            return -1;
        for (int i = 0; i < wildcardLocations.size(); i++) {
            if (wildcardLocations.get(i) > o.wildcardLocations.get(i))
                return -1;
            if (wildcardLocations.get(i) < o.wildcardLocations.get(i))
                return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(",", fields);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pattern pattern = (Pattern) o;
        return Objects.equals(fields, pattern.fields) &&
                Objects.equals(wildcardLocations, pattern.wildcardLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, wildcardLocations);
    }
}

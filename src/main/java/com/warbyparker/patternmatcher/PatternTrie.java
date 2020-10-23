package com.warbyparker.patternmatcher;

import java.util.*;

public class PatternTrie {
    protected final TrieNode<String> root = new TrieNode<>();

    /**
     * Inserts the pattern to the trie
     * @param pattern
     */
    public void insert(List<String> pattern) {
        TrieNode<String> current = root;
        for (String item : pattern) {
            current = current.getChildren().computeIfAbsent(item, c -> new TrieNode<>());
        }
        current.setEnd(true);
    }

    /**
     * Finds the best match for the path recursively
     * @param path
     * @return
     */
    public String find(List<String> path) {
        List<List<String>> allMatches = new ArrayList<>();
        find(root, path, 0, new ArrayList<>(), allMatches);
        return getBestMatch(allMatches);
    }

    private boolean find(TrieNode<String> current, List<String> paths, int i, List<String> matches, List<List<String>> allMatches) {
        if (current == null) return false;
        if (i == paths.size()) {
            if (current.isEnd()) {
                allMatches.add(matches);
                return true;
            }
            return false;
        }

        // search both branches of the trie that has the exact match and also the wildcard match
        List<String> originalMatches = new ArrayList<>(matches);
        boolean exactMatch = find(current, paths, i, matches, allMatches, paths.get(i));
        boolean wildcardMatch = find(current, paths, i, originalMatches, allMatches, Pattern.WILDCARD);
        return exactMatch || wildcardMatch;
    }

    private boolean find(TrieNode<String> current, List<String> paths, int i, List<String> matches, List<List<String>> allMatches, String word) {
        TrieNode<String> node = current.getChildren().get(word);
        matches.add(word);
        return find(node, paths, i + 1, matches, allMatches);
    }

    private String getBestMatch(List<List<String>> allMatches) {
        if (allMatches.isEmpty()) return "NO MATCH";
        TreeSet<Pattern> patterns = new TreeSet<>();

        for (List<String> match : allMatches) {
            Pattern p = new Pattern();
            match.forEach(p::add);
            patterns.add(p);
        }
        return patterns.first().toString();
    }
}

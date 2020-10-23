package com.warbyparker.patternmatcher;

import java.util.HashMap;

public class TrieNode<T> {
    private HashMap<T, TrieNode<T>> children = new HashMap<>();
    private boolean isEnd;

    public HashMap<T, TrieNode<T>> getChildren() {
        return children;
    }

    public void setChildren(HashMap<T, TrieNode<T>> children) {
        this.children = children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", isEnd=" + isEnd +
                '}';
    }
}

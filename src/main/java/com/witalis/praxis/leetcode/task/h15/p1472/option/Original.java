package com.witalis.praxis.leetcode.task.h15.p1472.option;

import com.witalis.praxis.leetcode.task.h15.p1472.content.IBrowserHistory;
import com.witalis.praxis.leetcode.task.h15.p1472.content.BrowserHistoryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 1472
 * Name: Design Browser History
 * URL: <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class BrowserHistory implements IBrowserHistory {
        final LinkedList<String> history;
        final LinkedList<String> forward;

        public BrowserHistory(String homepage) {
            this.history = new LinkedList<>();
            this.forward = new LinkedList<>();

            history.push(homepage);
        }

        @Override
        public void visit(String url) {
            history.push(url);
            forward.clear();
        }

        @Override
        public String back(int steps) {
            while (steps-- > 0 && history.size() > 1) {
                String backURL = history.pop();
                if (backURL != null) forward.push(backURL);
            }

            return history.peek();
        }

        @Override
        public String forward(int steps) {
            while (steps-- > 0 && !forward.isEmpty()) {
                String forwardURL = forward.pop();
                if (forwardURL != null) history.push(forwardURL);
            }

            return history.peek();
        }
    }

    public List<String> process() {
        return BrowserHistoryHandler.process(operations, new BrowserHistory(operations.get(0).getValue()));
    }
}

package com.gvaneyck.runesorter;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A list model for LoL rune pages
 *
 * @author Gvaneyck
 */
public class RunePageListModel implements ListModel<RunePage> {
    List<ListDataListener> listeners = new ArrayList<>();
    List<RunePage> data = new ArrayList<>();

    public RunePageListModel() {}

    public void clear() {
        data.clear();
    }

    public void add(RunePage page) {
        data.add(page);
    }

    public void update() {
        ListDataEvent lde = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, data.size());
        for (ListDataListener l : listeners)
            l.contentsChanged(lde);
    }

    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    public RunePage getElementAt(int index) {
        return data.get(index);
    }

    public int getSize() {
        return data.size();
    }

    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
}

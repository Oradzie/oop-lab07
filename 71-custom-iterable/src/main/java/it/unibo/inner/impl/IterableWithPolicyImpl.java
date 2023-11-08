package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final List<T> elements;

    public IterableWithPolicyImpl(final T[] elements) {
        this.elements = List.of(elements);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private final int stop = IterableWithPolicyImpl.this.elements.size();

            public boolean hasNext() {
                return this.current < this.stop;
            }

            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }

                return elements.get(this.current++);
            }

        };
    }

    public void setIterationPolicy(Predicate<T> filter) {
        // Da implementare
    }
}

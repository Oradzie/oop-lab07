package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final List<T> elements;
    private Predicate<T> iterationPolicy;

    public IterableWithPolicyImpl(final T[] elements) {
        this(elements, new Predicate<T>() {
            public boolean test(T elem) {
                return true;
            }
        });
    }

    public IterableWithPolicyImpl(final T[] elements, Predicate<T> policy) {
        this.elements = List.of(elements);
        this.iterationPolicy = policy;
    }

    public class PolicyIterator implements Iterator<T> {
        private int current = 0;

        public boolean hasNext() {
            while (this.current < elements.size()) {
                T elem = elements.get(current);
                if (iterationPolicy.test(elem)) {
                    return true;
                }
                this.current++;
            }
            return false;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            return elements.get(this.current++);
        }
    }

    public Iterator<T> iterator() {
        return new PolicyIterator();
    }

    public void setIterationPolicy(Predicate<T> filter) {
        this.iterationPolicy = filter;
    }
}

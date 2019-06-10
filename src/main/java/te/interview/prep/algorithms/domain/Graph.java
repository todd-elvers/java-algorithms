package te.interview.prep.algorithms.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// Simplified Graph representation for algorithm testing
public class Graph {
    public List<Vertex> vertices = new ArrayList<>();

    public static class Vertex {
        public List<Vertex> vertices = new ArrayList<>();
        public Map<Vertex, Integer> edgeWeights = new HashMap<>();
        public String name;

        public Vertex(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return name.equals(vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

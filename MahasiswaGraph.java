import java.util.*;

/**
 * Implementasi Graph untuk sistem navigasi kampus
 * Menggunakan adjacency list dan algoritma Dijkstra untuk mencari jalur
 * terpendek
 */
public class MahasiswaGraph {
    private Map<String, List<Edge>> adjacencyList;
    private Map<String, String> lokasiNames; // Mapping kode lokasi ke nama lokasi

    /**
     * Inner class untuk representasi edge (sisi) dalam graph
     */
    private static class Edge {
        String destination;
        int weight; // jarak dalam meter

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    /**
     * Constructor untuk inisialisasi graph
     */
    public MahasiswaGraph() {
        this.adjacencyList = new HashMap<>();
        this.lokasiNames = new HashMap<>();
        inisialisasiDataKampus();
    }

    /**
     * Menambahkan vertex (node) ke dalam graph
     * 
     * @param vertex     Kode lokasi (misal: A, B, C, dst)
     * @param namaLokasi Nama lengkap lokasi
     */
    public void addVertex(String vertex, String namaLokasi) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
            lokasiNames.put(vertex, namaLokasi);
        }
    }

    /**
     * Menambahkan edge (sisi) antara dua vertex
     * 
     * @param source      Vertex asal
     * @param destination Vertex tujuan
     * @param weight      Jarak/berat edge
     */
    public void addEdge(String source, String destination, int weight) {
        // Tambahkan edge dari source ke destination
        if (!adjacencyList.containsKey(source)) {
            addVertex(source, "Lokasi " + source);
        }
        adjacencyList.get(source).add(new Edge(destination, weight));

        // Tambahkan edge dari destination ke source (undirected graph)
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination, "Lokasi " + destination);
        }
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    /**
     * Implementasi algoritma Dijkstra untuk mencari jalur terpendek
     * 
     * @param start Vertex awal
     * @param end   Vertex tujuan
     * @return PathResult yang berisi jalur terpendek dan total jarak
     */
    public PathResult dijkstra(String start, String end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            return null;
        }

        // Priority queue untuk menyimpan vertex dengan jarak terpendek
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(
                Comparator.comparingInt(nd -> nd.distance));

        // Map untuk menyimpan jarak terpendek dari start ke setiap vertex
        Map<String, Integer> distances = new HashMap<>();

        // Map untuk menyimpan vertex sebelumnya dalam jalur terpendek
        Map<String, String> previous = new HashMap<>();

        // Set untuk vertex yang sudah diproses
        Set<String> processed = new HashSet<>();

        // Inisialisasi jarak
        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        pq.offer(new NodeDistance(start, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            String currentVertex = current.vertex;

            if (processed.contains(currentVertex)) {
                continue;
            }

            processed.add(currentVertex);

            // Jika sudah mencapai tujuan, hentikan pencarian
            if (currentVertex.equals(end)) {
                break;
            }

            // Periksa semua tetangga
            for (Edge edge : adjacencyList.get(currentVertex)) {
                String neighbor = edge.destination;

                if (!processed.contains(neighbor)) {
                    int newDistance = distances.get(currentVertex) + edge.weight;

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previous.put(neighbor, currentVertex);
                        pq.offer(new NodeDistance(neighbor, newDistance));
                    }
                }
            }
        }

        // Rekonstruksi jalur
        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        // Jika tidak ada jalur yang ditemukan
        if (path.size() == 1 && !path.get(0).equals(start)) {
            return null;
        }

        return new PathResult(path, distances.get(end), lokasiNames);
    }

    /**
     * Menampilkan semua lokasi yang tersedia
     */
    public void tampilkanSemuaLokasi() {
        System.out.println("\n=== DAFTAR LOKASI KAMPUS ===");
        System.out.println("----------------------------");
        for (Map.Entry<String, String> entry : lokasiNames.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println("----------------------------");
    }

    /**
     * Menampilkan adjacency list (untuk debugging)
     */
    public void tampilkanAdjacencyList() {
        System.out.println("\n=== ADJACENCY LIST GRAPH ===");
        for (Map.Entry<String, List<Edge>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Edge edge : entry.getValue()) {
                System.out.print(edge.destination + "(" + edge.weight + "m) ");
            }
            System.out.println();
        }
    }

    /**
     * Inisialisasi data kampus dengan lokasi-lokasi dan jarak antar lokasi
     */
    private void inisialisasiDataKampus() {
        // Tambahkan vertex (lokasi)
        addVertex("A", "Gerbang Utama Kampus");
        addVertex("B", "Parkiran Motor");
        addVertex("C", "Gedung Rektorat");
        addVertex("D", "Perpustakaan");
        addVertex("E", "Kantin");
        addVertex("F", "Gedung Fakultas Teknik");
        addVertex("G", "Lapangan Basket");
        addVertex("H", "Asrama Mahasiswa");
        addVertex("I", "Gedung Laboratorium");
        addVertex("J", "Masjid Kampus");

        // Tambahkan edge (jalur antar lokasi)
        addEdge("A", "B", 50); // Gerbang ke Parkiran
        addEdge("A", "C", 100); // Gerbang ke Rektorat
        addEdge("B", "C", 80); // Parkiran ke Rektorat
        addEdge("B", "D", 120); // Parkiran ke Perpustakaan
        addEdge("C", "D", 60); // Rektorat ke Perpustakaan
        addEdge("C", "E", 90); // Rektorat ke Kantin
        addEdge("D", "E", 70); // Perpustakaan ke Kantin
        addEdge("D", "F", 150); // Perpustakaan ke Fakultas Teknik
        addEdge("E", "F", 100); // Kantin ke Fakultas Teknik
        addEdge("E", "G", 80); // Kantin ke Lapangan Basket
        addEdge("F", "G", 120); // Fakultas Teknik ke Lapangan Basket
        addEdge("F", "I", 200); // Fakultas Teknik ke Laboratorium
        addEdge("G", "H", 180); // Lapangan Basket ke Asrama
        addEdge("H", "I", 150); // Asrama ke Laboratorium
        addEdge("H", "J", 100); // Asrama ke Masjid
        addEdge("I", "J", 120); // Laboratorium ke Masjid
        addEdge("A", "J", 300); // Gerbang ke Masjid (jalur alternatif)
    }

    /**
     * Inner class untuk priority queue dalam algoritma Dijkstra
     */
    private static class NodeDistance {
        String vertex;
        int distance;

        NodeDistance(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    /**
     * Class untuk menyimpan hasil pencarian jalur terpendek
     */
    public static class PathResult {
        public final List<String> path;
        public final int totalDistance;
        private final Map<String, String> lokasiNames;

        public PathResult(List<String> path, int totalDistance, Map<String, String> lokasiNames) {
            this.path = path;
            this.totalDistance = totalDistance;
            this.lokasiNames = lokasiNames;
        }

        /**
         * Menampilkan hasil jalur terpendek
         */
        public void tampilkanHasil() {
            if (path == null || path.isEmpty()) {
                System.out.println("Tidak ada jalur yang ditemukan!");
                return;
            }

            System.out.println("\n=== JALUR TERPENDEK DITEMUKAN ===");
            System.out.println("Jalur: " + String.join(" → ", path));
            System.out.println("Jarak total: " + totalDistance + " meter");
            System.out.println("(" + String.format("%.1f", totalDistance / 1000.0) + " km)");

            System.out.println("\nDetail rute:");
            for (int i = 0; i < path.size(); i++) {
                String kode = path.get(i);
                String nama = lokasiNames.get(kode);
                System.out.printf("%d. %s - %s\n", i + 1, kode, nama);
            }
        }
    }
}

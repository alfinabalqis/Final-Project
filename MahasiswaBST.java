import java.util.ArrayList;
import java.util.List;

/**
 * BST sederhana untuk index sekunder berdasarkan NIM (String).
 * Menyimpan pasangan (key=NIM, value=Mahasiswa).
 */
public class MahasiswaBST {

    private static class Node {
        String key;
        Mahasiswa value;
        Node left, right;

        Node(String key, Mahasiswa value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    /** Insert atau update value bila key sudah ada */
    public void insert(String key, Mahasiswa value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, String key, Mahasiswa value) {
        if (node == null) return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insertRec(node.left, key, value);
        else if (cmp > 0) node.right = insertRec(node.right, key, value);
        else node.value = value; // key sama → update value
        return node;
    }

    /** Cari berdasarkan key (NIM) */
    public Mahasiswa search(String key) {
        Node cur = root;
        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if (cmp == 0) return cur.value;
            cur = (cmp < 0) ? cur.left : cur.right;
        }
        return null;
    }

    /** Hapus berdasarkan key, return true jika ada yang terhapus */
    public boolean delete(String key) {
        int before = size();
        root = deleteRec(root, key);
        return size() < before;
    }

    private Node deleteRec(Node node, String key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = deleteRec(node.left, key);
        else if (cmp > 0) node.right = deleteRec(node.right, key);
        else {
            // ketemu node yang dihapus
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // dua anak: ambil pengganti dari successor (min di subtree kanan)
            Node succ = min(node.right);
            node.key = succ.key;
            node.value = succ.value;
            node.right = deleteRec(node.right, succ.key);
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    /** Traversal inorder → list Mahasiswa terurut berdasarkan NIM */
    public List<Mahasiswa> inorder() {
        List<Mahasiswa> out = new ArrayList<>();
        inorderRec(root, out);
        return out;
    }

    private void inorderRec(Node node, List<Mahasiswa> out) {
        if (node == null) return;
        inorderRec(node.left, out);
        out.add(node.value);
        inorderRec(node.right, out);
    }

    /** Ukuran pohon (opsional, untuk validasi) */
    public int size() {
        return count(root);
    }

    private int count(Node node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
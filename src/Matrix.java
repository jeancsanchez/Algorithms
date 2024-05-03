/** @noinspection SpellCheckingInspection*/
class Matrix {
    public static void main(String[] args) {
//        int[][] matrix = new int[][];

    }

    /**
     * Quando eu quiser tratar o valor no atual. Ex. Printar cada elemento da arvore.
     */
    public static void preOrder(TreeNode root) {
        if(root == null) return;

        println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * Quando eu quiser fazer uma logica considerando a ordem correta.
     * No caso da esquerda pra direita quando do menor para o maior.
     * Vai toldo pra esquerda depois volta printando o root depois a direita.
     */

    public static void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        println(root.val);
        inOrder(root.right);
    }

    /**
     * O root vai ser sempre o ultimo a ser chamado.
     * Primeiro esgota tudo da esquerda depois volta printando,
     * indo direto pra direita e deixando o root por ultimo.
     */
    public static void postOrder(TreeNode root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        println(root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void println(Object obj) {
        System.out.println(obj == null ? "null" : obj);
    }
}
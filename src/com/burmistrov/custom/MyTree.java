package com.burmistrov.custom;

import java.util.*;

/** N-арное дерево */
public class MyTree {

    /** Название узла */
    private final String label;
    /** Количество наследников у узла */
    private final int N;
    /** Лист наследников */
    private final ArrayList<MyTree> children;

    /**
     * Конструктор
     * @param label название узла
     * @param N количество наследников
     */
    public MyTree(String label, int N) {
        this.label = label;
        this.N = N;
        children = new ArrayList<>(N);
    }

    /**
     * Добавляет наследника
     * @param label название наследника
     */
    public void addChild(String label) {
        if (children.size() < N) {
            children.add(new MyTree(label, N));
        }
    }

    /**
     * Получает наследника по номеру элемента
     * @param index номер элемента
     * @return наследника
     */
    public MyTree getChild(int index) {
        if (index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    /**
     * Обход дерева в глубину с выводом в консоль
     * @param root корень дерева
     */
    public static void printPreOrderWalk(MyTree root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while (!stack.empty()) {
            Pair current = stack.pop();
            MyTree node = current.node;
            int depth = current.depth;
            printWithSpaces(depth, node.label);
            ArrayList<MyTree> children = node.children;

            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(new Pair(children.get(i), depth + 1));
            }
        }
    }

    /**
     * Обход дерева в ширину с выводом в консоль
     * @param root корень дерева
     */
    public static void printBFS(MyTree root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.remove();
            MyTree node = current.node;
            int depth = current.depth;
            printWithSpaces(depth, node.label);
            ArrayList<MyTree> children = node.children;

            for (MyTree child : children) {
                queue.add(new Pair(child, depth + 1));
            }
        }
    }

    /**
     * Выводит узел в консоль с отступом
     * @param depth глубина узла
     * @param label название узла
     */
    private static void printWithSpaces(int depth, String label) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }
        System.out.println(label);
    }

    /** Отступ узла */
    private static class Pair {
        MyTree node;
        int depth;

        /**
         * Конструктор
         * @param node узел
         * @param depth глубина узла
         */
        Pair(MyTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }

    }

}




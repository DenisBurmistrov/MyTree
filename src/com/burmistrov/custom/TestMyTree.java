package com.burmistrov.custom;

public class TestMyTree {

    /** Заполняет дерево и выводит в консоль */
    public static void main(String[] args) {
        MyTree root = new MyTree("Ресторан", 3);

        root.addChild("Меню");
        root.getChild(0).addChild("Холодные закуски");
        root.getChild(0).getChild(0).addChild("Салат");
        root.getChild(0).getChild(0).addChild("Ассорти из сыров");
        root.getChild(0).getChild(0).addChild("Ассорти из ветчин");
        root.getChild(0).addChild("Горячие блюда");
        root.getChild(0).getChild(1).addChild("Паста");
        root.getChild(0).getChild(1).addChild("Рыба");
        root.getChild(0).getChild(1).addChild("Мясо");
        root.getChild(0).getChild(1).addChild("Пицца");  // не добавится, так как N = 3
        root.addChild("Бар");
        root.getChild(1).addChild("Безалкогольные");
        root.getChild(1).getChild(0).addChild("Сок");
        root.getChild(1).getChild(0).addChild("Лимонад");
        root.getChild(1).addChild("Алкогольные");
        root.getChild(1).getChild(1).addChild("Крепкое");
        root.getChild(1).getChild(1).addChild("Коктейли");

        MyTree.printPreOrderWalk(root);

        MyTree.printBFS(root);
    }
}
